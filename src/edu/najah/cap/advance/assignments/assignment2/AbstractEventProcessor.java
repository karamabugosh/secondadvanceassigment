package edu.najah.cap.advance.assignments.assignment2;

public abstract class AbstractEventProcessor {

    public final void process(Event e) {
        validate(e);
        notifyObservers(e);
        String data = transform(e);
        persist(e, data);
        afterProcess(e);
    }

    protected abstract void validate(Event e);
    protected abstract void notifyObservers(Event e);
    protected abstract String transform(Event e);
    protected abstract void persist(Event e, String data);
    protected abstract void afterProcess(Event e);
}
