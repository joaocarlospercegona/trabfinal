/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classes.Atendimento;
import classes.Tipo_Atendimento;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author joao
 */
public class AtendimentoDAO extends BaseDAOImp implements BaseDAO<Atendimento>{
    
    private static final Logger log = Logger.getLogger(AtendimentoDAO.class.getName());
  
    public AtendimentoDAO(){
      super();
    }

    public AtendimentoDAO(java.sql.Connection con) {
        setConnection(con);
    }
    
    public void edit(String solucao, int id) {
        java.sql.PreparedStatement ps = null;
      String sql = "UPDATE atendimento SET atendimento_solucao = ?, atendimento_situacao = 'Finalizado' where atendimento_codigo = ?";

        try {
            ps = getConnection().prepareStatement(sql);
            
            ps.setString(1, solucao);
            ps.setInt(2, id);
            
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
    
    public List<Atendimento> findEntities(boolean all, int maxResults, int firstResult) {
        List<Atendimento> result = null;
      java.sql.PreparedStatement ps = null;
      java.sql.ResultSet rs = null;

        try {
          verificaConexao();
          ps = conn.prepareStatement("select * from atendimento order by atendimento_data_hora desc");
            rs = ps.executeQuery();

            if (rs.next()) {
                result = new java.util.ArrayList<Atendimento>();
                if (!all) {
                    int contagem = 1;  // primeiro next
                    while (contagem < firstResult) {
                        rs.next();
                        contagem++;
                    }
                }
                do {
                  Atendimento p = new Atendimento();
                  p.setAtendimento_codigo(rs.getInt("atendimento_codigo"));
                  p.setAtendimento_data_hora(rs.getDate("atendimento_data_hora"));
                  p.setAtendimento_cpf_cliente(rs.getString("atendimento_cpf_cliente"));
                  p.setAtendimento_situacao(rs.getString("atendimento_situacao"));
                  p.setAtendimento_cod_produto(rs.getInt("atendimento_cod_produto"));
                  p.setAtendimento_cod_tipo_atendimento(rs.getInt("atendimento_cod_tipo_atendimento"));
                  p.setAtendimento_descricao(rs.getString("atendimento_descricao"));
                  p.setAtendimento_solucao(rs.getString("atendimento_solucao"));
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
    
     public Atendimento find(String cod) {
        Atendimento p = null;

        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        String sql = "SELECT * from atendimento where atendimento_codigo = ?";

        try {
            ps = getConnection().prepareStatement(sql);
            ps.setString(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                  p = new Atendimento();
                  p.setAtendimento_codigo(rs.getInt("atendimento_codigo"));
                  p.setAtendimento_data_hora(rs.getDate("atendimento_data_hora"));
                  p.setAtendimento_cpf_cliente(rs.getString("atendimento_cpf_cliente"));
                  p.setAtendimento_situacao(rs.getString("atendimento_situacao"));
                  p.setAtendimento_cod_produto(rs.getInt("atendimento_cod_produto"));
                  p.setAtendimento_cod_tipo_atendimento(rs.getInt("atendimento_cod_atendimento"));
                  p.setAtendimento_descricao(rs.getString("atendimento_descricao"));
                  p.setAtendimento_solucao(rs.getString("atendimento_solucao"));
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
     
     public Tipo_Atendimento findt(int cod) {
        Tipo_Atendimento p = null;

        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        String sql = "SELECT * from tipo_atendimento where tipo_atendimento_codigo = ?";

        try {
            ps = getConnection().prepareStatement(sql);
            ps.setInt(1, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                  p = new Tipo_Atendimento();
                  p.setTipo_atendimento_codigo(rs.getInt("tipo_atendimento_codigo"));
                  p.setTipo_atendimento_nome(rs.getString("tipo_atendimento_nome"));
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
    public void create(Atendimento vo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Atendimento vo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy(Atendimento obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Atendimento> findEntities() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Atendimento> findEntities(int maxResults, int firstResult) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Atendimento find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 
}
