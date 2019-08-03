package com.example.englishzone.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.englishzone.R;


public class FragmentContnent extends Fragment {

    public static final String KEY_TITLE="Contnent";

    public FragmentContnent() {

    }

    public static FragmentContnent newInstance(String param1) {
        FragmentContnent fragment = new FragmentContnent();
        Bundle args = new Bundle();
        args.putString(KEY_TITLE, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment_contnent, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String title = getArguments().getString(KEY_TITLE);
            ((TextView)view.findViewById(R.id.title)).setText(title);
        }

    }
}
