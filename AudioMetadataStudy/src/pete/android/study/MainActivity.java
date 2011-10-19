package pete.android.study;

import android.app.Activity;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView tvMain = (TextView)findViewById(R.id.tvMain);
        // load data file
        MediaMetadataRetriever metaRetriever = new MediaMetadataRetriever();
        metaRetriever.setDataSource("/sdcard/music.mp3");
        
        String out = "";
        // get mp3 info
        out += metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);
        out += "\n";
        out += metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ARTIST);
        out += "\n";
        out += metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_ALBUM);
        out += "\n";
        out += metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_YEAR);
        out += "\n";
        // convert duration to minute:seconds
        String duration = metaRetriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
        long dur = Integer.parseInt(duration);
        String seconds = String.valueOf(dur % 60);
        String minutes = String.valueOf(dur / 60000);
        out += "Length: [ " + minutes + "m" + seconds + "s ]\n";        
        
        // close object
        metaRetriever.release();
        // display output
        tvMain.setText(out);
    }
}