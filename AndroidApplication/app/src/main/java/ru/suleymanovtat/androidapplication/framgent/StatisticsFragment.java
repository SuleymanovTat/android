package ru.suleymanovtat.androidapplication.framgent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.suleymanovtat.androidapplication.R;

public class StatisticsFragment extends BaseFragment {

    public static final String TAB_STATISTICS_FRAG = "StatisticsFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);
        toolbar(view, R.string.statistics, R.drawable.ic_menu);
        return view;
    }
}
