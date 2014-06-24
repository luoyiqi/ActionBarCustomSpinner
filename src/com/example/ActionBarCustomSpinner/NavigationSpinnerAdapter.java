package com.example.ActionBarCustomSpinner;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NavigationSpinnerAdapter extends BaseAdapter {

    private TextView txtTitle;
    private TextView txtSubTitle;
    private List<Navigation> navigationItems;
    private Context context;

    public NavigationSpinnerAdapter(Context context,List<Navigation> navigationItems) {
        this.navigationItems=navigationItems;
        this.context=context;
    }

    @Override
    public int getCount() {
        return navigationItems.size();
    }

    @Override
    public Object getItem(int i)
    {
        return navigationItems.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //return a view which appears in the Action Bar
        if (convertView==null){
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.actionbar_spinner,null);  //layout for action bar spinner
        }
        txtTitle=(TextView) convertView.findViewById(R.id.txtActionBarSpinnerTitle);
        txtSubTitle=(TextView) convertView.findViewById(R.id.txtActionBarSpinnerSubTitle);
        txtTitle.setText(navigationItems.get(position).getTitle());
        txtSubTitle.setText(navigationItems.get(position).getSubTitle());
        return convertView;

    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        //return a view which appears in the Spinner List
        if (convertView==null){
            LayoutInflater layoutInflater= (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.spinner_list,null);// layout for spinner list
        }
        txtTitle=(TextView) convertView.findViewById(R.id.txtSpinnerListTitle);
        txtSubTitle=(TextView) convertView.findViewById(R.id.txtSpinnerListSubTitle);
        txtTitle.setText(navigationItems.get(position).getTitle());
        txtSubTitle.setText(navigationItems.get(position).getSubTitle());

        return convertView;
    }
}