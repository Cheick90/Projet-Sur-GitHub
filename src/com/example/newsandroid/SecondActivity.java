package com.example.newsandroid;

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
	
	String[] mUrls = new String[] {"http://www.maliweb.net/economie/banque-mond-fmi/washington-fmi-mali-meme-longueur-donde-454922.html", "http://www.maliweb.net/la-situation-politique-et-securitaire-au-nord/ouagadougou-les-groupes-du-nord-du-mali-sentendent-pas-495612.html", "http://www.maliweb.net/untm-syndicats/greve-48-heures-luntm-laveu-koulouba-495162.html","http://www.maliweb.net/non-classe/reintegration-rebelles-larmee-malienne-gouvernement-cherche-reduire-lhostilite-chefs-militaires-495232.html",
			"http://maliactu.net/corruption-ibk-ordonne-la-revision-de-tous-les-contrats-signes-par-soumeylou-boubeye-maiga/","http://www.maliactu.net",
            "http://www.rfi.fr/moyen-orient/20140810-gaza-israel-palestine-guerre-morts-manifestations-tel-aviv-paris-boycott/", "http://www.rfi.fr",
            "http://www.tv5.org/cms/chaine-francophone/info/p-1911-Irak-Nouvelles-frappes-americaines-sur-les-jihadistes-Fabius-appelle-a-l-unite.htm?&rub=2&xml=newsmlmmd.urn.newsml.afp.com.20140810.0fa85d3f.34d5.414a.a756.5cb77498298b.xml","http://www.tv5.org",
            "http://www.france24.com/fr/urgent/20140810-irak-leiil-a-assassine-moins-500-yazidis-a-inhumes-fosses-communes-ministere-irakien-droits-lhomme/","http://www.france24.fr"};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		
		Intent intent = getIntent();
		String mStrings = intent.getStringExtra(MainActivity.SITE_CHOISI);
		
			
			
			switch (mStrings) {
	    	case "Maliweb": 
	    		mUrls = new String[] {"http://www.maliweb.net/economie/banque-mond-fmi/washington-fmi-mali-meme-longueur-donde-454922.html",
	    				               "http://www.maliweb.net/la-situation-politique-et-securitaire-au-nord/ouagadougou-les-groupes-du-nord-du-mali-sentendent-pas-495612.html", 
	    				               "http://www.maliweb.net/untm-syndicats/greve-48-heures-luntm-laveu-koulouba-495162.html",
	    				               "http://www.maliweb.net/non-classe/reintegration-rebelles-larmee-malienne-gouvernement-cherche-reduire-lhostilite-chefs-militaires-495232.html"};
	    		  break;
	    	case "Maliactu":
	    		mUrls  = new String[] { "http://maliactu.net/corruption-ibk-ordonne-la-revision-de-tous-les-contrats-signes-par-soumeylou-boubeye-maiga/",
	    				                "http://www.maliactu.net"};
	        	   break;  
	    	case  "RFI":
	    		mUrls = new String[] { "http://www.rfi.fr/moyen-orient/20140810-gaza-israel-palestine-guerre-morts-manifestations-tel-aviv-paris-boycott/", 
	    								"http://www.rfi.fr"};
	    		   break; 
	    	case "TV5 Monde": 
	    		mUrls = new String[] {"http://www.tv5.org/cms/chaine-francophone/info/p-1911-Irak-Nouvelles-frappes-americaines-sur-les-jihadistes-Fabius-appelle-a-l-unite.htm?&rub=2&xml=newsmlmmd.urn.newsml.afp.com.20140810.0fa85d3f.34d5.414a.a756.5cb77498298b.xml", 
	    								"http://www.tv5monde.org"};
	    		  break;
	    	case "France 24": 
	    		mUrls = new String[] { "http://www.france24.com/fr/urgent/20140810-irak-leiil-a-assassine-moins-500-yazidis-a-inhumes-fosses-communes-ministere-irakien-droits-lhomme/",
	    								"http://www.france24.fr"};
	        	   break;
		}

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

