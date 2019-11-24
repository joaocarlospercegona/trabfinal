package DAO;

import java.sql.SQLException;

public class BaseDAOImp {

    private java.util.Properties databaseProperties;

    protected java.sql.Connection conn = null;

    public void verificaConexao() throws SQLException {
        if (conn == null) {
            conn = Conexao.getConnection(getDatabaseProperties());
        }
    }

    public void setConnection(java.sql.Connection conn) {
        this.conn = conn;
    }

    public java.sql.Connection getConnection() throws SQLException {
        verificaConexao();
        return conn;
    }
    public java.util.Properties getDatabaseProperties() {
        return databaseProperties;
    }

    public void setDatabaseProperties(java.util.Properties databaseProperties) {
        this.databaseProperties = databaseProperties;
    }

}

