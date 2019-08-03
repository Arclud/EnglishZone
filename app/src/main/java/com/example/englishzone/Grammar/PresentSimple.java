package com.example.englishzone.Grammar;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.englishzone.R;


public class PresentSimple extends Fragment {
    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.present_simple, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        TextView soundOne, soundTwo, soundThree, soundFour, soundFive, soundSix, soundSeven;
        soundOne = view.findViewById(R.id.soundOne);
        soundTwo = view.findViewById(R.id.soundTwo);
        soundThree = view.findViewById(R.id.soundThree);
        soundFour = view.findViewById(R.id.soundFour);
        soundFive = view.findViewById(R.id.soundFive);
        soundSix = view.findViewById(R.id.soundSix);
        soundSeven = view.findViewById(R.id.soundSeven);


        soundOne.setOnClickListener(listener);
        soundTwo.setOnClickListener(listener);
        soundThree.setOnClickListener(listener);
        soundFour.setOnClickListener(listener);
        soundFive.setOnClickListener(listener);
        soundSix.setOnClickListener(listener);
        soundSeven.setOnClickListener(listener);

    }

    View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.soundOne:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.tosing);
                    break;
                case R.id.soundTwo:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.walkplayeat);
                    break;
                case R.id.soundThree:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.unleashreplay);
                    break;
                case R.id.soundFour:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.underlinewhitewash);
                    break;
                case R.id.soundFive:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.lookout);
                    break;
                case R.id.soundSix:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.iworkzoo);
                    break;
                case R.id.soundSeven:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.iamgoing);
                    break;

            }
            mediaPlayer.start();
        }
    };


}
