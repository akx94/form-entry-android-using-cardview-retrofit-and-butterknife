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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<Result> results;

    public RecyclerViewAdapter(Context context, List<Result> results) {
        this.context = context;
        this.results = results;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view,parent,false);
        ViewHolder holder = new ViewHolder(v);
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
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
        @BindView(R.id.textNpm) TextView TxtNpm;
        @BindView(R.id.textNama)TextView TxtNama;
        @BindView(R.id.textKelas)TextView TxtKelas;
        @BindView(R.id.textSesi)TextView TxtSesi;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
