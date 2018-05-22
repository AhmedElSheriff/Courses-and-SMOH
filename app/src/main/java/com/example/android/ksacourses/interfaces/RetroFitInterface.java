package com.example.android.ksacourses.interfaces;

import com.example.android.ksacourses.models.Rss;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetroFitInterface {
    String RSS = "_Layouts/moh/RssGenerator.aspx?WebSiteUrl=/Ministry/MediaCenter/News/&ListUrl=/Ministry/MediaCenter/News/Pages/&ViewName=RSSView&RssTitle=&RssDescription=&DescriptionField=BriefDesc";
    @GET(RSS)
    Call<Rss> getItems();
}
