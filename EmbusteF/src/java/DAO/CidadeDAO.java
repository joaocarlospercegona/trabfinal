package DAO;

import static Facade.Facade.busca;
import classes.Cidade;
//import static Beans.Cidade_.fKidestado;
import classes.Estado;
//import static facade.EstadoFacade.busca;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author lps
 */
public class CidadeDAO extends BaseDAOImp implements BaseDAO<Cidade> {

    private static final Logger log = Logger.getLogger(ClienteDAO.class.getName());

    public CidadeDAO() {
        super();
    }

    public CidadeDAO(java.sql.Connection con) {
        setConnection(con);
    }

    @Override
    public List<Cidade> findEntities() {
        return findEntities(true, -1, -1);
    }

    @Override
    public List<Cidade> findEntities(int maxResults, int firstResult) {
        return findEntities(false, maxResults, firstResult);
    }

    @Override
    public List<Cidade> findEntities(boolean all, int maxResults, int firstResult) {

        List<Cidade> result = null;
        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;

        try {
            verificaConexao();
            ps = conn.prepareStatement("select * from tb_Cidade ");
            rs = ps.executeQuery();

            if (rs.next()) {
                result = new java.util.ArrayList<Cidade>();
                if (!all) {
                    int contagem = 1;  // primeiro next
                    while (contagem < firstResult) {
                        rs.next();
                        contagem++;
                    }
                }
                do {
                    Cidade p = new Cidade();
                    p.setIdCidade(rs.getInt("id_cidade"));
                    p.setNomeCidade(rs.getString("nome_cidade"));
                    String i = rs.getString("FK_id_estado");

                    Estado estado = busca(i);
                    p.setFKidestado(estado);

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

    public Cidade findEntitiesCidade(boolean all, int maxResults, int firstResult, String id) {
        List<Cidade> result = null;
        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;

        try {
            verificaConexao();
            ps = conn.prepareStatement("select * from tb_Cidade where id_estado = ?");
            ps.setString(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                result = new java.util.ArrayList<Cidade>();
                if (!all) {
                    int contagem = 1;  // primeiro next
                    while (contagem < firstResult) {
                        rs.next();
                        contagem++;
                    }
                }
                do {
                    Cidade p = new Cidade();
                    p.setIdCidade(rs.getInt("id_cidade"));
                    p.setNomeCidade(rs.getString("nome_cidade"));
                    String i = rs.getString("FK_id_estado");

                    Estado estado = busca(i);
                    p.setFKidestado(estado);

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
        return (Cidade) result;
    }

    @Override
    public Cidade find(Integer id) {
        Cidade p = null;

        java.sql.PreparedStatement ps = null;
        java.sql.ResultSet rs = null;
        String sql = "SELECT * from tb_cidade where id_cidade = ?";

        try {
            ps = getConnection().prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                p = new Cidade();
                p.setIdCidade(rs.getInt("id_cidade"));
                p.setNomeCidade(rs.getString("nome_cidade"));
                String x = rs.getString("FK_id_estado");
                Estado estado = busca(x);
                p.setFKidestado(estado);
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
    public void create(Cidade vo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Cidade vo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy(Cidade obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void destroy(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void destroy(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
