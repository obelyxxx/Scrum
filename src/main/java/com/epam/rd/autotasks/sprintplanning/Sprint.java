package com.epam.rd.autotasks.sprintplanning;

import com.epam.rd.autotasks.sprintplanning.tickets.Bug;
import com.epam.rd.autotasks.sprintplanning.tickets.Ticket;
import com.epam.rd.autotasks.sprintplanning.tickets.UserStory;

import java.util.Arrays;


public class Sprint {

    private Ticket []tickets;
    private int indexOfTicket=0;
    private int capacity;
    private int ticketsLimit;
    public Sprint(int capacity, int ticketsLimit) {
        this.capacity=capacity;
        this.ticketsLimit=ticketsLimit;
        if(ticketsLimit>0){
            tickets=new Ticket[0];
        }
    }
    public  boolean acceptedUncomplededDependencies(UserStory userStory){
        int count=0;
        for (UserStory dep:userStory.getDependencies()) {
            for (Ticket tk:getTickets()) {
                if(!dep.isCompleted()&&dep.equals(tk)){
                    count++;
                    break;
                }
            }
        }
        return count==userStory.getDependencies().length;
    }

    public boolean addUserStory(UserStory userStory) {
        if(userStory==null || userStory.isCompleted()|| userStory.getEstimate() + getTotalEstimate()>capacity
                ||!acceptedUncomplededDependencies(userStory) || indexOfTicket>=ticketsLimit)
            return false;
        tickets=Arrays.copyOf(tickets,tickets.length+1) ;
        tickets[indexOfTicket]=userStory;
        indexOfTicket++;
        return true;
    }

    public boolean addBug(Bug bugReport) {
        if(bugReport==null || bugReport.isCompleted()||getTotalEstimate()+bugReport.getEstimate()>capacity
                || indexOfTicket>=ticketsLimit)
            return false;

        tickets=Arrays.copyOf(tickets,tickets.length+1);
        tickets[indexOfTicket]=bugReport;
        indexOfTicket++;
        return  true;
    }



    public Ticket[] getTickets() {

        return Arrays.copyOf(tickets,tickets.length);
    }

    public int getTotalEstimate() {
        int sum=0;
        if(tickets!=null) {
            for (Ticket t : tickets) {
                if(t!=null)
                    sum += t.getEstimate();
            }
        }
        return sum;
    }

}
