package edu.najah.cap.advance.assignments.assignment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class EventProcessor extends AbstractEventProcessor {

    private final DatabaseService database;
    private final Map<String, EventTypeHandler> handlers;
    private final List<EventObserver> observers = new ArrayList<>();
    private Event workingEvent;

    public EventProcessor(DatabaseService database, Map<String, EventTypeHandler> handlers) {
        this.database = database;
        this.handlers = handlers;
    }

    public EventProcessor(DatabaseService database,
                          Map<String, EventTypeHandler> handlers,
                          EventObserver... defaultObservers) {
        this.database = database;
        this.handlers = handlers;
        if (defaultObservers != null) {
            for (EventObserver o : defaultObservers) {
                if (o != null) observers.add(o);
            }
        }
    }

    public void registerObserver(EventObserver o) {
        if (o != null) observers.add(o);
    }

    @Override
    protected void validate(Event e) {
        workingEvent = e.clone();
        if (workingEvent.getPayload() == null || workingEvent.getPayload().isEmpty()) {
            throw new IllegalArgumentException("Invalid event payload");
        }
        if (workingEvent.getId() == null || workingEvent.getId().isEmpty()) {
            workingEvent.setId(UUID.randomUUID().toString());
        }
    }

    @Override
    protected void notifyObservers(Event e) {
        for (EventObserver o : observers) {
            o.onEvent(workingEvent);
        }
    }

    @Override
    protected String transform(Event e) {
        Data data = new RawData(workingEvent.getPayload());
        if (workingEvent.isEncrypt()) {
            data = new EncryptDecorator(data);
        }
        if (workingEvent.isCompress()) {
            data = new CompressDecorator(data);
        }
        if (workingEvent.isAddMetadata()) {
            data = new MetadataDecorator(data, workingEvent.getMetadata());
        }
        return data.getValue();
    }

    @Override
    protected void persist(Event e, String data) {
        database.save(workingEvent.getId(), data);
    }

    @Override
    protected void afterProcess(Event e) {
        EventTypeHandler handler = handlers.get(workingEvent.getType());
        if (handler != null) {
            handler.handle(workingEvent);
        }
    }
}
