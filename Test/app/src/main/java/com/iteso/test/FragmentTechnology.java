package com.iteso.test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iteso.test.Beans.ItemProduct;

import java.util.ArrayList;


public class FragmentTechnology extends Fragment {
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<ItemProduct> myDataSet;
    private RecyclerView recyclerView;

    public FragmentTechnology() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_technology, container, false);
        recyclerView = view.findViewById(R.id.fragment_technology_recycler_view);
        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        // Use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        if(myDataSet == null) {
            //Agregar la MAC
            myDataSet = new ArrayList<>();
            ItemProduct itemProductMac = new ItemProduct();
            itemProductMac.setCode(0);
            itemProductMac.setTitle(getString(R.string.mac_title));
            itemProductMac.setStore(getString(R.string.mac_store));
            itemProductMac.setLocation(getString(R.string.mac_location));
            itemProductMac.setPhone(getString(R.string.mac_phone));
            itemProductMac.setImage(0);
            itemProductMac.setDescription(getString(R.string.mac_description));
            myDataSet.add(itemProductMac);

            //Agregar Alienware
            ItemProduct itemProductAlienWare = new ItemProduct();
            itemProductAlienWare.setCode(1);
            itemProductAlienWare.setTitle(getString(R.string.alien_title));
            itemProductAlienWare.setStore(getString(R.string.alien_store));
            itemProductAlienWare.setLocation(getString(R.string.alien_location));
            itemProductAlienWare.setPhone(getString(R.string.alien_phone));
            itemProductAlienWare.setImage(1);
            itemProductAlienWare.setDescription(getString(R.string.alien_description));
            myDataSet.add(itemProductAlienWare);
        }

        mAdapter = new AdapterProduct(myDataSet, getActivity());
        recyclerView.setAdapter(mAdapter);
        return view;
    }

    public void modifyItem(ItemProduct itemProduct, int index) {
        myDataSet.set(index, itemProduct);
        mAdapter = new AdapterProduct(myDataSet, getActivity());
        recyclerView.setAdapter(mAdapter);
    }
}
