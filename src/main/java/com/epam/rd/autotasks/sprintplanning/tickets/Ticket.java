package com.epam.rd.autotasks.sprintplanning.tickets;

public class Ticket {

    private int id;
    private String name;
    private int estimate;

    private boolean isComplete;

    public Ticket(int id, String name, int estimate) {

        this.id = id;
        this.name = name;
        this. estimate = estimate;

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getEstimate() {
        return estimate;
    }



    public boolean isCompleted() {
        return this.isComplete;
    }

    public void complete() {
       this.isComplete = true;
    }


}
