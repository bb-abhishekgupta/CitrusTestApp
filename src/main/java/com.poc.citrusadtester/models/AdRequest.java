package com.poc.citrusadtester.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdRequest {
    private String customerId;
    private String sessionId;
    private String placement;
    private String catalogId;
    private String searchTerm;
    private FilterMode options;
    private int maxNumberOfAds;

}
