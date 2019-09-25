package DAO;

/**
 * Sessao
 */
public class SessaoDAO {
    private static Context _contexto;

    public SessaoDAO() {
        _contexto = new Context();
    }

    public Sessao adicionarSessao(Sessao filme)
    {
        return 0;
    }
    
    public boolean editarSessao(Sessao filme)
    {
        return null;
    }

    public Sessao buscarSessao(int filmeID)
    {
        return null;
    }

    public boolean excluirSessao(int filmeID)
    {
        return null;
    }
}
