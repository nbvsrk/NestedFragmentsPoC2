package com.mek.rama.android.nestedfragmentspoc2;

/**
 * Created by SreeRamakrishna on 13-05-2015.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentThree extends Fragment {
    TextView textView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        textView = (TextView) view.findViewById(R.id.tv_details);
        if (getArguments() != null) {
            textView.setText(getArguments().getString("ChildPosition"));
        }
        return view;
    }

}