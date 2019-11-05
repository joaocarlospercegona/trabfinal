/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author joao
 */
public class NewClass {
    public NewClass(){
               Date dataHoje = new java.util.Date();

Date dataAdmissao = null;

int diasTrabalhados;

diasTrabalhados = (int) ((dataHoje.getTime() - dataAdmissao.getTime()) / 86400000L);
        System.out.println(diasTrabalhados);
    }
}
