package com.example.newsandroid;


import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.ListActivity;
import android.content.ClipData.Item;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivity extends FragmentActivity implements ActionBar.TabListener {
	
	        private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
			
			@Override
			public void onCreate (Bundle savedInstanceState) {
						super.onCreate(savedInstanceState);
						setContentView(R.layout.activity_main);

				        // Set up the action bar.
				        final ActionBar actionBar = getActionBar();
				        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

				        // For each of the sections in the app, add a tab to the action bar.
				        actionBar.addTab(actionBar.newTab().setText("Maliweb").setTabListener(this));
				        actionBar.addTab(actionBar.newTab().setText("Maliactu").setTabListener(this));
				        actionBar.addTab(actionBar.newTab().setText("abamako").setTabListener(this));
				        actionBar.addTab(actionBar.newTab().setText("Malijet").setTabListener(this));
				        actionBar.addTab(actionBar.newTab().setText("RFI").setTabListener(this));
				        actionBar.addTab(actionBar.newTab().setText("Jeune Afrique").setTabListener(this));
				        actionBar.addTab(actionBar.newTab().setText("TV5 Monde").setTabListener(this));
				        actionBar.addTab(actionBar.newTab().setText("EURONEWS").setTabListener(this));
				        actionBar.addTab(actionBar.newTab().setText("Le POINT").setTabListener(this));
				        actionBar.addTab(actionBar.newTab().setText("BAMADA").setTabListener(this));
				        actionBar.addTab(actionBar.newTab().setText("FRNACE24").setTabListener(this));
				        actionBar.addTab(actionBar.newTab().setText("Le FIGARO").setTabListener(this));
				        
			}		
			
			 @Override
			 public void onRestoreInstanceState(Bundle savedInstanceState) {
			        if (savedInstanceState.containsKey(STATE_SELECTED_NAVIGATION_ITEM)) {
			            getActionBar().setSelectedNavigationItem(savedInstanceState.getInt(STATE_SELECTED_NAVIGATION_ITEM));
			        }
			    }
			 @Override
			 public void onSaveInstanceState(Bundle outState) {
			        outState.putInt(STATE_SELECTED_NAVIGATION_ITEM, getActionBar().getSelectedNavigationIndex());
			    }
			 @Override
			    public boolean onCreateOptionsMenu(Menu menu) {
			        getMenuInflater().inflate(R.menu.main, menu);
			        return true;
			    }
			 @Override
			    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
			    }
			 @Override
			    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
			        
			    		SecondActivity simpleListFragment = new SecondActivity();
			    		getSupportFragmentManager().beginTransaction().replace(R.id.container, simpleListFragment).commit();
			    	
			   }

			 @Override
			    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
			    }
			 
			 public static class DummySectionFragment extends Fragment {
			        public DummySectionFragment() {
			        }
			public static final String ARG_SECTION_NUMBER = "section_number";

			        @Override
	         public View onCreateView(LayoutInflater inflater, ViewGroup container,
			                Bundle savedInstanceState) {
			            TextView textView = new TextView(getActivity());
			            textView.setGravity(Gravity.CENTER);
			            Bundle args = getArguments();
			            textView.setText(Integer.toString(args.getInt(ARG_SECTION_NUMBER)));
			            return textView;
			        }
    }
}