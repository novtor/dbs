package com.egencia.codeacademy.databases.postgresql.jdbc.model;

public class Traveler {
    private Long travelerId;
    private String travelerName;

    public Traveler(String travelerName) {
        this(null, travelerName);
    }

    public Traveler(Long travelerId, String travelerName) {
        this.travelerId = travelerId;
        this.travelerName = travelerName;
    }

    public long getTravelerId() {
        return travelerId;
    }

    public void setTravelerId(long travelerId) {
        this.travelerId = travelerId;
    }

    public String getTravelerName() {
        return travelerName;
    }

    public void setTravelerName(String travelerName) {
        this.travelerName = travelerName;
    }

    @Override
    public String toString() {
        return "Traveler{" +
                "travelerId=" + travelerId +
                ", travelerName='" + travelerName + '\'' +
                '}';
    }
}
