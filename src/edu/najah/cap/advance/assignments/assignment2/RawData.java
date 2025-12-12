package edu.najah.cap.advance.assignments.assignment2;

public class RawData implements Data {
    private final String value;

    public RawData(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }
}
