package com.jedis;

import org.msgpack.annotation.Message;

import java.util.Date;

/**
 * Created by adimn on 2018/1/9.
 */
@Message
public class Articles {

    private String title;

    private String content;

    private String author;

    private Date time;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTime(Date time) {
        this.time = time;
    }

}
