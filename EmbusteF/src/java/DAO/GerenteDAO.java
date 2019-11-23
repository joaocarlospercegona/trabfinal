package DAO;

import classes.Gerente;
import classes.Security;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class GerenteDAO extends BaseDAOImp implements BaseDAO<Gerente> {

    private static final Logger log = Logger.getLogger(FuncionarioDAO.class.getName());
    
    public GerenteDAO(){
      super();
    }    
    
    public GerenteDAO(java.sql.Connection con) {
        setConnection(con);
    }
    @Override
    public void create(Gerente pessoa) {
        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        String sql = "INSERT INTO gerente (gerente_nome,gerente_cpf,gerente_email,gerente_rua,gerente_numero,gerente_complemento,gerente_bairro,gerente_cep,gerente_cidade,gerente_estado,gerente_telefone,gerente_senha,gerente_salt) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            String salt = Security.generateSalt(250).get();
            String senha = pessoa.getGerente_senha();
            String key = Security.hashPassword(senha, salt).get();
            ps = getConnection().prepareStatement(sql);

            Date dt = new Date();

            ps.setString(1, pessoa.getGerente_nome());
            ps.setString(2, pessoa.getGerente_cpf());
            ps.setString(3, pessoa.getGerente_email());
            ps.setString(4, pessoa.getGerente_rua());
            ps.setInt(5, pessoa.getGerente_numero());
            ps.setString(6, pessoa.getGerente_complemento());
            ps.setString(7, pessoa.getGerente_bairro());
            ps.setString(8, pessoa.getGerente_cep());
            ps.setString(9, pessoa.getGerente_cidade());
            ps.setString(10, pessoa.getGerente_estado());
            ps.setString(11, pessoa.getGerente_telefone());
            ps.setString(12, key);
            ps.setString(13, salt);

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

     public void edit(Gerente gerente, String cpf) {
        java.sql.PreparedStatement ps = null;
      String sql = "UPDATE gerente SET gerente_nome = ?, gerente_rua = ?, gerente_numero = ?,gerente_complemento = ?,gerente_bairro = ?, gerente_cep = ?, gerente_cidade = ?,gerente_telefone = ?, gerente_senha = ?, gerente_estado = ?  "
              + " where gerente_cpf = ?";

        try {
            ps = getConnection().prepareStatement(sql);
            
            ps.setString(1,  gerente.getGerente_nome());
            ps.setString(2,  gerente.getGerente_rua());
            ps.setInt(3,     gerente.getGerente_numero());
            ps.setString(4,  gerente.getGerente_complemento());
            ps.setString(5,  gerente.getGerente_bairro());
            ps.setString(6,  gerente.getGerente_cep());
            ps.setString(7,  gerente.getGerente_cidade());
            ps.setString(8,  gerente.getGerente_telefone());
            ps.setString(9, gerente.getGerente_senha());
            ps.setString(10,  gerente.getGerente_estado());
            ps.setString(11, cpf);
            
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
    
    @Override
    public void edit(Gerente vo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy(Gerente value) {
           destroy( value.getGerente_cpf());
    }

    @Override
    public void destroy(String cpf) {
    java.sql.PreparedStatement ps = null;
      String sql = "delete from gerente where gerente_cpf = ?";

      try {
          ps = getConnection().prepareStatement(sql);
          ps.setString(1, cpf);
          if (ps.executeUpdate() == 0) {
              log.warning(ps.toString() + " not deleted.");
          }
      } catch (SQLException ex) {
          ex.printStackTrace();
      } finally {
          JDBCUtils.close(ps);
      }
   }

    @Override
    public List<Gerente> findEntities() {
     return findEntities(true, -1, -1);    
    }

    @Override
    public List<Gerente> findEntities(int maxResults, int firstResult) {
     return findEntities(false, maxResults, firstResult);
    }

    @Override
    public List<Gerente> findEntities(boolean all, int maxResults, int firstResult) {
     
      List<Gerente> result = null;
      java.sql.PreparedStatement ps = null;
      java.sql.ResultSet rs = null;

        try {
          verificaConexao();
          ps = conn.prepareStatement("select * from gerente ");
            rs = ps.executeQuery();

            if (rs.next()) {
                result = new java.util.ArrayList<Gerente>();
                if (!all) {
                    int contagem = 1;  // primeiro next
                    while (contagem < firstResult) {
                        rs.next();
                        contagem++;
                    }
                }
                do {
                  Gerente p = new Gerente();
                  p.setGerente_nome(rs.getString("gerente_nome"));
                  p.setGerente_cpf(rs.getString("gerente_cpf"));
                  p.setGerente_email(rs.getString("gerente_email"));
                  p.setGerente_cep(rs.getString("gerente_cep"));
                  p.setGerente_cidade(rs.getString("gerente_cidade"));
                  p.setGerente_estado(rs.getString("gerente_estado"));
                  p.setGerente_numero(rs.getInt("gerente_numero"));
                  p.setGerente_rua(rs.getString("gerente_rua"));
                  p.setGerente_bairro(rs.getString("gerente_bairro"));
                  p.setGerente_telefone(rs.getString("gerente_telefone"));
                  p.setGerente_senha(rs.getString("gerente_senha"));
                  p.setGerente_complemento(rs.getString("gerente_complemento"));

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

    public Gerente find(String cpf) {
        Gerente p = null;

        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        String sql = "SELECT * from gerente where gerente_cpf = ?";

        try {
            ps = getConnection().prepareStatement(sql);
            ps.setString(1, cpf);
            rs = ps.executeQuery();
            if (rs.next()) {
                  p = new Gerente();
                  p.setGerente_nome(rs.getString("gerente_nome"));
                  p.setGerente_cpf(rs.getString("gerente_cpf"));
                  p.setGerente_email(rs.getString("gerente_email"));
                  p.setGerente_cep(rs.getString("gerente_cep"));
                  p.setGerente_cidade(rs.getString("gerente_cidade"));
                  p.setGerente_estado(rs.getString("gerente_estado"));
                  p.setGerente_numero(rs.getInt("gerente_numero"));
                  p.setGerente_rua(rs.getString("gerente_rua"));
                  p.setGerente_bairro(rs.getString("gerente_bairro"));
                  p.setGerente_telefone(rs.getString("gerente_telefone"));
                  p.setGerente_senha(rs.getString("gerente_senha"));
                  p.setGerente_complemento(rs.getString("gerente_complemento"));

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
    public int getCount() {
         int result = 0;
        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        String sql = "select count(1) from gerente";
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
    public Gerente find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
