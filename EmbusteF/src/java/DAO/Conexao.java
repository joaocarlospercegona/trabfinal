/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dieval
 */
public final class Conexao {

    private static Conexao INSTANCE = null;

    private java.sql.Connection conn = null;

    private Conexao() {
    }

    public static synchronized Conexao getInstance() {
        if (INSTANCE == null) {
            synchronized (Conexao.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Conexao();
                }
            }
        }
        return INSTANCE;
    }

    public java.sql.Connection getConnection() {
        if (this.conn == null) {
            java.sql.Connection c = null;
            try {
                Class.forName("org.postgresql.Driver");

//                c = DriverManager.getConnection("jdbc:h2:file:C:\\projetos\\aula\\AgendaJDBC\\dados\\agenda",
                c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Embuste",
                "usuario", "form4141");

                if (c != null) {
                    this.conn = c;
                    System.out.println("Conexao com BD aberta.");
                }
            } catch (ClassNotFoundException ex) {
                    System.out.println(ex.toString());  
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                System.out.println(ex.toString());  
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conn;
    }

    public void close() {
        if (this.conn != null) {
            try {
                this.conn.close();
                this.conn = null;
                System.out.println("Conexao com BD fechada.");
            } catch (SQLException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static Connection getConnection(Properties databaseProperties) {
        return getInstance().getConnection();
    }

}

