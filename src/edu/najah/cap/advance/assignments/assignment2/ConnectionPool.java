package edu.najah.cap.advance.assignments.assignment2;

import java.util.ArrayDeque;
import java.util.Queue;

public class ConnectionPool {

    private final Queue<DbConnection> pool = new ArrayDeque<>();
    private int nextId = 1;

    public ConnectionPool(int size) {
        for (int i = 0; i < size; i++) {
            pool.add(new DbConnection(nextId++));
        }
    }

    public synchronized DbConnection getConnection() {
        if (pool.isEmpty()) {
            return new DbConnection(nextId++);
        }
        return pool.poll();
    }

    public synchronized void releaseConnection(DbConnection c) {
        pool.offer(c);
    }
}
