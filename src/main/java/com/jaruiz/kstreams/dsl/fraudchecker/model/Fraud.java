package com.jaruiz.kstreams.dsl.fraudchecker.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Fraud {

    public final static String ONLINE_FRAUD_DESCRIPTION = "ONLINE";
    public final static String PHYSICAL_FRAUD_DESCRIPTION = "PHYSICAL";
    public static final int ONLINE_MOVEMENT = 3;

    private String card;
    private String description;
    float totalAmount;
    private Set<String> movements;
    private Set<String> devices;
    private Set<String> sites;

    public Fraud(){
        this.totalAmount = 0f;
        this.movements = new HashSet<>();
        this.devices = new HashSet<>();
        this.sites = new HashSet<>();
    }

    public void addMovement(Movement movement){
        this.description = movement.getOrigin() == ONLINE_MOVEMENT ? ONLINE_FRAUD_DESCRIPTION : PHYSICAL_FRAUD_DESCRIPTION;
        this.card = movement.getCard();
        this.totalAmount += movement.getAmount();
        this.movements.add(movement.getId());
    }

    public void addDevice(Movement movement){
        if (movement.getOrigin() != ONLINE_MOVEMENT){
            this.devices.add(movement.getDevice());
        }
    }

    public void addSites(Movement movement){
        if (movement.getOrigin() == ONLINE_MOVEMENT){
            this.sites.add(movement.getSite());
        }
    }

}