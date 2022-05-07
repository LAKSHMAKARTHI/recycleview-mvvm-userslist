package com.example.rcvm;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.example.rcvm.adapters.UsersListAdapter;
import com.example.rcvm.models.DataModel;
import com.example.rcvm.models.ResponseModal;
import com.example.rcvm.viewmodels.UsersListViewModel;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recView;
    List<DataModel> usersList;
    UsersListViewModel listViewModel;
    UsersListAdapter adapter;
    TextView notFound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recView = findViewById(R.id.recview);
        notFound = findViewById(R.id.noresult);

        recView.setLayoutManager(new LinearLayoutManager(this));
        recView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        adapter = new UsersListAdapter(usersList);
        recView.setAdapter(adapter);

        listViewModel= ViewModelProviders.of(this).get(UsersListViewModel.class);
        listViewModel.getUserslistObserver().observe(this, new Observer<ResponseModal>() {
            @Override
            public void onChanged(ResponseModal data) {
                if(data != null) {
                    usersList = data.getData();
                    adapter.updateuserslist(usersList);
                    notFound.setVisibility(View.GONE);
                } else {
                    recView.setVisibility(View.GONE);
                    notFound.setVisibility(View.VISIBLE);
                }
            }
        });
        listViewModel.makeApiCall();
    }
}