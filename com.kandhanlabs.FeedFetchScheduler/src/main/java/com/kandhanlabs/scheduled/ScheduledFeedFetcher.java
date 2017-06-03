package com.kandhanlabs.scheduled;

import com.kandhanlabs.dao.FeedCategoryRepository;
import com.kandhanlabs.models.FeedCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by gbalasubramanian on 03/06/17.
 */
@Component
public class ScheduledFeedFetcher {

    @Autowired
    FeedCategoryRepository feedCategoryRepository;

    @Scheduled(fixedDelay = 9000)
    public void fetchFeeds() {
        List<FeedCategory> feedCategories = feedCategoryRepository.getCategories();
        feedCategories.forEach(System.out::println);
    }
}
