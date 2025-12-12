package edu.najah.cap.advance.assignments.assignment2;

public class Logger implements EventObserver {

    public void log(Event e) {
        System.out.println("[Log] Processed event " + e.getId()
                + " type " + e.getType());
    }

    @Override
    public void onEvent(Event e) {
        log(e);
    }
}
