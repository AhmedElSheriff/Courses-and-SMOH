package com.example.android.ksacourses.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.ksacourses.R;
import com.example.android.ksacourses.adapters.RecyclerViewAdapter;
import com.example.android.ksacourses.interfaces.RetroFitInterface;
import com.example.android.ksacourses.models.Item;
import com.example.android.ksacourses.models.NewsData;
import com.example.android.ksacourses.models.Rss;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class NewsFragment extends android.support.v4.app.Fragment {

    private static final String BASE_URL = "https://www.moh.gov.sa/";


    public NewsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_fragment,container,false);


        final List<NewsData> newsDataList = new ArrayList<>();

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30,TimeUnit.SECONDS).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        RetroFitInterface retroFitInterface = retrofit.create(RetroFitInterface.class);
        final RecyclerView recyclerView = view.findViewById(R.id.news_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Call<Rss> connection = retroFitInterface.getItems();
        connection.enqueue(new Callback<Rss>() {
            @Override
            public void onResponse(Call<Rss> call, Response<Rss> response) {
                Log.d("Connection State", "Success: " + response.body().getChannel().getItems());
                int responseSize = response.body().getChannel().getItems().size();
                Item item;

                for(int i = 0; i < responseSize; i++){
                    NewsData newsData = new NewsData();
                    item = response.body().getChannel().getItems().get(i);
                    newsData.setDesc(item.getDescription());
                    newsData.setTitle(item.getTitle());
                    newsData.setPubDate(item.getPubDate());
                    newsData.setLink(item.getLink());
                    newsDataList.add(newsData);

                }
                RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(newsDataList);
                recyclerView.setAdapter(recyclerViewAdapter);
                recyclerView.setItemAnimator(new DefaultItemAnimator());

            }

            @Override
            public void onFailure(Call<Rss> call, Throwable t) {
                Log.d("Connection State", t.toString());
            }
        });







        return view;
    }
}
