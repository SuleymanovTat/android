package ru.suleymanovtat.androidapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import ru.suleymanovtat.androidapplication.framgent.CategoriesFragment;
import ru.suleymanovtat.androidapplication.framgent.StatisticsFragment;
import ru.suleymanovtat.androidapplication.framgent.TransactionFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction().add(R.id.container, new TransactionFragment(), TransactionFragment.TAB_TRANSACTION_FRAG).commit();
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        removeAllFragments();
        Fragment fragment = null;
        String tab = "";
        if (id == R.id.nav_waste) {
            fragment = new TransactionFragment();
            tab = TransactionFragment.TAB_TRANSACTION_FRAG;
        } else if (id == R.id.nav_categories) {
            fragment = new CategoriesFragment();
            tab = CategoriesFragment.TAB_CATEGORIES_FRAG;
        } else if (id == R.id.nav_statistics) {
            fragment = new StatisticsFragment();
            tab = StatisticsFragment.TAB_STATISTICS_FRAG;
        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment, tab).commit();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void removeAllFragments() {
        FragmentManager fm = getSupportFragmentManager();
        for (int i = 0; i < fm.getBackStackEntryCount(); ++i) {
            fm.popBackStack();
        }
    }
}
