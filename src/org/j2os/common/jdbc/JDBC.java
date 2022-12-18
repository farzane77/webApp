package org.j2os.common.jdbc;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;

public class JDBC {
    public static final int ORCL = 1;
    public static final int XE = 2;
    private static final BasicDataSource ORCL_DATA_SOURCE = new BasicDataSource();
    private static final BasicDataSource XE_DATA_SOURCE = new BasicDataSource();

    static {
        ORCL_DATA_SOURCE.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ORCL_DATA_SOURCE.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        ORCL_DATA_SOURCE.setUsername("amirsam");
        ORCL_DATA_SOURCE.setPassword("myjava123");
        ORCL_DATA_SOURCE.setMaxTotal(10);

        XE_DATA_SOURCE.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        XE_DATA_SOURCE.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        XE_DATA_SOURCE.setUsername("amirsam");
        XE_DATA_SOURCE.setPassword("myjava123");
        XE_DATA_SOURCE.setMaxTotal(10);
    }

    public static Connection getConnection(int database) throws Exception {
        Connection connection = null;
        switch (database) {
            case ORCL:
                connection = ORCL_DATA_SOURCE.getConnection();
                connection.setAutoCommit(false);
                return connection;
            default:
                connection = XE_DATA_SOURCE.getConnection();
                connection.setAutoCommit(false);
                return connection;
        }
    }
}
