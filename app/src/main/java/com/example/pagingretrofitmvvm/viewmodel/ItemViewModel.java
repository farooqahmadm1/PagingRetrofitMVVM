package com.example.pagingretrofitmvvm.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.LivePagedListBuilder;
import android.arch.paging.PageKeyedDataSource;
import android.arch.paging.PagedList;

import com.example.pagingretrofitmvvm.DataSource.ItemDataSource;
import com.example.pagingretrofitmvvm.DataSource.ItemDataSourceFactory;
import com.example.pagingretrofitmvvm.Item;

public class ItemViewModel extends ViewModel {

    public LiveData<PagedList<Item>> itemPageList;
    public LiveData<PageKeyedDataSource<Integer,Item>> dataSourceLiveData;

    public ItemViewModel() {

        ItemDataSourceFactory itemDataSourceFactory = new ItemDataSourceFactory();

        dataSourceLiveData = itemDataSourceFactory.getItemLiveDataSource();

        //getting PageList Configuration
        PagedList.Config  pagedListConfig =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(true)
                        .setPageSize(ItemDataSource.PAGE_SIZE).build();

        itemPageList = (new LivePagedListBuilder(itemDataSourceFactory,pagedListConfig)).build();
    }


}
