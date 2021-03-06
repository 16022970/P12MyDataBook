package com.example.a16022970.p12_mydatabook;

import android.content.res.Configuration;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<MenuItems> drawerItems;
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    ArrayAdapter aa;
    String currentTitle;
    android.support.v7.app.ActionBar ab;
    private ActionBarDrawerToggle drawerToggle;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);
        fab = findViewById(R.id.fab);

        drawerItems = new ArrayList<MenuItems>();
        drawerItems.add(new MenuItems("Bio", android.R.drawable.ic_menu_info_details));
        drawerItems.add(new MenuItems("Vaccination", android.R.drawable.ic_menu_edit));
        drawerItems.add(new MenuItems("Annivesary", android.R.drawable.ic_menu_my_calendar));
        drawerItems.add(new MenuItems("About Us", android.R.drawable.star_big_on));


        ab = getSupportActionBar();

        aa = new MenuAdapter(this,
                R.layout.row, drawerItems);
        drawerList.setAdapter(aa);

        // Set the list's click listener
        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int
                    position, long arg3) {

                Fragment fragment = null;
                if (position == 0)
                    fragment = new BioFragment();
                else if (position == 1)
                    fragment = new VaccinationFragment();
                else if (position == 2)
                    fragment = new AnnivesaryFragment();
                else if (position == 3)
                    fragment = new AnnivesaryFragment();

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction trans = fm.beginTransaction();
                trans.replace(R.id.content_frame, fragment);
                trans.commit();

                // Highlight the selected item,
                //  update the title, and close the drawer
                drawerList.setItemChecked(position, true);
                currentTitle = drawerItems.get(position).getName().toString();
                ab.setTitle(currentTitle);
                drawerLayout.closeDrawer(drawerList);
            }
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerToggle = new ActionBarDrawerToggle(getParent(),drawerLayout,R.string.drawer_open,R.string.drawer_close) {

                    /** Would be called when a drawer has completely closed */
                    @Override
                    public void onDrawerClosed(View view) {
                        super.onDrawerClosed(view);
                        ab.setTitle(currentTitle);
                    }

                    /** Would be called when a drawer has completely open */
                    @Override
                    public void onDrawerOpened(View drawerView) {
                        super.onDrawerOpened(drawerView);
                        ab.setTitle("Make a selection");
                    }
                };
            }
        });


        // Set the drawer toggle as the DrawerListener
        drawerLayout.addDrawerListener(drawerToggle);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync toggle state so the indicator is shown properly.
        //  Have to call in onPostCreate()
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The home/up action should open or close the drawer.
        // ActionBarDrawerToggle will take care of this.
        if (drawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }
}
