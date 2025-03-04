package com.fatima.control_blanc;

public class Incident {
    private String reference;
    private String time;
    private String status;

    public Incident(String reference, String time, String status) {
        this.reference = reference;
        this.time = time;
        this.status = status;
    }

    // Getters et setters
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

