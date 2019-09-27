package DAO;

import DAL.Contexto;
import Models.Sessao;

/**
 * Sessao
 */
public class SessaoDAO {
    private static Contexto _contexto;

    public SessaoDAO() {
        _contexto = new Contexto();
    }

    public Sessao adicionarSessao(Sessao filme)
    {
        return null;
    }
    
    public boolean editarSessao(Sessao filme)
    {
        return false;
    }

    public Sessao buscarSessao(int filmeID)
    {
        return null;
    }

    public boolean excluirSessao(int filmeID)
    {
        return false;
    }
}
