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

public class PastContinuous extends Fragment {
    MediaPlayer mediaPlayer;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.past_continuous, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView soundOne, soundTwo, soundThree;
        soundOne = view.findViewById(R.id.soundOne);
        soundTwo = view.findViewById(R.id.soundTwo);
        soundThree = view.findViewById(R.id.soundSix);

        soundOne.setOnClickListener(listener);
        soundTwo.setOnClickListener(listener);
        soundThree.setOnClickListener(listener);

    }

    View.OnClickListener listener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.soundOne:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.whenyousleep);
                    break;
                case R.id.soundTwo:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.morningourelevator);
                    break;
                case R.id.soundSix:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.iwassleeping);
                    break;
                default:
                    mediaPlayer = MediaPlayer.create(getActivity(), R.raw.heshoutingatme);
                    break;
            }
            mediaPlayer.start();
        }
    };
}
