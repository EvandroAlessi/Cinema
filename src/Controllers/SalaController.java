/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import CrossCutting.Log;
import CrossCutting.Mensagem;
import DAO.SalaDAO;
import Models.Sala;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Controlador de Sala
 * Propicia a comunicação entre a GUI e DAO
 * Implementa a lógica de negócios
 * @author Evandro Alessi
 * @author Eric Ueta
 * @see Sala
 * @see SalaDAO
 */
public class SalaController {

    /**
     *
     * @param sala
     * @return
     */
    public Sala create(Sala sala) {
        try {
            SalaDAO dao = new SalaDAO();
            if (sala.getSubCategoria() != null) {
                if (sala.getSubCategoria().getSubCategoriaID() != 0 && sala.getDescricao().trim().length() > 0 && sala.getDescricao() != null) {
                    if (sala.getValor() > 0) {
                        if (sala.getFormaPagamento() != 0) {
                            if (sala.getDataOcorrencia() == null) {
                                sala.setDataOcorrencia(LocalDate.now());
                            }
                            if (dao.create(sala)) {
                                return sala;
                            } else {
                                Mensagem.aviso("Não foi possivel cadastrar a Sala.");
                            }
                        } else {
                            Mensagem.aviso("Deve ser selecionada uma forma de pagamento.");
                        }
                    } else {
                        Mensagem.aviso("A Sala deve ter um valor e ele não pode ser negativo.");
                    }
                } else {
                    Mensagem.aviso("A Sala deve ter uma Descricao.");
                }
            } else {
                Mensagem.aviso("A sala deve ter um Categoria.");
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
    public Sala get(int id) {
        try {
            Sala sala = new SalaDAO().get(id);

            return sala;
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
    public ArrayList<Sala> getAll() {
        try {
            ArrayList<Sala> salas = new SalaDAO().getAll();

            return salas;
        } catch (ClassNotFoundException | SQLException e) {
            Log.saveLog(e);
            Mensagem.excecao(e);
        }

        return null;
    }

    /**
     *
     * @param sala
     * @return
     */
    public Sala update(Sala sala) {
        try {
            SalaDAO dao = new SalaDAO();
            if (sala.getSubCategoria() != null) {
                if (sala.getMovimentacaoID() != 0 && sala.getSubCategoria().getSubCategoriaID() != 0 && sala.getDescricao().trim().length() > 0 && sala.getDescricao() != null) {
                    if (sala.getValor() != 0) {
                        if (sala.getFormaPagamento() != 0) {
                            if (sala.getDataOcorrencia() == null) {
                                sala.setDataOcorrencia(LocalDate.now());
                            }
                            if (dao.update(sala)) {
                                return sala;
                            } else {
                                Mensagem.aviso("Não foi possivel cadastrar a receita.");
                            }
                        } else {
                            Mensagem.aviso("Deve ser selecionada uma forma de pagamento.");
                        }
                    } else {
                        Mensagem.aviso("A receita deve ter um valor para a receita.");
                    }
                } else {
                    Mensagem.aviso("A sala deve ter uma Descricao.");
                }
            } else {
                Mensagem.aviso("A sala deve ter uma Categoria.");
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
                return new SalaDAO().delete(id);
            }
        } catch (ClassNotFoundException | SQLException e) {
            Log.saveLog(e);
            Mensagem.excecao(e);
        }

        return false;
    }

    /**
     *
     * @return
     */
    public String[] getAllMetaData() {
        try {
            return new SalaDAO().getAllMetaData();
        } catch (ClassNotFoundException | SQLException e) {
            Log.saveLog(e);
            Mensagem.excecao(e);
        }
        return null;
    }
}
