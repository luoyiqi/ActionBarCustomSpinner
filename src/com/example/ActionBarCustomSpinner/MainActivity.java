package com.example.ActionBarCustomSpinner;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends Activity implements ActionBar.OnNavigationListener {
    List<Navigation> navigationItems=new ArrayList<Navigation>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final ActionBar actionBar = getActionBar();

        for (int i=1; i<4; i++)
        navigationItems.add(new Navigation("Title " + i, "Sub Title " + i ));

        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        NavigationSpinnerAdapter spinnerAdapter=new
                NavigationSpinnerAdapter(getApplicationContext(),navigationItems);

        actionBar.setListNavigationCallbacks(spinnerAdapter, this);
    }

    @Override
    public boolean onNavigationItemSelected(int i, long l) {
        return false;
    }
}
