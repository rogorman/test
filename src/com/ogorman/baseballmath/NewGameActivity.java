package com.ogorman.baseballmath;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class NewGameActivity extends Activity{
	
	private static final int clubs = 0; 
	private static final int teams = 1;
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_game);
        
        Button selectClub = (Button) findViewById(R.id.selectclub);
        
        selectClub.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				showDialog(clubs);
			}
        });
        


	}
	
	protected Dialog onCreateDialog(int id) {
		Dialog dialog = null;
		switch (id) {
			case clubs:
			{
				final CharSequence[] items = {"Red", "Green", "Blue"};
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
				builder.setTitle("Select Club");
				builder.setItems(items, new DialogInterface.OnClickListener() {
				    public void onClick(DialogInterface dialog, int item) {
				        Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
				    }
				});
	
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

