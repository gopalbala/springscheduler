package com.kandhanlabs.dao;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import com.kandhanlabs.models.FeedCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by gbalasubramanian on 03/06/17.
 */
@Component
public class FeedCategoryRepository {
    @Autowired
    Session session;

    public List<FeedCategory> getCategories() {
        String query = "select categoryid , category from feeds.feedcategories";
        List<FeedCategory> feedCategories = new ArrayList<>();
        ResultSet resultSet = session.execute(query);
        resultSet.all().stream().forEach(r -> feedCategories.add(new FeedCategory( r.getUUID("categoryid"),r.getString("category"))));
        return  feedCategories;
    }
}
