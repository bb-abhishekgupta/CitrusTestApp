package com.poc.citrusadtester.models;

import lombok.Data;

@Data
public class SvcResponse {

    private int status;
    private String message;
    private Object body;
}
