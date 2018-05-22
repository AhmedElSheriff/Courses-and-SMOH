package com.example.android.ksacourses.adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.ksacourses.R;
import com.example.android.ksacourses.controller.BrowserActivity;
import com.example.android.ksacourses.models.NewsData;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {


    private static List<NewsData> mNewsDataList;
    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView newsDescTextView;
        TextView newsTitleTextView;
        TextView newsPubdateTextView;


        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            itemLayoutView.setOnClickListener(this);
            newsDescTextView = itemLayoutView.findViewById(R.id.news_descr_textview);
            newsTitleTextView = itemLayoutView.findViewById(R.id.news_title_textview);
            newsPubdateTextView = itemLayoutView.findViewById(R.id.news_pubdate_textview);
        }

        @Override
        public void onClick(View view) {
            Intent browserIntent = new Intent(view.getContext(), BrowserActivity.class);
            browserIntent.putExtra("Link",mNewsDataList.get(getAdapterPosition()).getLink());
            view.getContext().startActivity(browserIntent);

        }
    }

    public RecyclerViewAdapter(List<NewsData> newsDataList) {
        mNewsDataList = newsDataList;
        Log.d("recycler adapter",mNewsDataList.toString());

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_template,parent,false);

        ViewHolder viewHolder = new ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.newsDescTextView.setText(mNewsDataList.get(position).getDesc());
        holder.newsTitleTextView.setText(mNewsDataList.get(position).getTitle());
        holder.newsPubdateTextView.setText(mNewsDataList.get(position).getPubDate());
        Log.d("recycler adapter","Binding");
    }



    @Override
    public int getItemCount() {
        return mNewsDataList.size();
    }


}
