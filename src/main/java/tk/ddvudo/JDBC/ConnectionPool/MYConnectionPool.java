package tk.ddvudo.JDBC.ConnectionPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MYConnectionPool {
    private List<Connection> connections = new ArrayList<>();
    private int poolSize;

    public MYConnectionPool(int size) throws SQLException {
        poolSize = size;
        for (int i = 0; i < poolSize; i++) {
            Connection c = DriverManager.getConnection("jdbc:mysql://ddvudo.tk:3306/mysql?characterEncoding=UTF-8",
                    "root", "liukang951006");
            connections.add(c);
        }
    }

    public synchronized Connection getConnection() {
        try {
            while (connections.size() == 0) {
                this.wait();
            }
            return connections.remove(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.notifyAll();
        }
        return null;
    }

    public synchronized boolean cLoseConnection(Connection c) {
        try {
            while (connections.size() >= poolSize) {
                this.wait();
            }
            return connections.add(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            this.notifyAll();
        }
        return false;
    }
}
