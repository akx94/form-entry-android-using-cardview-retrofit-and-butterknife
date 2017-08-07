package com.example.panji.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Panji on 06/08/2017.
 */
//get value from API
    //map value to layout
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    //current data environtment such as current activity using Adapter
    private Context context;
    //data to bind to layout
    private List<Result> results;

    public RecyclerViewAdapter(Context context, List<Result> results) {
        //getting environtment and data
        this.context = context;
        this.results = results;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //stick layout to list view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view,parent,false);
        //init viewholder
        ViewHolder holder = new ViewHolder(v);
        //return holder
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //bind view data based on position to each id
        Result result = results.get(position);
        holder.TxtNpm.setText(result.getNpm());
        holder.TxtNama.setText(result.getNama());
        holder.TxtKelas.setText(result.getKelas());
        holder.TxtSesi.setText(result.getSesi());

    }



    @Override
    public int getItemCount() {
        return results.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        //bind tag in layout to variabel using butter knife
        @BindView(R.id.textNpm) TextView TxtNpm;
        @BindView(R.id.textNama)TextView TxtNama;
        @BindView(R.id.textKelas)TextView TxtKelas;
        @BindView(R.id.textSesi)TextView TxtSesi;
        public ViewHolder(View itemView) {
            super(itemView);
            //bind butterknife
            ButterKnife.bind(this,itemView);
        }
    }
}
