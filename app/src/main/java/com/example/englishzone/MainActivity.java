package com.example.englishzone;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.example.englishzone.Adapter.CustomExpandableListAdapter;
import com.example.englishzone.Fragments.FragmentContnent;
import com.example.englishzone.Grammar.FutureContinuous;
import com.example.englishzone.Grammar.FuturePerfect;
import com.example.englishzone.Grammar.FutureSimple;
import com.example.englishzone.Grammar.GeneralPresentSimple;
import com.example.englishzone.Grammar.PastContinuous;
import com.example.englishzone.Grammar.PastSimple;
import com.example.englishzone.Grammar.PresentContinious;
import com.example.englishzone.Grammar.PresentSimple;
import com.example.englishzone.Helper.FragmentNavigatinManager;
import com.example.englishzone.Interface.NavigationManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToogle;
    private String mActivityTitle;
    private String[] items;
    private ExpandableListView expandableListView;
    private ExpandableListAdapter adapter;
    private List<String> lstTitle;
    private Map<String, List<String>> lstChild;
    private NavigationManager navigationManager;
    private FragmentContnent fragmentContnent;
    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Iite view
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mActivityTitle = getTitle().toString();
        expandableListView = (ExpandableListView) findViewById(R.id.navLis);
        navigationManager = FragmentNavigatinManager.getInstance(this);
        initItems();


        View listHeaderView = getLayoutInflater().inflate(R.layout.nav_header, null, false);

        expandableListView.addHeaderView(listHeaderView);

        genDate();
        addDrawersItem();
        setupDrawer();
        if (savedInstanceState == null)
            selectFirstItemAsDefault();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setTitle("My English");

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragment = new PresentSimple();
        fragmentTransaction.replace(R.id.container, fragment);
        fragmentTransaction.commit();
    }

    private void selectFirstItemAsDefault() {
        if (navigationManager != null) {
            String firstItem = lstTitle.get(0);
            navigationManager.showFragment(firstItem);
            getSupportActionBar().setTitle(firstItem);
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToogle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToogle.onConfigurationChanged(newConfig);
    }


    private void setupDrawer() {
        mDrawerToogle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // getSupportActionBar().setTitle("EDMTDev");
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                //getSupportActionBar().setTitle(mActivityTitle);
                invalidateOptionsMenu();
            }
        };
        mDrawerToogle.setDrawerIndicatorEnabled(true);
        mDrawerLayout.setDrawerListener(mDrawerToogle);
    }

    private void addDrawersItem() {
        adapter = new CustomExpandableListAdapter(this, lstTitle, lstChild);
        expandableListView.setAdapter(adapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            @Override
            public void onGroupExpand(int groupPosition) {
                getSupportActionBar().setTitle(lstTitle.get(groupPosition).toString());
            }
        });
        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
            @Override
            public void onGroupCollapse(int groupPosition) {
                getSupportActionBar().setTitle("My English");
            }
        });
        //
        //
        //
        // Реализуем клик
        //
        //
        //
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                String selectedItem = ((List) (lstChild.get(lstTitle.get(groupPosition))))
                        .get(childPosition).toString();

                setFragmentContnent(selectedItem);
                switch (selectedItem) {
                    case "Английские глаголы.\nКлассификация":
                        fragment = new PresentSimple();
                        fragmentTransaction.replace(R.id.container, fragment);
                        break;

                    case "Present Simple - простое настоящее время":
                        fragment = new GeneralPresentSimple();
                        fragmentTransaction.replace(R.id.container, fragment);
                        break;
                    case "Past Simple - простое прошедшее время в":
                        fragment = new PastSimple();
                        fragmentTransaction.replace(R.id.container, fragment);
                        break;
                    case "Future Simple - простое будущее время в":
                        fragment = new FutureSimple();
                        fragmentTransaction.replace(R.id.container, fragment);
                        break;
                    case "Present Continuous - настоящее длительное":
                        fragment = new PresentContinious();
                        fragmentTransaction.replace(R.id.container, fragment);
                        break;
                    case "Past Continuous - прошедшее длительное":
                        fragment = new PastContinuous();
                        fragmentTransaction.replace(R.id.container, fragment);
                        break;
                    case "Future Continuous - будущее длительное время в":
                        fragment = new FutureContinuous();
                        fragmentTransaction.replace(R.id.container, fragment);
                        break;
                    case  "Future Perfect - будущее совершенное время в ":
                        fragment = new FuturePerfect();
                        fragmentTransaction.replace(R.id.container, fragment);
                        break;
                }
                getSupportActionBar().setTitle(selectedItem);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();


                if (items[0].equals(lstTitle.get(groupPosition)))
                    navigationManager.showFragment(selectedItem);
                else
                    throw new IllegalArgumentException("ne naiden fragment");
                mDrawerLayout.closeDrawer(GravityCompat.START);

                return false;
            }
        });
    }

    private void genDate() {
        List<String> title = Arrays.asList("Грамматика", "настройки");

        List<String> childItem = Arrays.asList("Английские глаголы.\nКласgit remote add origin https://github.com/Arclud/EnglishZone.gitсификация",
                "Present Simple - простое настоящее время", "Past Simple - простое прошедшее время в",
                "Future Simple - простое будущее время в", "Present Continuous - настоящее длительное",
                "Past Continuous - прошедшее длительное", "Future Continuous - будущее длительное время в",
                "Present Perfect - настоящее совершенное время в", "Past Perfect - прошедшее совершенное время",
                "Future Perfect - будущее совершенное время в ", "Present Perfect Continuous - настоящее совершенное",
                "Future Perfect Continuous - будущее совершенное");

        lstChild = new TreeMap<>();
        lstChild.put(title.get(0), childItem);

        lstTitle = new ArrayList<>(lstChild.keySet());
    }


    private void initItems() {
        items = new String[]{"Грамматика", "настройки"};
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (mDrawerToogle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    private void setFragmentContnent(String getText) {
        switch (getText) {
            case "Английские глаголы.\nКлассификация":
                fragment = new PresentSimple();
        }
    }
}
