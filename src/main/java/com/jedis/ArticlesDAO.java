package com.jedis;

/**
 * Created by adimn on 2018/1/9.
 */
public interface ArticlesDAO {
    Long putArticles(Articles articles);
    Articles getArticles(Long postID);
}
