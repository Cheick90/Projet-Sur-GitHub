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
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class SecondActivity extends ListFragment implements OnItemClickListener{
	    private ListView mRssListView;
	    private FeedXMLpullParser mNewsFeeder;
	    private List<RSSFeed> mRssFeedList;
	    private RssAdapter mRssAdap;
	    
	
	String[] mUrls = new String[] {"http://www.maliweb.net/feed/", "http://www.maliactu.net/feed/", 
			                      "http://www.abamako.com/newsletter/","http://www.malijet.com/feed/",
			                      "http://www.rfi.fr/actufr/pages/001/accueil.xml","http://feeds2.feedburner.com/feedsportal/ja_actu",
			                      "http://www.tv5monde.com/TV5Site/rss/actualites.php?rub=6","http://feeds.feedburner.com/euronews/fr/home/",
			                      "http://feeds.lefigaro.fr/c/32266/f/438191/index.rss","http://www.lepoint.fr/rss.xml","http://mali-web.org/feed",
			                      "http://www.france24.com/fr/afrique/rss"};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ListAdapter listAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, mUrls);
		setListAdapter(listAdapter);

		mRssListView = (ListView) findViewById(R.id.rss_list_view);
        mRssFeedList = new ArrayList<RSSFeed>();
        new DoRssFeedTask().execute(mUrls);
        mRssListView.setOnItemClickListener(this);

}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.rss_list_item, container, false);
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
            rssHolder.rssDescriptionView.setText(rssFeed.getDescription());
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
		   Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(lien.getLink()));
		   startActivity(intent);
	    }
	
	}
