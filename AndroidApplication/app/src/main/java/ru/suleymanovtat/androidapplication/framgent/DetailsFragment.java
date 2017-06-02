package ru.suleymanovtat.androidapplication.framgent;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ru.suleymanovtat.androidapplication.R;

public class DetailsFragment extends Fragment implements View.OnClickListener {

    public static final String TAB_TRANSACTION_FRAG = "DetailsFragment";
    private EditText editName;
    private SentdData sentdDataListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        editName = (EditText) view.findViewById(R.id.editName);
        Button btnSend = (Button) view.findViewById(R.id.btnSend);
        btnSend.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        String message = editName.getText().toString().trim();
        if (message.isEmpty()) {
            Toast.makeText(getActivity(), R.string.empty_name, Toast.LENGTH_SHORT).show();
        } else {
            sentdDataListener.sentdData(message);
            getFragmentManager().popBackStack();
        }
    }

    interface SentdData {
        void sentdData(String text);
    }

    public void setName(SentdData sentdDataListener) {
        this.sentdDataListener = sentdDataListener;
    }
}
