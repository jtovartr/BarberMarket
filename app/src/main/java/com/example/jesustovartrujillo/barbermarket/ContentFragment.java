package com.example.jesustovartrujillo.barbermarket;

import android.app.Activity;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ContentFragment extends Fragment {

    TextView mContent;
    Activity mActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View inf = inflater.inflate(R.layout.content_fragment, container, false);
        mContent = (TextView) inf.findViewById(R.id.content_text);
        return inf;

    }


    @Override
    public void onAttach(Activity activity) {
        //  Auto-generated method stub
        super.onAttach(activity);

        mActivity = activity;
    }


    @Override
    public void onResume() {

        super.onResume();


        String username;

        // Get the username from the preferences
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mActivity);
        username = sharedPreferences.getString(SettingsFragment.KEY_PREF_USERNAME, "");


        mContent.setText(new StringBuilder().append("Hello, ").append(username).append("!").toString());
    }




}
