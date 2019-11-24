package DAO;

import classes.Cliente;
import classes.Funcionario;
import classes.Security;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

public class FuncionarioDAO extends BaseDAOImp implements BaseDAO<Funcionario>{

    private static final Logger log = Logger.getLogger(FuncionarioDAO.class.getName());
    
    public FuncionarioDAO(){
      super();
    }    
    
    public FuncionarioDAO(java.sql.Connection con) {
        setConnection(con);
    }
    
    @Override
    public void create(Funcionario pessoa) {
      java.sql.PreparedStatement ps = null;
      java.sql.ResultSet rs = null;
      String sql = "INSERT INTO funcionario (funcionario_nome,funcionario_cpf,funcionario_email,funcionario_rua,funcionario_numero,funcionario_complemento,funcionario_bairro,funcionario_cep,funcionario_cidade,funcionario_estado,funcionario_telefone,funcionario_senha,funcionario_salt) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {           
            String salt = Security.generateSalt(250).get();
            String senha = pessoa.getFuncionario_senha();
            String key = Security.hashPassword(senha, salt).get();
            ps = getConnection().prepareStatement(sql);

            Date dt = new Date();
            ps.setString(1, pessoa.getFuncionario_nome());
            ps.setString(2, pessoa.getFuncionario_cpf());
            ps.setString(3, pessoa.getFuncionario_email());
            ps.setString(4, pessoa.getFuncionario_rua());
            ps.setInt(5, pessoa.getFuncionario_numero());
            ps.setString(6, pessoa.getFuncionario_complemento());
            ps.setString(7, pessoa.getFuncionario_bairro());
            ps.setString(8, pessoa.getFuncionario_cep());
            ps.setString(9, pessoa.getFuncionario_cidade());
            ps.setString(10, pessoa.getFuncionario_estado());
            ps.setString(11, pessoa.getFuncionario_telefone());  
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

    
    public void edit(Funcionario funcionario, String cpf) {
        java.sql.PreparedStatement ps = null;
      String sql = "UPDATE funcionario SET funcionario_nome = ?, funcionario_rua = ?, funcionario_numero = ?,funcionario_complemento = ?,funcionario_bairro = ?, funcionario_cep = ?, funcionario_cidade = ?, funcionario_estado = ?, funcionario_telefone = ?,  funcionario_senha = ?  "
              + " where funcionario_cpf = ?";

        try {
            ps = getConnection().prepareStatement(sql);
            
            ps.setString(1,  funcionario.getFuncionario_nome());
            ps.setString(2,  funcionario.getFuncionario_rua());
            ps.setInt(3,     funcionario.getFuncionario_numero());
            ps.setString(4,  funcionario.getFuncionario_complemento());
            ps.setString(5,  funcionario.getFuncionario_bairro());
            ps.setString(6,  funcionario.getFuncionario_cep());
            ps.setString(7,  funcionario.getFuncionario_cidade());
            ps.setString(8, funcionario.getFuncionario_estado());
            ps.setString(9, funcionario.getFuncionario_telefone());
            ps.setString(10, funcionario.getFuncionario_senha());
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
    public void destroy(String cpf) {
        java.sql.PreparedStatement ps = null;
      String sql = "delete from funcionario where funcionario_cpf = ?";

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
    public void destroy(Funcionario value) {
        destroy( value.getFuncionario_cpf());
    }
    
    @Override
    public List<Funcionario> findEntities() {
        return findEntities(true, -1, -1);
    }
    
    @Override
    public List<Funcionario> findEntities(int maxResults, int firstResult) {
        return findEntities(false, maxResults, firstResult);
    }
    
    @Override
    public List<Funcionario> findEntities(boolean all, int maxResults, int firstResult) {
       
      List<Funcionario> result = null;
      java.sql.PreparedStatement ps = null;
      java.sql.ResultSet rs = null;

        try {
          verificaConexao();
          ps = conn.prepareStatement("select * from funcionario ");
            rs = ps.executeQuery();

            if (rs.next()) {
                result = new java.util.ArrayList<Funcionario>();
                if (!all) {
                    int contagem = 1;  // primeiro next
                    while (contagem < firstResult) {
                        rs.next();
                        contagem++;
                    }
                }
                do {
                  Funcionario p = new Funcionario();
                  p.setFuncionario_nome(rs.getString("funcionario_nome"));
                  p.setFuncionario_cpf(rs.getString("funcionario_cpf"));
                  p.setFuncionario_email(rs.getString("funcionario_email"));
                  p.setFuncionario_cep(rs.getString("funcionario_cep"));
                  p.setFuncionario_cidade(rs.getString("funcionario_cidade"));
                  p.setFuncionario_estado(rs.getString("funcionario_estado"));
                  p.setFuncionario_numero(rs.getInt("funcionario_numero"));
                  p.setFuncionario_rua(rs.getString("funcionario_rua"));
                  p.setFuncionario_bairro(rs.getString("funcionario_bairro"));
                  p.setFuncionario_telefone(rs.getString("funcionario_telefone"));
                  p.setFuncionario_senha(rs.getString("funcionario_senha"));
                  p.setFuncionario_complemento(rs.getString("funcionario_complemento"));

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
    public void edit(Funcionario vo) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    
    public Funcionario find(String cpf) {
        Funcionario p = null;

        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        String sql = "SELECT * from funcionario where funcionario_cpf = ?";

        try {
            ps = getConnection().prepareStatement(sql);
            ps.setString(1, cpf);
            rs = ps.executeQuery();
            if (rs.next()) {
                  p = new Funcionario();
                  p.setFuncionario_nome(rs.getString("funcionario_nome"));
                  p.setFuncionario_cpf(rs.getString("funcionario_cpf"));
                  p.setFuncionario_email(rs.getString("funcionario_email"));
                  p.setFuncionario_cep(rs.getString("funcionario_cep"));
                  p.setFuncionario_cidade(rs.getString("funcionario_cidade"));
                  p.setFuncionario_estado(rs.getString("funcionario_estado"));
                  p.setFuncionario_numero(rs.getInt("funcionario_numero"));
                  p.setFuncionario_rua(rs.getString("funcionario_rua"));
                  p.setFuncionario_bairro(rs.getString("funcionario_bairro"));
                  p.setFuncionario_telefone(rs.getString("funcionario_telefone"));
                  p.setFuncionario_senha(rs.getString("funcionario_senha"));
                  p.setFuncionario_complemento(rs.getString("funcionario_complemento"));

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
        String sql = "select count(1) from funcionario";
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
    public Funcionario find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

   

}
