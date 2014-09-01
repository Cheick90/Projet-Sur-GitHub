package com.example.newsandroid;



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
			private String[] mStrings = {"Maliweb", "Maliactu","RFI",  "TV5 Monde", "France 24"};
		
			
			public void onCreate (Bundle savedInstanceState) {
						super.onCreate(savedInstanceState);
				        setContentView(R.layout.activity_main);
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrings);
			ListView list = (ListView)findViewById(R.id.list);
			list.setAdapter(adapter);
			
			list.setOnItemClickListener(new OnItemClickListener() {
				@Override
				 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	        	   

				Intent intent = new Intent(MainActivity.this, SecondActivity.class);
				intent.putExtra(SITE_CHOISI, mStrings[position]);
				startActivity(intent);
				}
				
			});
		
		}
				        
}
