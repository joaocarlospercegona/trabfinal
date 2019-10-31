/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classes.Produto;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author joao
 */
public class ProdutoDAO extends BaseDAOImp implements BaseDAO<Produto>{
    private static final Logger log = Logger.getLogger(ClienteDAO.class.getName());
  
    public ProdutoDAO(){
      super();
    }

    public ProdutoDAO(java.sql.Connection con) {
        setConnection(con);
    }

    @Override
    public void create(Produto produto) {
      java.sql.PreparedStatement ps = null;
      java.sql.ResultSet rs = null;
      String sql = "INSERT INTO produto (produto_nome, produto_cod_categoria, produto_descricao, produto_peso) VALUES (?,?,?,?)";
      
      try {
            ps = getConnection().prepareStatement(sql);
            
            ps.setString(1, produto.getProduto_nome());
            ps.setInt(2, produto.getProduto_cod_categoria());
            ps.setString(3, produto.getProduto_descricao());
            ps.setInt(4, produto.getProduto_peso());
            
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
    
    public void edit(Produto Produto, int id) {
      java.sql.PreparedStatement ps = null;
      String sql = "UPDATE produto SET produto_nome = ?, produto_cod_categoria = ?, produto_descricao = ?, produto_peso = ?"
                + " where produto_codigo = ?";

        try {
            ps = getConnection().prepareStatement(sql);
            
            ps.setString(1,  Produto.getProduto_nome());
            ps.setInt(2,     Produto.getProduto_cod_categoria());
            ps.setString(3,  Produto.getProduto_descricao());
            ps.setInt(4,     Produto.getProduto_peso());
            
            ps.setInt(5,  id);
            
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
    
    public void destroy(int id) {
      java.sql.PreparedStatement ps = null;
      String sql = "delete from produto where produto_codigo = ?";

      try {
          ps = getConnection().prepareStatement(sql);
          ps.setInt(1, id);
          if (ps.executeUpdate() == 0) {
              log.warning(ps.toString() + " not deleted.");
          }
      } catch (SQLException ex) {
          ex.printStackTrace();
          //log.severe("", ex);
      } finally {
          JDBCUtils.close(ps);
      }
    }
    
    @Override
    public void destroy(Produto value) {
        destroy( value.getProduto_codigo());
    }
    
        @Override
    public List<Produto> findEntities() {
        return findEntities(true, -1, -1);
    }

    @Override
    public List<Produto> findEntities(int maxResults, int firstResult) {
        return findEntities(false, maxResults, firstResult);
    }

    @Override
    public List<Produto> findEntities(boolean all, int maxResults, int firstResult) {
      List<Produto> result = null;
      java.sql.PreparedStatement ps = null;
      java.sql.ResultSet rs = null;

        try {
          verificaConexao();
          ps = conn.prepareStatement("select * from produto ");
            rs = ps.executeQuery();

            if (rs.next()) {
                result = new java.util.ArrayList<Produto>();
                if (!all) {
                    int contagem = 1;  // primeiro next
                    while (contagem < firstResult) {
                        rs.next();
                        contagem++;
                    }
                }
                do {
                  Produto p = new Produto();
                  
                  p.setProduto_nome(rs.getString("produto_nome"));
                  p.setProduto_codigo(rs.getInt("produto_codigo"));
                  p.setProduto_cod_categoria(rs.getInt("produto_cod_categoria"));
                  p.setProduto_descricao(rs.getString("produto_descricao"));
                  p.setProduto_peso(rs.getInt("produto_peso"));
                  
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
    public Produto find(Integer id) {
        Produto p = null;

        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        String sql = "SELECT * from produto where produto_codigo = ?";

        try {
            ps = getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                  p = new Produto();
                  
                  p.setProduto_nome(rs.getString("produto_nome"));
                  p.setProduto_codigo(rs.getInt("produto_codigo"));
                  p.setProduto_cod_categoria(rs.getInt("produto_cod_categoria"));
                  p.setProduto_descricao(rs.getString("produto_descricao"));
                  p.setProduto_peso(rs.getInt("produto_peso"));
                  
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
    
    public Produto findByNome(String nome) {
        Produto vo = null;
        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        String sql = "select produto_codigo, produto_nome, produto_cod_categoria, produto_descricao, produto_peso "
                + " from produto where produto_nome = ?";
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            if (rs.next()) {
                vo = new Produto();
                vo.setProduto_codigo(rs.getInt(1));
                vo.setProduto_nome(rs.getString(2));
                vo.setProduto_cod_categoria(rs.getInt(3));
                vo.setProduto_descricao(rs.getString(4));
                vo.setProduto_peso(rs.getInt(5));
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
        String sql = "select count(1) from produto";
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

    
    //------------------------------------------------------------------------------------------------------------------
    
    @Override
    public void edit(Produto vo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
