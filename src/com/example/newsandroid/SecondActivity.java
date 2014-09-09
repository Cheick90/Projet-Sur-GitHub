package com.example.newsandroid;

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
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SecondActivity extends Activity implements OnItemClickListener{
	    private ListView mRssListView;
	    private FeedXMLpullParser mNewsFeeder;
	    private List<RSSFeed> mRssFeedList;
	    private RssAdapter mRssAdap;
	
	String[] mUrls = new String[] {"http://www.maliweb.net/feed/", "http://www.maliactu.net/feed/", 
			                      "http://news.abamako.com/feed","http://www.malijet.com/feed/",
			                      "http://www.bamada.net/feed"};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		
		Intent intent = getIntent();
		String mStrings = intent.getStringExtra(MainActivity.SITE_CHOISI);
		switch (mStrings) {
	    	case "Maliweb": 
	    		mUrls = new String[] {"http://www.maliweb.net/feed"};
	    		  break;
	    	case "Maliactu":
	    		mUrls  = new String[] {"http://www.maliactu.net/feed"};
	        	   break;  
	    	case  "RFI":
	    		mUrls = new String[] {"http://news.abamako.com/feed"};
	    		   break; 
	    	case "Malijet": 
	    		mUrls = new String[] {"http://www.malijet.com/feed"};
	    		  break;
	    	case "France 24": 
	    		mUrls = new String[] {"http://www.bamada.net/feed"};
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
                view.setTag(rssHolder);
            } else {
                rssHolder = (RssHolder) view.getTag();
            }
            RSSFeed rssFeed = rssFeedLst.get(position);
            rssHolder.rssTitleView.setText(rssFeed.getTitle());
            return view;
        }
    }
	 static class RssHolder {
	        public TextView rssTitleView;
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
		   Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(lien.getLink()));
		   startActivity(intent);
	    }
	
	}

	


