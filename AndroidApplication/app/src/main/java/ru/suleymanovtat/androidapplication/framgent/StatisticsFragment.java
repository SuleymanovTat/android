package ru.suleymanovtat.androidapplication.framgent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ru.suleymanovtat.androidapplication.ExampleActivity;
import ru.suleymanovtat.androidapplication.R;

public class StatisticsFragment extends BaseFragment {

    public static final String TAB_STATISTICS_FRAG = "StatisticsFragment";
    public static final String KEY_MESSAGE = "message";
    public static final int REQUEST_CODE = 101;
    private TextView textMessage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistics, container, false);
        toolbar(view, R.string.statistics, R.drawable.ic_menu);
        textMessage = (TextView) view.findViewById(R.id.textMessage);
        view.findViewById(R.id.btnExampleActivity).setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), ExampleActivity.class);
            startActivityForResult(intent, REQUEST_CODE);
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null) {
            textMessage.setText(data.getStringExtra(KEY_MESSAGE));
        }
    }
}
