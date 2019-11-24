package DAO;

import classes.Cliente;
import classes.Estado;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EstadoDAO extends BaseDAOImp implements BaseDAO<Estado> {

    private static final Logger log = Logger.getLogger(ClienteDAO.class.getName());

    public EstadoDAO() {
        super();
    }

    public EstadoDAO(java.sql.Connection con) {
        setConnection(con);
    }

    @Override
    public List<Estado> findEntities() {
        return findEntities(true, -1, -1);
    }

    @Override
    public List<Estado> findEntities(int maxResults, int firstResult) {
        return findEntities(false, maxResults, firstResult);
    }

    @Override
    public List<Estado> findEntities(boolean all, int maxResults, int firstResult) {

        List<Estado> result = null;
        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;

        try {
            verificaConexao();
            ps = conn.prepareStatement("select * from tb_Estado ");
            rs = ps.executeQuery();

            if (rs.next()) {
                result = new java.util.ArrayList<Estado>();
                if (!all) {
                    int contagem = 1;  
                    while (contagem < firstResult) {
                        rs.next();
                        contagem++;
                    }
                }
                do {
                    Estado p = new Estado();
                    p.setIdEstado(rs.getInt("id_Estado"));
                    p.setNomeEstado(rs.getString("nome_Estado"));
                    p.setSiglaEstado(rs.getString("sigla_Estado"));

                    result.add(p);
                } while ((result.size() < maxResults || all) && rs.next());
            }

        } catch (java.sql.SQLException ex) {
            ex.printStackTrace();
            //log.severe("", ex);
        } finally {
            JDBCUtils.close(rs);
            JDBCUtils.close(ps);
        }
        return result;
    }

    @Override
    public Estado find(Integer id) {
        Estado p = null;

        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        String sql = "SELECT * from tb_Estado where id_Estado = ?";

        try {
            ps = getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {

                p = new Estado();
                p.setIdEstado(rs.getInt("id_estado"));
                p.setNomeEstado(rs.getString("nome_estado"));
                p.setSiglaEstado(rs.getString("sigla_estado"));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            //log.severe("", ex);
        } finally {
            JDBCUtils.close(rs);
            JDBCUtils.close(ps);
        }
        return p;
    }

    @Override
    public void create(Estado vo) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void edit(Estado vo) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void destroy(Estado obj) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void destroy(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void destroy(String id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}
