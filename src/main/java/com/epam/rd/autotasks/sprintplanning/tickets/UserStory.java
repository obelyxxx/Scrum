package com.epam.rd.autotasks.sprintplanning.tickets;

public class UserStory extends Ticket {
    private UserStory[] dependencies;

    public UserStory(int id, String name, int estimate, UserStory... dependsOn) {
        super(id, name, estimate);
        this.dependencies = dependsOn;
//        throw new UnsupportedOperationException("Implement this method");
    }

    @Override
    public void complete() {
        for(UserStory d: dependencies){
            if(!d.isCompleted()) return;
        }
        super.complete();
//        throw new UnsupportedOperationException("Implement this method");
    }

    public UserStory[] getDependencies() {
        return (UserStory []) dependencies.clone();
//        throw new UnsupportedOperationException("Implement this method");
    }

    @Override
    public String toString() {
//        throw new UnsupportedOperationException("Implement this method");
        return String.format("[US %d] %s", this.getId(), this.getName());
    }
}