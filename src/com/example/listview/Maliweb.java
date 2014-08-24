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


public class Maliweb extends Activity{
	WebView webview;
	
	String[] mUrls = new String[] {"http://www.maliweb.net/economie/banque-mond-fmi/washington-fmi-mali-meme-longueur-donde-454922.html", 
            "www.maliweb.net"};
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mywebview);
		
		Intent intent = getIntent();
		String[] stringArray = intent.getStringArrayExtra("SITE_CHOISI");
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mUrls);
		final ListView list = (ListView)findViewById(R.id.list);
		list.setAdapter(adapter);

		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			       
				    String url = mUrls[position];
				    Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
					startActivity(webIntent);		
	 }
	
});
	}
}
	