package edu.najah.cap.advance.assignments.assignment2;

public class CompressDecorator extends DataDecorator {

    public CompressDecorator(Data wrappee) {
        super(wrappee);
    }

    @Override
    public String getValue() {
        return "CMP(" + wrappee.getValue() + ")";
    }
}
