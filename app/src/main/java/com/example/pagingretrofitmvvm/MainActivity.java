package com.example.pagingretrofitmvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.pagingretrofitmvvm.Adapter.ItemAdapter;
import com.example.pagingretrofitmvvm.databinding.ActivityMainBinding;
import com.example.pagingretrofitmvvm.viewmodel.ItemViewModel;

public class MainActivity extends AppCompatActivity {

    private Context context;
    public ItemAdapter  adapter;
    ItemViewModel viewModel;

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.recycler.setLayoutManager(new LinearLayoutManager(this));
        binding.recycler.setHasFixedSize(true);

        adapter = new ItemAdapter(MainActivity.this);
        binding.recycler.setAdapter(adapter);


        viewModel = ViewModelProviders.of(this).get(ItemViewModel.class);
        viewModel.itemPageList.observe(this, new Observer<PagedList<Item>>() {
            @Override
            public void onChanged(@Nullable PagedList<Item> items) {
                adapter.submitList(items);
            }
        });


    }
}
