package Servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;


@WebServlet(name="GeradorRelatorios",urlPatterns={"/GeradorRelatorios"})
public class GeradorRelatorios extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        Connection con = null;
        try {
            // Conexão com o banco
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/Embuste",
            "usuario", "form4141");
            
            String tipoRelatorio = request.getParameter("relatorio-box");
            String jasper="./teste.jasper";
            
            // Host onde o servlet esta executando
            String host = "http://" + request.getServerName() +
            ":" + request.getServerPort();
            
            // Parâmetros do relatório
            HashMap params = new HashMap();
            
            switch (tipoRelatorio){
                case "ate":
                    jasper = request.getContextPath() + "/ate.jasper";
                    String dataInicio= request.getParameter("data-ini-box");
                    String dataFim= request.getParameter("data-fim-box");
                    
                    //Primeiro converte de String para Date
                    DateFormat formatUS = new SimpleDateFormat("yyyy-mm-dd");
                    Date date1 = formatUS.parse(dataInicio);
                    Date date2 = formatUS.parse(dataFim);

                    //Depois formata data
                    DateFormat formatBR = new SimpleDateFormat("dd-mm-yyyy");
                    String d1 = formatBR.format(date1);
                    String d2 = formatBR.format(date2);
                    
                    //Transfroma de String para Date de novo
                    Date da1 = formatUS.parse(d1);
                    Date da2 = formatUS.parse(d2);
                    //Passando parâmetros e convertendo o dados pra ser compativel
                    params.put("data-ini", da1);
                    params.put("data-fim", da2);
                    break;
                case "rec":
                    System.out.println("Reclamações");
                    jasper = request.getContextPath() + "/rec.jasper";
                    String situacaoReclamacao = request.getParameter("reclama-box");
                    //Passando parâmetros e convertendo o dados pra ser compativel
                    params.put("meu_id", 1);
                    break;
                case "prod":
                    jasper = request.getContextPath() + "/prod.jasper";
                    break;
                case "func":
                    jasper = request.getContextPath() + "/func.jasper";
                    break;
            }                        
            // URL para acesso ao relatório
            URL jasperURL = new URL(host + jasper);     
            
            // Geração do relatório
            byte[] bytes = JasperRunManager.runReportToPdf(
            jasperURL.openStream(), params, con);

            if (bytes != null) {
            // A página será mostrada em PDF
            response.setContentType("application/pdf");
            // Envia o PDF para o Cliente
            OutputStream ops = response.getOutputStream();
            ops.write(bytes);
            }
        } // Fechamento do try
        catch(ClassNotFoundException e) {
            request.setAttribute("mensagem", "Driver BD não encontrado : " +
            e.getMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
        catch(SQLException e) {
            request.setAttribute("mensagem", "Erro de conexão ou query: " +
            e.getMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        }
        catch(JRException e) {
            request.setAttribute("mensagem", "Erro no Jasper : " +
            e.getMessage());
            request.getRequestDispatcher("erro.jsp").forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(GeradorRelatorios.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            if (con!=null)

            try { con.close(); } catch(Exception e) {e.getStackTrace();}
        }
    } 
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }
} 