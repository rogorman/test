package com.ogorman.baseballmath;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ogorman.baseballmath.R;

public class ClubsAddActivity extends Activity{
	
    private EditText mNameText;
    private Long mRowId;
    private baseBallDbAdapter mDbHelper;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        	mDbHelper = new baseBallDbAdapter(this);
        	mDbHelper.open();

        	setContentView(R.layout.add_club);
        	
        	Button confirmNewClub = (Button) findViewById(R.id.savenewclub);
        	Button cancelNewClub = (Button) findViewById(R.id.cancelnewclub);
        	mNameText = (EditText) findViewById(R.id.newclubentry); 
        	
        	confirmNewClub.setOnClickListener(new View.OnClickListener() {
				
                public void onClick(View view) {
                    //setResult(RESULT_OK);
                    finish();
                }
			});
        	
        	cancelNewClub.setOnClickListener(new View.OnClickListener() {
				
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
			long id = mDbHelper.createClub(name);
			if (id > 0) {	mRowId = id; }
		//} else
		//{
		//	mDbHelper.updateNote(mRowId, name);
		//}
	}
}
