package DAO;

import DAL.Contexto;
import Models.Sala;

/**
 * Sala
 */
public class SalaDAO {
    private static Contexto _contexto;

    public SalaDAO() {
        _contexto = new Contexto();
    }

    public Sala adicionarSala(Sala sala)
    {
        return null;
    }
    
    public boolean editarSala(Sala sala)
    {
        return false;
    }

    public Sala buscarSala(int salaID)
    {
        return null;
    }

    public boolean excluirSala(int salaID)
    {
        return false;
    }
}
