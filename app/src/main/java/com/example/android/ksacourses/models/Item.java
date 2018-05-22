package com.example.android.ksacourses.models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.io.Serializable;

@Root(name = "item", strict = false)
public class Item implements Serializable{

    @Element(name = "title")
    private String title;
    @Element(name = "description")
    private String description;
    @Element(name = "link")
    private String link;
    @Element(name = "pubDate")
    private String pubDate;

//    public Item() {
//
//
//    }
//
//    public Item(String title, String description, String link, String pubDate) {
//        this.title = title;
//        this.description = description;
//        this.link = link;
//        this.pubDate = pubDate;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }
}
