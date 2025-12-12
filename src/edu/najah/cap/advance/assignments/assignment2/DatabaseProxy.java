package edu.najah.cap.advance.assignments.assignment2;

public class DatabaseProxy implements DatabaseService {

    private final DatabaseService real;
    private final Logger logger;

    public DatabaseProxy(DatabaseService real, Logger logger) {
        this.real = real;
        this.logger = logger;
    }

    @Override
    public void save(String id, String data) {
        if (id == null || id.isEmpty()) {
            System.out.println("[DB-PROXY] invalid id");
            return;
        }
        System.out.println("[DB-PROXY] saving " + id);
        real.save(id, data);
    }
}
