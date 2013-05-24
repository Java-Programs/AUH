/**
 * 
 */
package it.devteam.auh;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * @author Marco
 *
 */
public class TurismoActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		ListView listView = (ListView) findViewById(R.id.listViewDemo);
		
		String[] array = { "Cacca", "Pupu", "Piscia", "Fra"};

		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
				R.layout.row, R.id.textViewList, array);
		listView.setAdapter(arrayAdapter);

	}

	
}
