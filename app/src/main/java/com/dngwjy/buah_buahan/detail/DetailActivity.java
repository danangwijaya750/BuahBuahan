package com.dngwjy.buah_buahan.detail;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.dngwjy.buah_buahan.R;

public class DetailActivity extends AppCompatActivity {
private TextView textJudul,textDesc;
private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        textJudul=(TextView)findViewById(R.id.textJudul);
        textDesc=(TextView)findViewById(R.id.textDesc);
        imageView=(ImageView)findViewById(R.id.imageView);
        initData();
    }
    void initData(){
        Intent intent= getIntent();
        textJudul.setText(intent.getStringExtra("title"));
        textDesc.setText(intent.getStringExtra("desc"));
        imageView.setImageResource(intent.getIntExtra("image",-1));
    }
}
