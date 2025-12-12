package edu.najah.cap.advance.assignments.assignment2;

public abstract class DataDecorator implements Data {
    protected final Data wrappee;

    protected DataDecorator(Data wrappee) {
        this.wrappee = wrappee;
    }
}
