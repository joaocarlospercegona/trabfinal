package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class gerente_002drelatorio_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head lang='pt-br'>\n");
      out.write("        <meta charset='UTF-8'>\n");
      out.write("        <title>BEIBE - Beauty Embuste Indústria de Beleza e Estética</title>\n");
      out.write("        <meta name='viewport' content='width=device-width, initial-scale=1.0'>\n");
      out.write("        <link rel='shortcut icon' href='static/favicon.ico' type='image/x-icon'>\n");
      out.write("        <link rel='icon' href='static/favicon.ico' type='image/x-icon'>\n");
      out.write("        <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css'>\n");
      out.write("        <script src='https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js'></script>\n");
      out.write("        <script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js'></script>\n");
      out.write("        <script src='functions.js'></script>\n");
      out.write("        <link rel='stylesheet' href='css/styles.css'>\n");
      out.write("        <link rel='stylesheet' href='css/header.css'>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <img id='logo-img' src='static/logo_transparent.jpg' alt='logotipo'>\n");
      out.write("            <div id='menu'>\n");
      out.write("                <button id='pessoas-tab' class='tab' onclick=\"location.href = 'gerente-funcionarios.html';\">\n");
      out.write("                    Funcionários\n");
      out.write("                </button>\n");
      out.write("                <button id='atendimentos-tab' class='tab' onclick=\"location.href = 'gerente-atendimento.html';\">\n");
      out.write("                    Atendimentos\n");
      out.write("                </button>\n");
      out.write("                <button id='relatorios-tab' class='tab selected'>\n");
      out.write("                    Relatórios\n");
      out.write("                </button>\n");
      out.write("            </div>\n");
      out.write("            <div id='session'>\n");
      out.write("                <button id='user-name' class='drop-button'>\n");
      out.write("                    Sair\n");
      out.write("                </button>\n");
      out.write("            </div>\n");
      out.write("        </header> \n");
      out.write("        <div class='caixa relatorio'>\n");
      out.write("            <div class='conteudo'>\n");
      out.write("                <h1>Relatórios</h1>\n");
      out.write("                <form method='post' action=\"GeradorRelatorios\"> \n");
      out.write("                    <select required id ='relatorio-box' name='relatorio-box' class='form-control campo0' onclick='showBox()'>\n");
      out.write("                        <option disabled selected hidden>Escolha um Relatório...</option>\n");
      out.write("                        <option value='func'>Funcionários</option>\n");
      out.write("                        <option value='prod'>Produtos mais reclamados</option>\n");
      out.write("                        <option value='ate'>Atendimentos em aberto por data</option>\n");
      out.write("                        <option value='rec'>Reclamações</option>\n");
      out.write("                    </select>\n");
      out.write("                    <select disabled required id='reclama-box' name='reclama-box' class='form-control campo0'>\n");
      out.write("                        <option>Todos</option>\n");
      out.write("                        <option>Em aberto</option>\n");
      out.write("                        <option>Finalizados</option>\n");
      out.write("                    </select>\n");
      out.write("                    <div>\n");
      out.write("                        <label>Data de início:</label>\n");
      out.write("                        <input id='data-ini-box' disabled class='form-control campo0' name='data-ini-box' type='date'><br><br>\n");
      out.write("                    </div>\n");
      out.write("                    <div>\n");
      out.write("                        <label>Data final:</label>\n");
      out.write("                        <input id='data-fim-box' disabled class='form-control campo0' name='data-fim-box' type='date'><br><br>\n");
      out.write("                    </div>\n");
      out.write("                    <button type='submit' class='btn btn-primary margem'>\n");
      out.write("                        Gerar relatório\n");
      out.write("                    </button>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>  \n");
      out.write("    </body>\n");
      out.write("    <footer>\n");
      out.write("        &#9400 Beibe\n");
      out.write("    </footer>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
