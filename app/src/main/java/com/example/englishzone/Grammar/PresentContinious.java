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

public class PresentContinious extends Fragment {
    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.present_continious, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView soundOne, soundTwo, soundThree, soundFour, soundFive, soundSix, soundSeven,soundEight;

        soundOne = view.findViewById(R.id.soundOne);
        soundTwo = view.findViewById(R.id.soundTwo);
        soundThree = view.findViewById(R.id.soundThree);
        soundFour = view.findViewById(R.id.soundFour);
        soundFive = view.findViewById(R.id.soundFive);
        soundSix = view.findViewById(R.id.soundSix);
        soundSeven = view.findViewById(R.id.soundSeven);
        soundEight = view.findViewById(R.id.soundEight);


        soundOne.setOnClickListener(listener);
        soundTwo.setOnClickListener(listener);
        soundThree.setOnClickListener(listener);
        soundFour.setOnClickListener(listener);
        soundSix.setOnClickListener(listener);
        soundSeven.setOnClickListener(listener);
        soundEight.setOnClickListener(listener);
    }
    View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.soundOne:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.jump);
                    break;
                case R.id.soundTwo:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.youlaugh);
                    break;
                case R.id.soundThree:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.dictionary);
                    break;
                case R.id.soundFour:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.radioisnot);
                    break;
                case R.id.soundSix:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.doctoroperation);
                    break;
                case R.id.soundSeven:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.alwaysinter);
                    break;
                case R.id.soundEight:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.heshoutingatme);
                    break;
                    default:
                        mediaPlayer = MediaPlayer.create(getActivity(), R.raw.heshoutingatme);
                        break;
            }
            mediaPlayer.start();
        }
    };
}
