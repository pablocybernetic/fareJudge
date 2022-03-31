package com.peter.Farejudge;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;


public class NotificationFragment extends Fragment {
protected ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notification, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        try {

            super.onViewCreated(view, savedInstanceState);
            String[] values = new String[]{
                    "helo me in", "helo me h h h in", "helo me in", "helo me in"
            };
            ListView listView = (ListView) view.findViewById(R.id.listviewitems);
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, values);
            listView.setAdapter(adapter);
        } catch (Exception e){

        }
    }
}