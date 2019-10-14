/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.time.LocalDate;

/**
 * Modelo estrutural de Sessao.
 * Gera objetos modelos para comunicação com BD ou utilização na GUI.
 * @author Evandro Alessi
 * @author Eric Ueta
 * @see Sessao
 */
public class Sessao {
    private int sessaoID;
    private int filmeID;
    private int salaID;
    private int ingressos;
    private LocalDate data;
    private double valorIngresso;
    private Filme filme;
    private Sala sala;
}
