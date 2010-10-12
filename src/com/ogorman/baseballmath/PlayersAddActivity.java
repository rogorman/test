package com.ogorman.baseballmath;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PlayersAddActivity extends Activity{
	
    private EditText mNameText;
    private Long mRowId;
    private baseBallDbAdapter mDbHelper;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        	mDbHelper = new baseBallDbAdapter(this);
        	mDbHelper.open();
//        TextView textview = new TextView(this);
//        textview.setText("This is the Players Add tab");
        	setContentView(R.layout.add_player);
        	
        	Button confirmNewPlayer = (Button) findViewById(R.id.savenewplayer);
        	Button cancelNewPlayer = (Button) findViewById(R.id.cancelnewplayer);
        	mNameText = (EditText) findViewById(R.id.newplayerentry); 
        	
        	confirmNewPlayer.setOnClickListener(new View.OnClickListener() {
				
                public void onClick(View view) {
                    //setResult(RESULT_OK);
                    finish();
                }
			});
        	
        	cancelNewPlayer.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					
				}
			});
        	
    }
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		saveState();
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		saveState();
		outState.putSerializable(baseBallDbAdapter.KEY_ROWID, mRowId);
	}
	
	private void saveState() {
		String name = mNameText.getText().toString();
		
		//if (mRowId == null) {
			long id = mDbHelper.createPlayer(name);
			if (id > 0) {	mRowId = id; }
		//} else
		//{
		//	mDbHelper.updateNote(mRowId, name);
		//}
	}
}
