package com.example.actualiteandroid;

import java.util.ArrayList;

import java.util.List;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ListFragment;
import android.text.Html;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SecondActivity extends Activity implements OnItemClickListener{
	    private ListView mRssListView;
	    private FeedXMLpullParser mNewsFeeder;
	    private List<RSSFeed> mRssFeedList;
	    private RssAdapter mRssAdap;
	    
	
	String[] mUrls = new String[] {"http://mali-web.org/feed", "http://www.france24.com/fr/afrique/rss", "http://www.maliactu.net/feed/","http://www.abamako.com/newsletter/","http://www.malijet.com/feed/",
			                       "http://www.rfi.fr/actufr/pages/001/accueil.xml","http://feeds2.feedburner.com/feedsportal/ja_actu",
			                       "http://www.tv5monde.com/TV5Site/rss/actualites.php?rub=6","http://feeds.feedburner.com/euronews/fr/home/",
			                       "http://feeds.lefigaro.fr/c/32266/f/438191/index.rss","http://www.lepoint.fr/rss.xml","http://www.maliweb.net/feed/"};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		
		Intent intent = getIntent();
		String mStrings = intent.getStringExtra(MainActivity.SITE_CHOISI);
		switch (mStrings) {
		case "BAMADA": 
    		mUrls = new String[] {"http://mali-web.org/feed"};
        	   break; 
    	case "FRANCE24": 
    		mUrls = new String[] {"http://www.france24.com/fr/afrique/rss"};
        	break; 
	    case "Maliactu":
	    	mUrls  = new String[] {"http://www.maliactu.net/feed"};
	        break;  
	    case  "Abamako":
	    	mUrls = new String[] {"http://www.abamako.com/newsletter/"};
	    	break; 
	    case "Malijet": 
	    	mUrls = new String[] {"http://www.malijet.com/feed"};
	    	break;
	    case "RFI": 
	    	mUrls = new String[] {"http://www.rfi.fr/general/rss/"};
	        break;
	    case "Jeune Afrique": 
	    	mUrls = new String[] {"http://feeds2.feedburner.com/feedsportal/ja_actu"};
	        break; 
	    case "TV5 Monde": 
	    	mUrls = new String[] {"http://www.tv5monde.com/data/tv5/rss/rssjtmonde.xml"};
	        break;
	    case "EURONEWS": 
	    	mUrls = new String[] {"http://feeds.feedburner.com/euronews/fr/home/"};
	        break; 
	    case "Le FIGARO": 
	    	mUrls = new String[] {"http://feeds.lefigaro.fr/c/32266/f/438191/index.rss"};
	        break;
	    case "Le POINT": 
	    	mUrls = new String[] {"http://www.lepoint.fr/rss.xml"};
	        break;
	    case "Maliweb": 
	    	mUrls = new String[] {"http://www.maliweb.net/feed"};
	    	break;
	    	
		}

		mRssListView = (ListView) findViewById(R.id.rss_list_view);
        mRssFeedList = new ArrayList<RSSFeed>();
        new DoRssFeedTask().execute(mUrls);
        mRssListView.setOnItemClickListener(this);

}

	private class RssAdapter extends ArrayAdapter<RSSFeed> {
        private List<RSSFeed> rssFeedLst;

        public RssAdapter(Context context, int textViewResourceId, List<RSSFeed> rssFeedLst) {
            super(context, textViewResourceId, rssFeedLst);
            this.rssFeedLst = rssFeedLst;
        }
        
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View view = convertView;
            RssHolder rssHolder = null;
            if (convertView == null) {
                view = View.inflate(SecondActivity.this, R.layout.rss_list_item, null);
                rssHolder = new RssHolder();
                rssHolder.rssTitleView = (TextView) view.findViewById(R.id.rss_title_view);
                rssHolder.rssDescriptionView = (TextView) view.findViewById(R.id.rss_description_view);
				view.setTag(rssHolder);
            } else {
                rssHolder = (RssHolder) view.getTag();
            }
            RSSFeed rssFeed = rssFeedLst.get(position);
            rssHolder.rssTitleView.setText(rssFeed.getTitle());
            rssHolder.rssDescriptionView.setText(Html.fromHtml(rssFeed.getDescription()));
			return view;
        }
    }
	 static class RssHolder {
			public TextView rssTitleView;
			public TextView rssDescriptionView;
	    }
	
	 public class DoRssFeedTask extends AsyncTask<String, Void, List<RSSFeed>> {
	        ProgressDialog prog;
	        String jsonStr = null;
	        Handler innerHandler;

	        @Override
	        protected void onPreExecute() {
	            prog = new ProgressDialog(SecondActivity.this);
	            prog.setMessage("S'il vous plait attendez....");
	            prog.show();
	        }

	        @Override
	        protected List<RSSFeed> doInBackground(String... params) {
	            for (String urlVal : params) {
	                mNewsFeeder = new FeedXMLpullParser (urlVal);
	            }
	            mRssFeedList = mNewsFeeder.parse();
	            return mRssFeedList;
	        }

	        @Override
	        protected void onPostExecute(List<RSSFeed> result) {
	            prog.dismiss();
	            runOnUiThread(new Runnable() {

	                @Override
	                public void run() {
	                    mRssAdap = new RssAdapter(SecondActivity.this, R.layout.rss_list_item, mRssFeedList);
	                    int count = mRssAdap.getCount();
	                    if (count != 0 && mRssAdap != null) {
	                        mRssListView.setAdapter(mRssAdap);
	                    }
	                }
	            });
	        }

	        @Override
	        protected void onProgressUpdate(Void... values) {
	        }
	    }
	 @Override
	 public void onItemClick(AdapterView<?> adapterView, View v, int position, long id) {
	    	
		   
		   RSSFeed lien = mRssFeedList.get(position);
		   Intent intent = new Intent(SecondActivity.this, ActivityNavigateur.class);
		   intent.putExtra("url", lien.getLink());
		   startActivity(intent);
	    }
	
	}
