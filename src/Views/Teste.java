/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DAO.*;
import Models.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SpaceBR
 */
public class Teste {
    public static void main(String[] args) {
        
        FilmeDAO filmeDAO = new FilmeDAO();
        SalaDAO salaDAO = new SalaDAO();
        SessaoDAO sessaoDAO = new SessaoDAO();
        Contexto contexto = new Contexto();
        try {
            contexto.getConexao();
            System.out.println("conectado");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Teste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
