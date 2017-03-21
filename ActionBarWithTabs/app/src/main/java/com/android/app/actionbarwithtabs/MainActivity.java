package com.android.app.actionbarwithtabs;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setLogo(R.mipmap.ic_launcher);
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setNavigationMode(actionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("AUDIO").setIcon(R.mipmap.ic_launcher).setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText("VIDEO").setIcon(R.mipmap.ic_launcher).setTabListener(this));

    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {

        int currentTab = tab.getPosition();
        switch (currentTab){
            case 0:
                setContentView(R.layout.tab_frag1);
                Log.e("MainActivity", tab.getText() + " is Selected");
                return;
            case 1:
                setContentView(R.layout.tab_frag2);
                Log.e("MainActivity", tab.getText() + " is Selected");
                return;
        }


    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
        Toast.makeText(this, tab.getText()+ " is UnSelected", Toast.LENGTH_SHORT).show();
        Log.e("MainActivity", tab.getText()+" is UnSelected");

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

        Toast.makeText(this, tab.getText()+ " is Selected", Toast.LENGTH_SHORT).show();
        Log.e("MainActivity", tab.getText()+" is Selected");

    }
}
