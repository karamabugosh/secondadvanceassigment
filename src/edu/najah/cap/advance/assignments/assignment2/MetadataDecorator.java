package edu.najah.cap.advance.assignments.assignment2;

public class MetadataDecorator extends DataDecorator {

    private final String metadata;

    public MetadataDecorator(Data wrappee, String metadata) {
        super(wrappee);
        this.metadata = metadata;
    }

    @Override
    public String getValue() {
        return "META(" + metadata + ")::" + wrappee.getValue();
    }
}
