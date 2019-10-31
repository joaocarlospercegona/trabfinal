package Servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
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
            String valor = request.getParameter("relatorio-box");
            System.out.println(valor);
            switch (valor){
                case "ate":
                    System.out.println("Atendimento");
                    break;
                case "rec":
                    System.out.println("Reclamações");
                    break;
                case "prod":
                    System.out.println("Produtos");
                    break;
                case "func":
                    System.out.println("Funcionarios");
                    break;
            }
            // Conexão com o banco
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/relatorios",
            "usuario", "form4141");
            // Caminho contextualizado do relatório compilado
            String jasper = request.getContextPath() +
            "/teste.jasper";
            // Host onde o servlet esta executando
            String host = "http://" + request.getServerName() +
            ":" + request.getServerPort();
            // URL para acesso ao relatório
            URL jasperURL = new URL(host + jasper);
            // Parâmetros do relatório
            HashMap params = new HashMap();
            //Passândo parâmetros e convertendo o dados pra ser compativel
            params.put("meu_id", 2);
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
        }
        finally {
            if (con!=null)

            try { con.close(); } catch(Exception e) {e.printStackTrace();}
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