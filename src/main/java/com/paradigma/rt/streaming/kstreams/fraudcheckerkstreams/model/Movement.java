package com.paradigma.rt.streaming.kstreams.fraudcheckerkstreams.model;

import lombok.*;

@Data
@Builder
public class Movement {

    String id;
    String card;
    float amount;
    long origin;
    String site;
    String device;
    String createdAt;

}
