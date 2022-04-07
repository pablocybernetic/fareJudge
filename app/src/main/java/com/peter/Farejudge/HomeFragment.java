package com.peter.Farejudge;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class HomeFragment extends Fragment {
    private Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);


    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        try {

            super.onViewCreated(view, savedInstanceState);
            button = (Button) view.findViewById(R.id.view_events);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                    Fragment frag = new NotificationFragment();


                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.fragmentcon, frag);
                    ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                    ft.addToBackStack(null);
                    ft.commit();
                }
            });
        } catch (Exception e) {

        }
    }

    public void onClick(View view) {
        NotificationFragment fragment_notification = new NotificationFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_home, fragment_notification);
        fragmentTransaction.commit();
    }

}