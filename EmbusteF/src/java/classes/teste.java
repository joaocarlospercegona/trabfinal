/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;


import static Facade.Facade.altera_Cliente;
import static Facade.Facade.buscaTodos_Cliente;
import static Facade.Facade.buscaTodos_Funcionario;
import static Facade.Facade.busca_Cliente;
import static Facade.Facade.insere_Cliente;
import static Facade.Facade.insere_Funcionario;
import static Facade.Facade.insere_Gerente;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


/**
 *
 * @author lps
 */
public class teste {
    public static void main(String[] args) throws ParseException {
        
Calendar a = Calendar.getInstance();
a.setTime(new Date());//data maior

Calendar b = Calendar.getInstance();
b.set(2019, 10, 4);// data menor

a.add(Calendar.DATE, - b.get(Calendar.DAY_OF_MONTH));
System.out.println(a.get(Calendar.DAY_OF_MONTH));
        
    }
}