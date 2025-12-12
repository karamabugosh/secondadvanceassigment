package edu.najah.cap.advance.assignments.assignment2;

import java.util.Map;

public class App {

    public static void main(String[] args) {

        Database rawDatabase = new Database();
        Logger logger = new Logger();
        Dashboard dashboard = new Dashboard();

        ConnectionPool pool = new ConnectionPool(2);

        DatabaseService realDb = new RealDatabase(rawDatabase, pool);
        DatabaseService dbProxy = new DatabaseProxy(realDb, logger);

        Map<String, EventTypeHandler> handlers = Map.of(
                "SECURITY", new SecurityEventHandler(),
                "USER", new UserEventHandler(),
                "SYSTEM", new SystemEventHandler()
        );

        EventProcessor processor = new EventProcessor(dbProxy, handlers);
        processor.registerObserver(dashboard);
        processor.registerObserver(logger);

        Event event = new Event("SECURITY", "login attempt");
        event.setEncrypt(true);
        event.setCompress(true);
        event.setAddMetadata(true);
        event.setMetadata("ip=1.2.3.4");

        processor.process(event);
    }
}
