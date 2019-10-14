/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import CrossCutting.Log;
import CrossCutting.Mensagem;
import DAO.FilmeDAO;
import Models.Filme;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 * Controlador de Filmes
 * Propicia a comunicação entre a GUI e DAO
 * Implementa a lógica de negócios
 * @author Evandro Alessi
 * @author Eric Ueta
 * @see Filme
 * @see FilmeDAO
 */
public class FilmeController {

    /**
     *
     * @param filme
     * @return
     */
    public Filme create(Filme filme) {
        try {
            FilmeDAO dao = new FilmeDAO();
            if (filme.getSubCategoria() != null) {
                if (filme.getSubCategoria().getSubCategoriaID() != 0 && filme.getDescricao().trim().length() > 0 && filme.getDescricao() != null) {
                    if (filme.getValor() != 0) {
                        if (filme.getFormaPagamento() != 0) {
                            if (filme.getDataOcorrencia() == null) {
                                filme.setDataOcorrencia(LocalDate.now());
                            }
                            if (dao.create(filme)) {
                                return filme;
                            } else {
                                Mensagem.aviso("Não foi possivel cadastrar a receita.");
                            }
                        } else {
                            Mensagem.aviso("Deve ser selecionada uma forma de pagamento.");
                        }
                    } else {
                        Mensagem.aviso("A filme deve ter um valor para a receita.");
                    }
                } else {
                    Mensagem.aviso("A filme deve ter uma Descricao.");
                }
            } else {
                Mensagem.aviso("A filme deve ter uma Categoria.");
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
    public Filme get(int id) {
        try {
            Filme filme = new FilmeDAO().get(id);

            return filme;
        } catch (ClassNotFoundException | SQLException e) {
            Log.saveLog(e);
            Mensagem.excecao(e);
        }

        return null;
    }

    public double getSaldo() {
        try {
            return new FilmeDAO().getSaldo();
        } catch (ClassNotFoundException | SQLException e) {
            Log.saveLog(e);
            Mensagem.excecao(e);
        }

        return 0;
    }

    /**
     *
     * @param untilNow
     * @return
     */
    public ArrayList<Filme> getAll(boolean untilNow) {
        try {
            ArrayList<Filme> movimentacoes = new FilmeDAO().getAll(untilNow, null, null);

            return movimentacoes;
        } catch (ClassNotFoundException | SQLException e) {
            Log.saveLog(e);
            Mensagem.excecao(e);
        }

        return null;
    }
    
    /**
     *
     * @param untilNow
     * @param beginDate
     * @param endDate
     * @return
     */
    public ArrayList<Filme> getAll(boolean untilNow, LocalDate beginDate, LocalDate endDate) {
        try {
            ArrayList<Filme> movimentacoes = new FilmeDAO().getAll(untilNow, beginDate, endDate);

            return movimentacoes;
        } catch (ClassNotFoundException | SQLException e) {
            Log.saveLog(e);
            Mensagem.excecao(e);
        }

        return null;
    }
    
    /**
     *
     * @param filme
     * @return
     */
    public Filme update(Filme filme) {
        try {
            FilmeDAO dao = new FilmeDAO();
            if (filme.getSubCategoria() != null) {
                if (filme.getSubCategoria().getSubCategoriaID() != 0 && filme.getDescricao().trim().length() > 0 && filme.getDescricao() != null) {
                    if (filme.getValor() != 0) {
                        if (filme.getFormaPagamento() != 0) {
                            if (filme.getDataOcorrencia() == null) {
                                Date date = new Date();
                                date.getTime();
                                filme.setDataOcorrencia(LocalDate.now());
                            }
                            if (dao.update(filme)) {
                                return filme;
                            } else {
                                Mensagem.aviso("Não foi possivel cadastrar a receita.");
                            }
                        } else {
                            Mensagem.aviso("Deve ser selecionada uma forma de pagamento.");
                        }
                    } else {
                        Mensagem.aviso("A filme deve ter um valor para a receita.");
                    }
                } else {
                    Mensagem.aviso("A filme deve ter uma Descricao.");
                }
            } else {
                Mensagem.aviso("A despesa deve ter uma Categoria.");
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
                return new FilmeDAO().delete(id);
            }
        } catch (ClassNotFoundException | SQLException e) {
            Log.saveLog(e);
            Mensagem.excecao(e);
        }

        return false;
    }
}
