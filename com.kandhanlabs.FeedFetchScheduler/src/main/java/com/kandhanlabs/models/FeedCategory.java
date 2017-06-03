package com.kandhanlabs.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

/**
 * Created by gbalasubramanian on 03/06/17.
 */
@Getter
@Setter
@AllArgsConstructor
@ToString
public class FeedCategory {
    UUID categoryId;
    String category;
}
