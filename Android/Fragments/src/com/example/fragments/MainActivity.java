package com.example.fragments;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.Menu;

@SuppressLint("NewApi")
public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		SimplePagerAdapter adapter = new SimplePagerAdapter(getSupportFragmentManager());
		final ViewPager pager = (ViewPager) findViewById(R.id.fragmentPager);
        pager.setAdapter(adapter);
        
        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        TabListener tabListener = new TabListener() {
            public void onTabSelected(Tab tab, android.app.FragmentTransaction ft) {
                pager.setCurrentItem(tab.getPosition());
            }
			public void onTabReselected(Tab arg0,
					android.app.FragmentTransaction arg1) {
				// TODO Auto-generated method stub
				
			}
			public void onTabUnselected(Tab arg0,
					android.app.FragmentTransaction arg1) {
				// TODO Auto-generated method stub
				
			}
        };
        
        actionBar.addTab(actionBar.newTab().setText("Home").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Articles").setTabListener(tabListener));
        
        pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
        	public void onPageSelected(int position) {
        		actionBar.setSelectedNavigationItem(position);
        	}
        });
	}
	
	public static class SimplePagerAdapter extends FragmentPagerAdapter {
        public SimplePagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }
 
        @Override
        public int getCount() {
            return 2;
        }
 
        @Override
        public Fragment getItem(int position) {
            switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new ArticlesFragment();
            default:
                return null;
            }
        }
    }
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
