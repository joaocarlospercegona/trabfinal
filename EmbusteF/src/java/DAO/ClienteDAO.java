/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import classes.Atendimento;
import classes.Cliente;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author joao
 */
public class ClienteDAO extends BaseDAOImp implements BaseDAO<Cliente>{
    
  private static final Logger log = Logger.getLogger(ClienteDAO.class.getName());
  
    public ClienteDAO(){
      super();
    }

    public ClienteDAO(java.sql.Connection con) {
        setConnection(con);
    }

    @Override
    public void create(Cliente pessoa) {
      java.sql.PreparedStatement ps = null;
      java.sql.ResultSet rs = null;
      String sql = "INSERT INTO cliente (cliente_nome,cliente_cpf,cliente_email,cliente_rua,cliente_numero,cliente_complemento,cliente_bairro,cliente_cep,cliente_cidade,cliente_estado,cliente_telefone,cliente_senha) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            ps = getConnection().prepareStatement(sql);
            
            ps.setString(1, pessoa.getCliente_nome());
            ps.setString(2, pessoa.getCliente_cpf());
            ps.setString(3, pessoa.getCliente_email());
            ps.setString(4, pessoa.getCliente_rua());
            ps.setInt(5, pessoa.getCliente_numero());
            ps.setString(6, pessoa.getCliente_complemento());
            ps.setString(7, pessoa.getCliente_bairro());
            ps.setString(8, pessoa.getCliente_cep());
            ps.setString(9, pessoa.getCliente_cidade());
            ps.setString(10, pessoa.getCliente_estado());
            ps.setString(11, pessoa.getCliente_telefone());
            ps.setString(12, pessoa.getCliente_senha());

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

    public void edit(Cliente cliente, String cpf) {
      java.sql.PreparedStatement ps = null;
      String sql = "UPDATE cliente SET cliente_nome = ?,cliente_email = ?, cliente_cpf = ?, cliente_rua = ?, cliente_numero = ?,cliente_complemento = ?,cliente_bairro = ?, cliente_cep = ?, cliente_cidade = ?,cliente_estado = ? , cliente_telefone = ?, cliente_senha = ? "
              + " where cliente_cpf = ?";

        try {
            ps = getConnection().prepareStatement(sql);
            
            ps.setString(1,  cliente.getCliente_nome());
            ps.setString(2,  cliente.getCliente_email());
            ps.setString(3,  cliente.getCliente_cpf());
            ps.setString(4,  cliente.getCliente_rua());
            ps.setInt(5,     cliente.getCliente_numero());
            ps.setString(6,  cliente.getCliente_complemento());
            ps.setString(7,  cliente.getCliente_bairro());
            ps.setString(8,  cliente.getCliente_cep());
            ps.setString(9,  cliente.getCliente_cidade());
            ps.setString(10, cliente.getCliente_estado());
            ps.setString(11, cliente.getCliente_telefone());
            ps.setString(12, cliente.getCliente_senha());
            ps.setString(13, cpf);
            
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
      String sql = "delete from cliente where cliente_cpf = ?";

      try {
          ps = getConnection().prepareStatement(sql);
          ps.setString(1, cpf);
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
    public void destroy(Cliente value) {
        destroy( value.getCliente_cpf());
    }

    @Override
    public List<Cliente> findEntities() {
        return findEntities(true, -1, -1);
    }

    @Override
    public List<Cliente> findEntities(int maxResults, int firstResult) {
        return findEntities(false, maxResults, firstResult);
    }

    @Override
    public List<Cliente> findEntities(boolean all, int maxResults, int firstResult) {

      List<Cliente> result = null;
      java.sql.PreparedStatement ps = null;
      java.sql.ResultSet rs = null;

        try {
          verificaConexao();
          ps = conn.prepareStatement("select * from cliente ");
            rs = ps.executeQuery();

            if (rs.next()) {
                result = new java.util.ArrayList<Cliente>();
                if (!all) {
                    int contagem = 1;  // primeiro next
                    while (contagem < firstResult) {
                        rs.next();
                        contagem++;
                    }
                }
                do {
                  Cliente p = new Cliente();
                  p.setCliente_nome(rs.getString("cliente_nome"));
                  p.setCliente_cpf(rs.getString("cliente_cpf"));
                  p.setCliente_email(rs.getString("cliente_email"));
                  p.setCliente_cep(rs.getString("cliente_cep"));
                  p.setCliente_cidade(rs.getString("cliente_cidade"));
                  p.setCliente_estado(rs.getString("cliente_estado"));
                  p.setCliente_numero(rs.getInt("cliente_numero"));
                  p.setCliente_rua(rs.getString("cliente_rua"));
                  p.setCliente_bairro(rs.getString("cliente_bairro"));
                  p.setCliente_telefone(rs.getString("cliente_telefone"));
                  p.setCliente_senha(rs.getString("cliente_senha"));
                  p.setCliente_complemento(rs.getString("cliente_complemento"));

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
    public Cliente find(String cpf) {
        Cliente p = null;

        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        String sql = "SELECT * from cliente where cliente_cpf = ?";

        try {
            ps = getConnection().prepareStatement(sql);
            ps.setString(1, cpf);
            rs = ps.executeQuery();
            if (rs.next()) {
                  p = new Cliente();
                  p.setCliente_nome(rs.getString("cliente_nome"));
                  p.setCliente_cpf(rs.getString("cliente_cpf"));
                  p.setCliente_email(rs.getString("cliente_email"));
                  p.setCliente_cep(rs.getString("cliente_cep"));
                  p.setCliente_cidade(rs.getString("cliente_cidade"));
                  p.setCliente_estado(rs.getString("cliente_estado"));
                  p.setCliente_numero(rs.getInt("cliente_numero"));
                  p.setCliente_rua(rs.getString("cliente_rua"));
                  p.setCliente_bairro(rs.getString("cliente_bairro"));
                  p.setCliente_telefone(rs.getString("cliente_telefone"));
                  p.setCliente_senha(rs.getString("cliente_senha"));
                  p.setCliente_complemento(rs.getString("cliente_complemento"));

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


    public Cliente findByNome(String nome) {
        Cliente vo = null;
        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        String sql = "select cliente_cpf,cliente_nome "
                + " from cliente where cliente_nome = ?";
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setString(1, nome);
            rs = ps.executeQuery();
            if (rs.next()) {
                vo = new Cliente();
                vo.setCliente_cpf(rs.getString(1));
                vo.setCliente_nome(rs.getString(2));
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
        String sql = "select count(1) from cliente";
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
    public void edit(Cliente vo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Atendimento> findAtendimentos(boolean all, int maxResults, int firstResult,String cpf) {
      List<Atendimento> result = null;
      java.sql.PreparedStatement ps = null;
      java.sql.ResultSet rs = null;

        try {
          verificaConexao();
          ps = conn.prepareStatement("select * from atendimento where atendimento_cpf_cliente = ? order by atendimento_data_hora desc");
          ps.setString(1, cpf);  
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

    @Override
    public Cliente find(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
