package edu.najah.cap.advance.assignments.assignment2;

public class SecurityEventHandler implements EventTypeHandler {
    @Override
    public void handle(Event e) {
        System.out.println("[SECURITY] extra analysis for " + e.getId());
        System.out.println("[SecurityMonitor] alert for " + e.getId());
    }
}
