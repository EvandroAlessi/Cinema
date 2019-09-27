package Models;

/**
 * Filme
 */
public class Filme {
    private String titulo;
    private String diretor;
    private String genero;
    private String idioma;
    private int duracao;

    public Filme() {
    }

    public Filme(String titulo, String diretor, String genero, String idioma, int duracao) {
        this.titulo = titulo;
        this.diretor = diretor;
        this.genero = genero;
        this.idioma = idioma;
        this.duracao = duracao;
    }
    
    public String getDiretor() {
        return diretor;
    }

    public int getDuração() {
        return duracao;
    }

    public void setDuração(int duração) {
        this.duracao = duração;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
    
}