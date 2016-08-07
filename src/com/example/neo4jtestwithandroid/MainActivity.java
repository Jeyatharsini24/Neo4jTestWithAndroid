package com.example.neo4jtestwithandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.jeya.database.graph.neo4j.Neo4jRestInterface;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		new CheckOnDatabase().execute("");
	}
	
	private class CheckOnDatabase extends AsyncTask<String, Void, Integer> {
		@Override
		public Integer doInBackground(String... params) {
			//Neo4jRestInterface.connect("");
			Neo4jRestInterface.updateNode();
			return new Integer(7);
		}

		@Override
		protected void onPostExecute(Integer result) {
			// create a bundle to pass user input within that
	 		/*Bundle toPassNextActivity = new Bundle();
	 		// put user input into bundle with keys
	 		toPassNextActivity.putSerializable("mytest",result);
	 		// activity is opened from this to RouteFinder class
	 		Intent openStartingPoint = new Intent(Start.this, MainActivity.class);
	 		// put bundle into the activity
	 		openStartingPoint.putExtras(toPassNextActivity);
	 		// start the new activity
	 		startActivity(openStartingPoint);*/
		}
	}
}
