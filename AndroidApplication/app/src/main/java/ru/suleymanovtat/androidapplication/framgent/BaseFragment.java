package ru.suleymanovtat.androidapplication.framgent;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import ru.suleymanovtat.androidapplication.MainActivity;
import ru.suleymanovtat.androidapplication.R;

public class BaseFragment extends Fragment {

    public void toolbar(View view, int title, int image) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        activity.setSupportActionBar(toolbar);
        activity.setTitle(title);
        toolbar.setNavigationIcon(image);
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                ((MainActivity) getActivity()).drawer.openDrawer(Gravity.START);
        }
        return super.onOptionsItemSelected(item);
    }
}
