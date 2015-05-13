package com.mek.rama.android.nestedfragmentspoc2;

/**
 * Created by SreeRamakrishna on 13-05-2015.
 */


import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class FragmentOne extends Fragment {
    ListView list_parent_data;
    ArrayList<String> parentList = new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        parentList.add("Parent 1");
        parentList.add("Parent 2");
        parentList.add("Parent 3");
        parentList.add("Parent 4");
        parentList.add("Parent 5");

        list_parent_data = (ListView) view.findViewById(R.id.lv_parent_items);
        list_parent_data.setAdapter(new ArrayAdapter(getActivity(),
                android.R.layout.simple_list_item_1, parentList));
        list_parent_data.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parent, View view,
                                    int position, long id) {
             /*   Toast.makeText(getActivity(), parentList.get(position),
                        Toast.LENGTH_SHORT).show();*/
                FragmentTwo fragment = new FragmentTwo();
                final Bundle bundle = new Bundle();
                bundle.putString("parentPosition", parentList.get(position));
                fragment.setArguments(bundle);
                FragmentManager supportFragmentManager = getFragmentManager();
                supportFragmentManager.beginTransaction()
                        .replace(R.id.viewerPage, fragment, "fragmentwo").commit();
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.detailsPage, new FragmentThree(),
                                "fragmenthree").commit();

            }
        });
        return view;
    }

}