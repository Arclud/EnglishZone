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

public class GeneralPresentSimple extends Fragment {
    MediaPlayer mediaPlayer;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.general_present_simple,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView soundOne, soundTwo, soundThree, soundFour, soundFive, soundSix, soundSeven,soundEight,soundNine,soundTen,soundIleven,soundTwenty,soundThirty;

        soundOne = view.findViewById(R.id.soundOne);
        soundTwo = view.findViewById(R.id.soundTwo);
        soundThree = view.findViewById(R.id.soundThree);
        soundFour = view.findViewById(R.id.soundFour);
        soundFive = view.findViewById(R.id.soundFive);
        soundSix = view.findViewById(R.id.soundSix);
        soundSeven = view.findViewById(R.id.soundSeven);
        soundEight = view.findViewById(R.id.soundEight);
        soundNine = view.findViewById(R.id.soundNine);
        soundTen = view.findViewById(R.id.soundTen);
        soundIleven = view.findViewById(R.id.soundIleven);
        soundTwenty = view.findViewById(R.id.soundTwenty);
        soundThirty = view.findViewById(R.id.soundThirty);


        soundOne.setOnClickListener(listener);
        soundTwo.setOnClickListener(listener);
        soundThree.setOnClickListener(listener);
        soundFour.setOnClickListener(listener);
        soundFive.setOnClickListener(listener);
        soundSix.setOnClickListener(listener);
        soundSeven.setOnClickListener(listener);
        soundEight.setOnClickListener(listener);
        soundNine.setOnClickListener(listener);
        soundTen.setOnClickListener(listener);
        soundIleven.setOnClickListener(listener);
        soundTwenty.setOnClickListener(listener);
        soundThirty.setOnClickListener(listener);
    }
    View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.soundOne:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.iworkheworks);
                    break;
                case R.id.soundTwo:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.iwishhewishes);
                    break;
                case R.id.soundThree:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.itryhetries);
                    break;
                case R.id.soundFour:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.rock);
                    break;
                case R.id.soundFive:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.doeshespeak);
                    break;
                case R.id.soundSix:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.blackcoffee);
                    break;
                case R.id.soundSeven:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.doessmoke);
                    break;
                case R.id.soundEight:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.wanthelpyou);
                    break;
                case R.id.soundNine:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.janecook);
                    break;
                case R.id.soundTen:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.igotothepark);
                    break;
                case R.id.soundIleven:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.playtennis);
                    break;
                case R.id.soundTwenty:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.studifrench);
                    break;
                case R.id.soundThirty:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.liveboston);
                    break;

            }
            mediaPlayer.start();
        }
    };
}
