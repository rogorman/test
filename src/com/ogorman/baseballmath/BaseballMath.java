package com.ogorman.baseballmath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BaseballMath extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button newGame = (Button) findViewById(R.id.newgame);
        Button continueGame = (Button) findViewById(R.id.continuegame);
        Button viewOldGame = (Button) findViewById(R.id.viewoldgame);
        
        newGame.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), NewGameActivity.class);
                startActivityForResult(intent, 0);
			}
		});
        
        continueGame.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), ContinueGameActivity.class);
                startActivityForResult(intent, 0);
				
			}
		});
        
        viewOldGame.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(v.getContext(), ViewOldGameActivity.class);
                startActivityForResult(intent, 0);
				
			}
		});
        
        
//        Resources res = getResources(); // Resource object to get Drawables
//        TabHost tabHost = getTabHost();  // The activity TabHost
//        TabHost.TabSpec spec;  // Resusable TabSpec for each tab
//        Intent intent;  // Reusable Intent for each tab
//
//        // Create an Intent to launch an Activity for the tab (to be reused)
//        intent = new Intent().setClass(this, ListPlayersActivity.class);
//
//        // Initialize a TabSpec for each tab and add it to the TabHost
//        spec = tabHost.newTabSpec("listplayers").setIndicator("Players List",
//                          res.getDrawable(R.drawable.tab_players))
//                      .setContent(intent);
//        tabHost.addTab(spec);
//
//        // Do the same for the other tabs
//        intent = new Intent().setClass(this, PlayersAddActivity.class);
//        spec = tabHost.newTabSpec("addplayers").setIndicator("Add Players",
//                          res.getDrawable(R.drawable.tab_players))
//                      .setContent(intent);
//        tabHost.addTab(spec);
//
//        tabHost.setCurrentTab(1);
    }
}