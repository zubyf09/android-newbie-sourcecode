package pete.android.study;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Main extends Activity {
    // constants
	static final String STATUS_ON = "Airplane Mode: ON";
	static final String STATUS_OFF = "Airplane Mode: OFF";
	
	static final String TURN_ON = "Turn ON";
	static final String TURN_OFF = "Turn OFF";
	
	// controls
	TextView tvStatus;
	ToggleButton togState;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // load controls
        tvStatus = (TextView)findViewById(R.id.tvStatus);
        togState = (ToggleButton)findViewById(R.id.togState);
        // update UI at first time loading
        updateUI(isAirplaneMode());
        // set click event for button
        togState.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				// check current state first
				boolean state = isAirplaneMode();
				// toggle the state
				toggleAirplaneMode(state);
				// update UI to new state
				updateUI(!state);				
			}
		});
    }
    
    public void toggleAirplaneMode(boolean state) {
    	// toggle airplane mode
    	Settings.System.putInt(this.getContentResolver(),Settings.System.AIRPLANE_MODE_ON, state ? 0 : 1);

    	// broadcast an intent to inform
    	Intent intent = new Intent(Intent.ACTION_AIRPLANE_MODE_CHANGED);
    	intent.putExtra("state", !state);
    	sendBroadcast(intent);
    }
    
    public void updateUI(boolean state) {
    	if(state) {
    		tvStatus.setText(STATUS_ON);
    		togState.setText(TURN_OFF);    		
    	} else {
    		tvStatus.setText(STATUS_OFF);
    		togState.setText(TURN_ON);
    	}
    }
    
    public boolean isAirplaneMode() {
    	return Settings.System.getInt(this.getContentResolver(), Settings.System.AIRPLANE_MODE_ON, 0) == 1;
    }
}