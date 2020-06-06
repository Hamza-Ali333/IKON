package com.example.myapplication.ui.events;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.Eventdetail;
import com.example.myapplication.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private TextView ForYou,AllEvents;
    private Button btn_pupolar;
    ImageView img;

    public View onCreateView(@NonNull final LayoutInflater inflater,
                             final ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        final View root = inflater.inflate(R.layout.events_layout, container, false);


        ForYou = root.findViewById(R.id.foryou);
        AllEvents = root.findViewById(R.id.popular);
        btn_pupolar = root.findViewById(R.id.viewall);
        img = root.findViewById(R.id.imageView3);

        ForYou.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ForYou.setTextColor(Color.parseColor("#EC5148"));
                AllEvents.setTextColor(Color.parseColor("#FFFFFF"));
                btn_pupolar.setVisibility(View.VISIBLE);
            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),Eventdetail.class);
                startActivity(i);
            }
        });

        AllEvents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AllEvents.setTextColor(Color.parseColor("#EC5148"));
                ForYou.setTextColor(Color.parseColor("#FFFFFF"));
                btn_pupolar.setVisibility(View.GONE);
            }
        });




        //final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
               // textView.setText(s);
            }
        });
        return root;
    }
}
