/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import static Facade.Facade.buscaTodos_Cliente;
import java.text.ParseException;
import java.util.List;

/**
 *
 * @author user
 */
public class test {
   public static void main(String[] args) {

    List<Cliente> lista = buscaTodos_Cliente();
    Cliente objusuario = new Cliente();
    
    for (Cliente w : lista) {
        if (w.getCliente_email().equals("zz@mail.com")) {
            objusuario = w;
            break;
        }
    }
    if (Security.verifyPassword("1", objusuario.getCliente_senha(), objusuario.getCliente_salt()))
           System.out.println("deu certo");
} 
}
