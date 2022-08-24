package com.epam.rd.autotasks.sprintplanning.tickets;

public class Bug extends Ticket {

    private UserStory  userStory;

    public static Bug createBug(int id, String name, int estimate, UserStory userStory) {

        if(userStory!=null && userStory.isCompleted()){
            return new Bug(id, name,estimate, userStory);
        }

        return null;
    }

    private Bug(int id, String name, int estimate, UserStory userStory) {
        super(id, name, estimate);
        this.userStory = userStory;
    }

    @Override
    public String toString() {
return "[Bug " + super.getId()+"] "+userStory.getName()+": "+this.getName();
    }
}
