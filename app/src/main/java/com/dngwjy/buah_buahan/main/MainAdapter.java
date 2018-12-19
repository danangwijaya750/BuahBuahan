package com.dngwjy.buah_buahan.main;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.dngwjy.buah_buahan.R;
import com.dngwjy.buah_buahan.data.Buah;
import com.dngwjy.buah_buahan.detail.DetailActivity;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHold> {
    Context context;
    List<Buah> dataBuah;

    public MainAdapter(Context context, List<Buah> dataBuah) {
        this.context = context;
        this.dataBuah = dataBuah;

    }

    @NonNull
    @Override
    public ViewHold onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.buah_items,viewGroup,false);
        return new ViewHold(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHold viewHold, int i) {
       viewHold.BindItems(dataBuah.get(i));
    }

    @Override
    public int getItemCount() {
        return dataBuah.size();
    }



    public class ViewHold extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;
        public ViewHold(@NonNull View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.text);
            imageView=(ImageView)itemView.findViewById(R.id.imageView);

        }
        public void BindItems(final Buah buah){
            textView.setText(buah.getBuah());
            final String desc=buah.getDescription();
            final int image=buah.getGambar();
            imageView.setImageResource(buah.getGambar());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,DetailActivity.class);
                    intent.putExtra("title",textView.getText());
                    intent.putExtra("desc",desc);
                    intent.putExtra("image",image);
//                    Toast.makeText(context,image,Toast.LENGTH_LONG).show();
                    context.startActivity(intent);
                }
            });
        }


    }
}
