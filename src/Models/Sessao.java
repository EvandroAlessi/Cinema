package Models;

import java.time.LocalDate;

/**
 * Sessao
 */
public class Sessao {
    private Filme filme;
    private Sala sala;
    private LocalDate data;
    private double valorIngresso;
    private int IngressoDisponivel;

    public Sessao() {
    }
    
    public Sessao(Filme filme, Sala sala, LocalDate data, double valorIngresso, int IngressoDisponivel) {
        this.filme = filme;
        this.sala = sala;
        this.data = data;
        this.valorIngresso = valorIngresso;
        this.IngressoDisponivel = IngressoDisponivel;
    }
    
    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(double valorIngresso) {
        this.valorIngresso = valorIngresso;
    }

    public int getIngressoDisponivel() {
        return IngressoDisponivel;
    }

    public void setIngressoDisponivel(int IngressoDisponivel) {
        this.IngressoDisponivel = IngressoDisponivel;
    }
}
