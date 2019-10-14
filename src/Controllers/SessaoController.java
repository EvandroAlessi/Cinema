/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import CrossCutting.Log;
import CrossCutting.Mensagem;
import DAO.SessaoDAO;
import Models.Sessao;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Controlador de Categorias
 * Propicia a comunicação entre a GUI e DAO
 * Implementa a lógica de negócios
 * @author Evandro Alessi
 * @author Eric Ueta
 * @see Sessao
 * @see SessaoDAO
 */
public class SessaoController {

    /**
     *
     * @param sessao
     * @return
     */
    public Sessao create(Sessao sessao) {
        try {
            SessaoDAO dao = new SessaoDAO();
            if (sessao.getDescricao().trim().length() > 0 && sessao.getDescricao().trim().length() > 0 && sessao.getDescricao() != null) {
                if (!dao.exists(sessao.getDescricao(), sessao.isPositiva())) {
                    if (dao.create(sessao)) {
                        return sessao;
                    } else {
                        Mensagem.aviso("Não foi possivel criar a categoria.");
                    }
                } else {
                    if (sessao.isPositiva()) {
                        Mensagem.aviso("Já existe um tipo de receita com essa Descrição.");
                    } else {
                        Mensagem.aviso("Já existe um tipo de despesa com essa Descrição.");
                    }
                }
            } else {
                Mensagem.aviso("A categoria deve ter uma Descrição.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            Log.saveLog(e);
            Mensagem.excecao(e);
        }

        return null;
    }

    /**
     *
     * @param id
     * @return
     */
    public Sessao get(int id) {
        try {
            if (id != 0) {
                Sessao sessao = new SessaoDAO().get(id);
                return sessao;
            }
        } catch (ClassNotFoundException | SQLException e) {
            Log.saveLog(e);
            Mensagem.excecao(e);
        }

        return null;
    }

    /**
     *
     * @return
     */
    public ArrayList<Sessao> getAll() {
        try {
            ArrayList<Sessao> sessaos = new SessaoDAO().getAll();

            return sessaos;
        } catch (ClassNotFoundException | SQLException e) {
            Log.saveLog(e);
            Mensagem.excecao(e);
        }

        return null;
    }
    
    /**
     *
     * @param positiva
     * @return
     */
    public ArrayList<Sessao> getAll(boolean positiva) {
        try {
            ArrayList<Sessao> sessaos = new SessaoDAO().getAll(positiva);

            return sessaos;
        } catch (ClassNotFoundException | SQLException e) {
            Log.saveLog(e);
            Mensagem.excecao(e);
        }

        return null;
    }
    
    /**
     *
     * @param sessao
     * @return
     */
    public Sessao update(Sessao sessao) {
        try {
            SessaoDAO dao = new SessaoDAO();
            if (sessao.getSessaoID() != 0 && sessao.getDescricao().trim().length() > 0 && sessao.getDescricao() != null) {
                if (!dao.exists(sessao.getDescricao(), sessao.isPositiva())) {
                    if (dao.update(sessao)) {
                        return sessao;
                    } else {
                        Mensagem.aviso("Não foi possivel realizar a Atualização.");
                    }
                } else {
                    if (sessao.isPositiva()) {
                        Mensagem.aviso("Já existe uma categoria de receita com essa Descrição.");
                    } else {
                        Mensagem.aviso("Já existe uma categoria de despesa com essa Descrição.");
                    }
                }
            } else {
                Mensagem.aviso("Deve ser selecionada uma categoria e a categoria deve ter uma Descrição.");
            }
        } catch (ClassNotFoundException | SQLException e) {
            Log.saveLog(e);
            Mensagem.excecao(e);
        }

        return null;
    }

    /**
     *
     * @param id
     * @return
     */
    public boolean delete(int id) {
        try {
            if (id != 0) {
                return new SessaoDAO().delete(id);
            }
        } catch (ClassNotFoundException | SQLException e) {
            Log.saveLog(e);
            Mensagem.excecao(e);
        }

        return false;
    }
}
