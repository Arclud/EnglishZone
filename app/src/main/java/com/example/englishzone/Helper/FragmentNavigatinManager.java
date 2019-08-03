package com.example.englishzone.Helper;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.englishzone.BuildConfig;
import com.example.englishzone.Fragments.FragmentContnent;
import com.example.englishzone.Interface.NavigationManager;
import com.example.englishzone.MainActivity;
import com.example.englishzone.R;

public class FragmentNavigatinManager implements NavigationManager {

    private static FragmentNavigatinManager mInstance;

    private FragmentManager mFragmentManager;

    private MainActivity mainActivity;

    public static FragmentNavigatinManager getInstance(MainActivity mainActivity)
    {
        if(mInstance==null)
            mInstance = new FragmentNavigatinManager();
            mInstance.configure(mainActivity);
            return mInstance;

    }

    private void configure(MainActivity mainActivity) {
    mainActivity = mainActivity;
    mFragmentManager = mainActivity.getSupportFragmentManager();
    }

    @Override
    public void showFragment(String title) {
        showFragment(FragmentContnent.newInstance(title),false);
    }

    private void showFragment(Fragment fragmentContnent, boolean b) {
        FragmentManager fm = mFragmentManager;
        FragmentTransaction ft = fm.beginTransaction().replace(R.id.container,fragmentContnent);
        //ft.commit();
        ft.addToBackStack(null);
        if (b||!BuildConfig.DEBUG)
        {
            ft.commitAllowingStateLoss();
        }
        else
        {
            fm.executePendingTransactions();
        }
    }
}
