package DAO;

import classes.categoria;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

public class CategoriaDAO extends BaseDAOImp implements BaseDAO<categoria>{
    private static final Logger log = Logger.getLogger(ClienteDAO.class.getName());
  
    public CategoriaDAO(){
      super();
    }

    public CategoriaDAO(java.sql.Connection con) {
        setConnection(con);
    }

    @Override
    public void create(categoria categoria) {
      java.sql.PreparedStatement ps = null;
      java.sql.ResultSet rs = null;
      String sql = "INSERT INTO categoria (categoria_nome) VALUES (?)";
      
      try {
            ps = getConnection().prepareStatement(sql);
            
            ps.setString(1, categoria.getCategoria_nome());
            
            if (ps.executeUpdate() == 0) {
                log.warning(ps.toString() + " not inserted.");
            } else {
                rs = ps.getGeneratedKeys();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            //log.severe("", ex);
        } finally {
            JDBCUtils.close(ps);
        }

    }
    
    public void edit(categoria categoria, int id) {
      java.sql.PreparedStatement ps = null;
      String sql = "UPDATE categoria SET categoria_nome = ?"
                + " where categoria_codigo = ?";

        try {
            ps = getConnection().prepareStatement(sql);
            
            ps.setString(1,  categoria.getCategoria_nome());
            ps.setInt(2,  id);
            
            if (ps.executeUpdate() == 0) {
                log.warning(ps.toString() + " not updated.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            //log.severe("", ex);
        } finally {
            JDBCUtils.close(ps);
        }
    }
    
    public String destroy(int id) {
      java.sql.PreparedStatement ps = null;
      String sql = "delete from categoria where categoria_codigo = ?";

      try {
          ps = getConnection().prepareStatement(sql);
          ps.setInt(1, id);
          if (ps.executeUpdate() == 0) {
              log.warning(ps.toString() + " not deleted.");
          }
      } catch (SQLException ex) {
          ex.printStackTrace();
          return "Não foi possivel deletar";
      } finally {
          JDBCUtils.close(ps);
      }
      return null;
    }
    
    @Override
    public void destroy(categoria value) {
        destroy( value.getCategoria_codigo());
    }
    
        @Override
    public List<categoria> findEntities() {
        return findEntities(true, -1, -1);
    }

    @Override
    public List<categoria> findEntities(int maxResults, int firstResult) {
        return findEntities(false, maxResults, firstResult);
    }

    @Override
    public List<categoria> findEntities(boolean all, int maxResults, int firstResult) {
      List<categoria> result = null;
      java.sql.PreparedStatement ps = null;
      java.sql.ResultSet rs = null;

        try {
          verificaConexao();
          ps = conn.prepareStatement("select * from categoria ");
            rs = ps.executeQuery();

            if (rs.next()) {
                result = new java.util.ArrayList<categoria>();
                if (!all) {
                    int contagem = 1;  
                    while (contagem < firstResult) {
                        rs.next();
                        contagem++;
                    }
                }
                do {
                  categoria p = new categoria();
                  
                  p.setCategoria_codigo(rs.getInt("categoria_codigo"));
                  p.setCategoria_nome(rs.getString("categoria_nome"));
                  
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
    public categoria find(Integer id) {
        categoria p = null;

        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        String sql = "SELECT * from categoria where categoria_codigo = ?";

        try {
            ps = getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                  p = new categoria();
                  
                  p.setCategoria_nome(rs.getString("categoria_nome"));
                  p.setCategoria_codigo(rs.getInt("categoria_codigo"));
                  
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
    
    public categoria findByNome(String nome) {
        categoria vo = null;
        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        String sql = "select categoria_codigo,categoria_nome "
                + " from categoria where categoria_nome = ?";
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            if (rs.next()) {
                vo = new categoria();
                vo.setCategoria_codigo(rs.getInt(1));
                vo.setCategoria_nome(rs.getString(2));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            //log.severe("", ex);
        } finally {
            JDBCUtils.close(rs);
            JDBCUtils.close(ps);
        }
        return vo;
    }
    
    @Override
    public int getCount() {
        int result = 0;
        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        String sql = "select count(1) from categoria";
        try {
            ps = getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            //log.severe("", ex);
        } finally {
            JDBCUtils.close(rs);
            JDBCUtils.close(ps);
        }
        return result;
    }
    
    @Override
    public void edit(categoria vo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
