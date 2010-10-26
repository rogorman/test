package com.ogorman.baseballmath;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewGameActivity extends Activity{
	
	private static final int clubs = 0; 
	private static final int teams = 1;
	private static final int GONE = 8;
	
	private baseBallDbAdapter mDbHelper;
	private LinearLayout teamSection;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_game);
        teamSection = (LinearLayout) findViewById(R.id.teamsection);
        teamSection.setVisibility(GONE);
        
        mDbHelper = new baseBallDbAdapter(this);
        mDbHelper.open();
        
        Button selectClub = (Button) findViewById(R.id.selectclub);
        Button addClub = (Button) findViewById(R.id.addclub);
        
        selectClub.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				showDialog(clubs);
			}
        });
        
        addClub.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), ClubsAddActivity.class);
                startActivityForResult(intent, 0);
        	}
        });
	}
	
	protected Dialog onCreateDialog(int id) {
		Dialog dialog = null;
		switch (id) {
			case clubs:
			{
				// Get list of clubs for dialog display
				final Cursor clubsCursor = mDbHelper.fetchAllClubs();
				startManagingCursor(clubsCursor);
				
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setTitle("Select Club");
				builder.setCursor(clubsCursor, new DialogInterface.OnClickListener() {
				    public void onClick(DialogInterface dialog, int item) {
				    	//Toast.makeText(getApplicationContext(), item[item], Toast.LENGTH_SHORT).show();
				    	TextView clubSelected = (TextView) findViewById(R.id.clubselected);
				    	((Cursor) clubsCursor).moveToPosition(item);
				    	clubSelected.setText(((Cursor) clubsCursor).getString(((Cursor) clubsCursor).getColumnIndex(baseBallDbAdapter.KEY_NAME)));
				    	teamSection.setVisibility(0);
				    }
				}, baseBallDbAdapter.KEY_NAME);
	
				AlertDialog alert = builder.create();
		        alert.show();
		     }
			case teams:
			{
				
			}
		}
		return dialog;
	}
	
	protected Dialog onPrepareDialog() {
		return null;
		
	}
	
}

