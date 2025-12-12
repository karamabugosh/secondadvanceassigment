package edu.najah.cap.advance.assignments.assignment2;

public class UserEventHandler implements EventTypeHandler {
    @Override
    public void handle(Event e) {
        System.out.println("[USER] user-specific step for " + e.getId());
    }
}
