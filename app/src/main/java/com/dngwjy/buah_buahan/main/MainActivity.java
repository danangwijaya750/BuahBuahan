package com.dngwjy.buah_buahan.main;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dngwjy.buah_buahan.R;
import com.dngwjy.buah_buahan.data.Buah;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
MainAdapter adapter;
List<Buah> buahList= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRecyclerView();
        setBuahList();
        setAdapter();
    }

    void  setRecyclerView(){
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(setLinear());
    }
    void  setBuahList(){
        String buah[]= getResources().getStringArray(R.array.buah);
        String desc[]= getResources().getStringArray(R.array.desc);
        TypedArray gambar = getResources().obtainTypedArray(R.array.gambar);
        Log.d("buah length", "setBuahList: "+buah.length);

        buahList.clear();
        for (int i = 0; i < buah.length; i++) {
            buahList.add(new Buah(buah[i],desc[i],gambar.getResourceId(i,-1)));
        }
    }
    void  setAdapter(){
        adapter = new MainAdapter(this,buahList);
        recyclerView.setAdapter(adapter);

    }
    LinearLayoutManager setLinear(){
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        return layoutManager;
    }
}
