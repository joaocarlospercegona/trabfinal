/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Dieval Guizelini
 */
public final class JDBCUtils {

    private JDBCUtils() {
    }

    public static void close(java.sql.Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                // nada a fazer
            }
        }
    }

    public static void close(java.sql.PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                // nada a fazer
            }
        }
    }

    public static void close(Statement cmd) {
        if (cmd != null) {
            try {
                cmd.close();
            } catch (SQLException ex) {
                // nada a fazer
            }
        }
    }

    public static void close(java.sql.ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                // nada a fazer
            }
        }
    }
    
}
