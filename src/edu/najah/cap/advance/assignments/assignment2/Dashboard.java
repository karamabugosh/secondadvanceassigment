package edu.najah.cap.advance.assignments.assignment2;

public class Dashboard implements EventObserver {

    @Override
    public void onEvent(Event e) {
        System.out.println("[Dashboard] metrics updated for " + e.getId()
                + ", payload: " + e.getPayload());
    }
}
