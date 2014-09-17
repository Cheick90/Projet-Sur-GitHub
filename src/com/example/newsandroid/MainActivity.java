package com.example.newsandroid;



import android.app.Activity;
import android.app.ListActivity;
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

public class MainActivity extends ListActivity {
			
			protected static final String SITE_CHOISI = "com.projetandroid.newsandroid";
			
			private String[] mStrings = {"Maliweb", "Maliactu","abamako",  "Malijet", "RFI", "Jeune Afrique", "TV5 Monde",
					"EURONEWS", "Le FIGARO", "Le POINT", "BAMADA","FRANCE24"};
			
			@Override
			public void onCreate (Bundle savedInstanceState) {
						super.onCreate(savedInstanceState);
				        
						setListAdapter(new ListSiteActivite(this, mStrings));
			}			
			
     
			@Override      
			protected void onListItemClick (ListView l, View v, int position, long id) {

					Intent intent = new Intent(MainActivity.this, SecondActivity.class);
					intent.putExtra(SITE_CHOISI, mStrings[position]);
					startActivity(intent);
					}
					
				
			
						
						
						
		}



			       
