package com.example.listview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;


public class rfi extends Activity{
	WebView webview;
	
	String[] mUrls1 = new String[] {"http://www.rfi.fr/moyen-orient/20140810-gaza-israel-palestine-guerre-morts-manifestations-tel-aviv-paris-boycott/",  
            "www.rfi.net"};
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mywebview);
		
		Intent intent = getIntent();
		String[] stringArray = intent.getStringArrayExtra("SITE_CHOISI");
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mUrls1);
		final ListView list = (ListView)findViewById(R.id.list);
		list.setAdapter(adapter);

		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			       
				    String url = mUrls1[position];
				    Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
					startActivity(webIntent);		
	 }
	
});
	}
}
	