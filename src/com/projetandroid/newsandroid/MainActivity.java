package com.projetandroid.newsandroid;

import android.app.Activity;
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
			ListView list ;
			private String[] mStrings = {
		            "Maliweb", "RFI", "Maliactu", "TV5 Monde", "France 24",
		         };
<<<<<<< HEAD
			private String[] mUrls = {"http://www.maliweb.net", "http://www.rfi.fr", "http://www.maliactu.com",
					"http://www.france24.fr", "http://www.tv5monde.org"};
		         
=======
			
>>>>>>> parent of c6bb3a6... Revert "ListView"
			public void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				        setContentView(R.layout.main);
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrings);
			final ListView list = (ListView)findViewById(R.id.list);
			list.setAdapter(adapter);
			
			list.setOnItemClickListener(new OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
<<<<<<< HEAD
					
					position=1;
				    String url_maliweb = mUrls[1]; 
					Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse( url_maliweb )); 
			        startActivity(webIntent);
			        
			        position=2;
			        String url_rfi = mUrls[2]; 
					Intent webIntent1 = new Intent(Intent.ACTION_VIEW, Uri.parse( url_rfi )); 
			        startActivity(webIntent1);
			        
			        position=3;
			        String url_maliactu = mUrls[3]; 
					Intent webIntent2 = new Intent(Intent.ACTION_VIEW, Uri.parse( url_maliactu )); 
			        startActivity(webIntent2);
			        
			        position=4;
			        String url_france24 = mUrls[4]; 
					Intent webIntent4 = new Intent(Intent.ACTION_VIEW, Uri.parse( url_france24 )); 
			        startActivity(webIntent4);
			        
			        position=5;
			        String url_tv5monde = mUrls[5]; 
					Intent webIntent3 = new Intent(Intent.ACTION_VIEW, Uri.parse( url_tv5monde )); 
			        startActivity(webIntent3);
			        
			       
=======
					String url = "http://www.maliweb.com"; 
					Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse( url )); 
			        startActivity(webIntent);
>>>>>>> parent of c6bb3a6... Revert "ListView"
				}

				
			});

				        
		}
}