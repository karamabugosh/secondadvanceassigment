package edu.najah.cap.advance.assignments.assignment2;

public class RealDatabase implements DatabaseService {

    private final Database database;
    private final ConnectionPool pool;

    public RealDatabase(Database database, ConnectionPool pool) {
        this.database = database;
        this.pool = pool;
    }

    @Override
    public void save(String id, String data) {
        DbConnection c = pool.getConnection();
        try {
            database.save(id, data);
            System.out.println("[DB] used connection #" + c.getId());
        } finally {
            pool.releaseConnection(c);
        }
    }
}
