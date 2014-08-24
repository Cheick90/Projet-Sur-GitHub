package com.example.listview;


import android.app.Activity;
import android.content.ClipData.Item;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

		public class MainActivity extends Activity{
			
			protected static final String SITE_CHOISI = "com.projetandroid.newsandroid";
			ListView list ;
			private String[] mStrings = {
		            "Maliweb", "RFI", "Maliactu", "TV5 Monde", "France 24",
		         };
			
			public void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				        setContentView(R.layout.activity_main);
			
		    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrings);
			ListView list = (ListView)findViewById(R.id.list);
			list.setAdapter(adapter);
			
			list.setOnItemClickListener(new OnItemClickListener() {
				@Override
				 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	        	    CallFunc(position);
	        	}

				private void CallFunc(int position) {

				Intent intent = getIntent();
		        	switch (position) {
		        	  case 0 :
		        	    intent = new Intent(MainActivity.this, Maliweb.class);
		        	    startActivity(intent);
		        	break;
		        	  case 1 :
		        	   intent = new Intent(MainActivity.this, rfi.class);
		        	   startActivity(intent);
		        	break;
		        	  case 2 :
		                  intent = new Intent(MainActivity.this, Maliactu.class);
		                  startActivity(intent);
		        	break;
		        	  case 3 :
		                  intent = new Intent(MainActivity.this, TV5Monde.class);
		                  startActivity(intent);
		            break;
		             case 4 :
		                  intent = new Intent(MainActivity.this, France24.class);
		                  startActivity(intent);
		        	 
		        	}
		        	if(intent != null)
		        	    startActivity(intent);
				}

				
			});

				        
		}
}