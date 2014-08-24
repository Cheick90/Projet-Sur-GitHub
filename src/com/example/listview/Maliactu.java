package com.example.listview;



import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class Maliactu extends Activity{
	WebView webview;
	
	String[] mUrls = new String[] {
            "http://maliactu.net/corruption-ibk-ordonne-la-revision-de-tous-les-contrats-signes-par-soumeylou-boubeye-maiga/",
            };
	

	
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
	

	
