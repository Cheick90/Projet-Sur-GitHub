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
			private String[] mUrls = {"http://www.maliweb.net", "http://www.rfi.fr", "http://www.maliactu.com",
					"http://www.france24.fr", "http://www.tv5monde.org"};
		         
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
					
					    String url = mUrls[position];
						Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
						startActivity(webIntent);
			       
				}

				
			});

				        
		}
}