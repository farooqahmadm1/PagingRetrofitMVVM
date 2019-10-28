package com.example.pagingretrofitmvvm.DataSource;


import android.arch.lifecycle.MutableLiveData;
import android.arch.paging.DataSource;
import android.arch.paging.PageKeyedDataSource;

import com.example.pagingretrofitmvvm.Item;

public class ItemDataSourceFactory extends DataSource.Factory<Integer, Item> {

    private MutableLiveData<PageKeyedDataSource<Integer,Item>> itemLiveDataSource = new MutableLiveData<>();

    @Override
    public DataSource<Integer, Item> create() {

        ItemDataSource itemDataSource = new ItemDataSource();

        itemLiveDataSource.postValue(itemDataSource);

        return itemDataSource;
    }


    public MutableLiveData<PageKeyedDataSource<Integer,Item>> getItemLiveDataSource(){
        return itemLiveDataSource;
    }
}
