package com.ogorman.baseballmath;

import com.ogorman.baseballmath.R;
import com.ogorman.baseballmath.R.id;
import com.ogorman.baseballmath.R.layout;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

public class ListPlayersActivity extends ListActivity {
	
	private baseBallDbAdapter mDbHelper;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //TextView textview = new TextView(this);
        //textview.setText("This is the Players List tab");
        setContentView(R.layout.list_players);
        
        mDbHelper = new baseBallDbAdapter(this);
        mDbHelper.open();
        
        fillPlayerNames();
        
        
    }

	private void fillPlayerNames() {
        // Get all of the rows from the database and create the item list
        Cursor playersCursor = mDbHelper.fetchAllPlayers();
        startManagingCursor(playersCursor);

        // Create an array to specify the fields we want to display in the list (only TITLE)
        String[] from = new String[]{baseBallDbAdapter.KEY_NAME};

        // and an array of the fields we want to bind those fields to (in this case just text1)
        int[] to = new int[]{R.id.textplayer};

        // Now create a simple cursor adapter and set it to display
        SimpleCursorAdapter notes = 
            new SimpleCursorAdapter(this, R.layout.player_row, playersCursor, from, to);
        setListAdapter(notes);
		
	}
}
