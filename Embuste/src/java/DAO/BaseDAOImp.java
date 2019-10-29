/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;

/**
 *
 * @author Dieval Guizelini
 */
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

    /**
     * @return the databaseProperties
     */
    public java.util.Properties getDatabaseProperties() {
        return databaseProperties;
    }

    /**
     * @param databaseProperties the databaseProperties to set
     */
    public void setDatabaseProperties(java.util.Properties databaseProperties) {
        this.databaseProperties = databaseProperties;
    }

}

