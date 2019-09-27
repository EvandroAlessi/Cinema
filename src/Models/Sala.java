package Models;

/**
 * Sala
 */
public class Sala {
    private int numero;
    private int capacidade;

    public Sala() {
    }
    
    public Sala(int numero, int capacidade) {
        this.numero = numero;
        this.capacidade = capacidade;
    }
    
    public int getNumero() {
        return numero;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
