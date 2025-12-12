package edu.najah.cap.advance.assignments.assignment2;

public class SystemEventHandler implements EventTypeHandler {
    @Override
    public void handle(Event e) {
        System.out.println("[SYSTEM] system audit log " + e.getId());
    }
}
