package edu.najah.cap.advance.assignments.assignment2;

public class EncryptDecorator extends DataDecorator {

    public EncryptDecorator(Data wrappee) {
        super(wrappee);
    }

    @Override
    public String getValue() {
        return "ENC(" + wrappee.getValue() + ")";
    }
}
