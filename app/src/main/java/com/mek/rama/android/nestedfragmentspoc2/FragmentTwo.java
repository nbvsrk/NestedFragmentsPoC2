package com.mek.rama.android.nestedfragmentspoc2;

/**
 * Created by SreeRamakrishna on 13-05-2015.
 */



import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class FragmentTwo extends Fragment {
    ListView listView;
    ArrayList<String> childList = new ArrayList<String>();
    private static final String TAG = FragmentTwo.class.getSimpleName();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle bundle) {
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        if (getArguments() != null) {
            final String value = getArguments().getString("parentPosition");
            listView = (ListView) view.findViewById(R.id.lv_child_items);
            if (value != null) {
                FragmentThree fragThree = new FragmentThree();
                FragmentManager supportFragmentManager = getFragmentManager();
                supportFragmentManager.beginTransaction().hide(fragThree);
                switch (value) {
                    case "Parent 1":
                        childList.clear();
                        childList.add("Child 1-1");
                        childList.add("Child 1-2");
                        childList.add("Child 1-3");
                        break;
                    case "Parent 2":
                        childList.clear();
                        childList.add("Child 2-1");
                        childList.add("Child 2-2");
                        childList.add("Child 2-3");
                        childList.add("Child 2-4");
                        break;
                    case "Parent 3":
                        childList.clear();
                        childList.add("Child 3-1");
                        childList.add("Child 3-2");
                        childList.add("Child 3-3");
                        break;
                    case "Parent 4":
                        childList.clear();
                        childList.add("Child 4-1");
                        childList.add("Child 4-2");
                        childList.add("Child 4-3");
                        childList.add("Child 4-4");
                        break;
                    case "Parent 5":
                        childList.clear();
                        childList.add("Child 5-1");
                        childList.add("Child 5-2");

                        break;

                    default:
                        break;
                }
                listView.setAdapter(new ArrayAdapter(getActivity(),
                        android.R.layout.simple_list_item_1, childList));
                listView.setOnItemClickListener(new OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView parent, View view,
                                            int position, long id) {
                /*        Toast.makeText(getActivity(), childList.get(position),
                                Toast.LENGTH_SHORT).show();*/
                        Log.d(TAG,""+ childList.get(position));
                        FragmentThree fragment = new FragmentThree();
                        final Bundle bundle = new Bundle();
                        bundle.putString("ChildPosition", value + "\n"
                                + childList.get(position));
                        fragment.setArguments(bundle);
                        FragmentManager supportFragmentManager = getFragmentManager();
                        supportFragmentManager
                                .beginTransaction()
                                .replace(R.id.detailsPage, fragment,
                                        "fragmenthree").commit();
                    }
                });
            }
        }
        return view;
    }
}