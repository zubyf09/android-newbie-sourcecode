package pete.apps.study.droid10;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainScreen extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		// sample test Facebook installed or not
		if(Utils.handleRequiredApp(this, getPackageManager(), "com.facebook.katana")) {
			Toast.makeText(this, "Facebook is installed", Toast.LENGTH_SHORT).show();
		}
    }
}
