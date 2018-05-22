package com.example.android.ksacourses.models;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.io.Serializable;
import java.util.List;

@Root(name = "channel", strict = false)
public class Channel implements Serializable {

    @Element(name = "title", required = false)
    private String title;
    @Element(name = "link", required = false)
    private String link;
    @ElementList(inline = true, name = "item")
    private List<Item> items;

//    public Channel() {
//
//    }
//
//    public Channel(String title, String link, List<Item> items) {
//        this.title = title;
//        this.link = link;
//        this.items = items;
//    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }


    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
