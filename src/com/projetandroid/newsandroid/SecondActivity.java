package com.projetandroid.newsandroid;

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

public class SecondActivity extends Activity{
	WebView webview;
	
	private String[] mUrls = {"http://www.maliweb.net/economie/banque-mond-fmi/washington-fmi-mali-meme-longueur-donde-454922.html", 
            "http://www.rfi.fr/moyen-orient/20140810-gaza-israel-palestine-guerre-morts-manifestations-tel-aviv-paris-boycott/", 
            "http://www.tv5.org/cms/chaine-francophone/info/p-1911-Irak-Nouvelles-frappes-americaines-sur-les-jihadistes-Fabius-appelle-a-l-unite.htm?&rub=2&xml=newsmlmmd.urn.newsml.afp.com.20140810.0fa85d3f.34d5.414a.a756.5cb77498298b.xml",
            "http://maliactu.net/corruption-ibk-ordonne-la-revision-de-tous-les-contrats-signes-par-soumeylou-boubeye-maiga/",
            "http://www.france24.com/fr/urgent/20140810-irak-leiil-a-assassine-moins-500-yazidis-a-inhumes-fosses-communes-ministere-irakien-droits-lhomme/"};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mywebview);
		
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.SITE_CHOISI);
		
        TextView textView = new TextView(this);
		textView.setText(message);
        
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
	

	
