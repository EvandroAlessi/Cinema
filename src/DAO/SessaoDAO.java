/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Models.Sala;
import Models.Sessao;
import Models.Filme;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * DAO Sessao
 * Responsável pela persistência das Sessoes
 * @author Evandro Alessi
 * @author Eric Ueta
 * @see Sessao
 * @see Sala
 * @see Filme
 */
public class SessaoDAO {

    private final Contexto contexto = new Contexto();

    /**
     *
     * @return @throws ClassNotFoundException
     * @throws SQLException
     */
    public String[] getAllMetaData() throws ClassNotFoundException, SQLException {
        String query = "select * from Sessoes;";
        ResultSetMetaData fields = contexto.executeQuery(query).getMetaData();
        String[] columns = new String[fields.getColumnCount()];

        for (int i = 1; i <= fields.getColumnCount(); i++) {
            columns[i - 1] = fields.getColumnName(i);
        }

        return columns;
    }

    /**
     *
     * @param Sessao
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean create(Sessao sessao) throws ClassNotFoundException, SQLException {
        String sql = "insert into Sessoes(FilmeID, SalaID, Ingressos, Data, ValorIngresso)values(?, ?, ?, ?, ?)";
        try (PreparedStatement preparestatement = contexto.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparestatement.setInt(1, sessao.getFilmeID()); //substitui o ? pelo dado do usuario
            preparestatement.setInt(3, sessao.getSalaID());
            preparestatement.setInt(4, sessao.getIngressos());
            preparestatement.setDate(2, Date.valueOf(sessao.getData()));
            preparestatement.setDouble(2, sessao.getValorIngresso());
            
            //executando comando sql
            int result = preparestatement.executeUpdate();
            if (result > 0) {
                ResultSet id = preparestatement.getGeneratedKeys();
                if (id.next()) {
                    sessao.setSessaoID(id.getInt(1));
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            throw e;
        }

    }

    /**
    *
    * @param salaID
    * @param filmeID
    * @return
    * @throws ClassNotFoundException
    * @throws SQLException
    */
    public boolean exists(int salaID, int filmeID) throws ClassNotFoundException, SQLException{
        String query = "select * from Sessoes where SalaID = '"+ salaID +"' AND FilmeID = '"+ filmeID +"';";

        ResultSet dados = contexto.executeQuery(query);

        return dados.next();
    }

    /**
     *
     * @param id
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Sessao get(int id) throws ClassNotFoundException, SQLException {
        String query = "select * from Sessoes where SessaoID = '" + id + "';";
        Sessao sessao = new Sessao();
        ResultSet dados = contexto.executeQuery(query);

        while (dados.next()) {
            sessao.setSessaoID(dados.getInt("SessaoID"));
            sessao.setFilmeID(dados.getInt("FilmeID"));
            sessao.setSalaID(dados.getInt("SalaID"));
            sessao.setIngressos(dados.getInt("Ingressos"));
            sessao.setData(dados.getDate("Data").toLocalDate());
            sessao.setValorIngresso(dados.getValorIngresso("ValorIngresso"));

            String queryFilme = "select * from Filmes where FilmeID = '"
                    + dados.getInt("FilmeID")
                    + "';";
            ResultSet dadosFilme = contexto.executeQuery(queryFilme);

            while (dadosFilme.next()) {
                sessao.setFilme(
                        new Filme(
                            dadosFilme.getInt("FilmeID")),
                            dadosFilme.getString("Titulo"),
                            dadosFilme.getString("Diretor"),
                            dadosFilme.getString("Genero"),
                            dadosFilme.getString("Idioma"),
                            dadosFilme.getInt("Duracao")
                );
            }

            String querySala = "select * from Salas where SalaID = '"
                        + dados.getInt("SalaID")
                        + "';";
            ResultSet dadosSala = contexto.executeQuery(querySala);

            while (dadosCat.next()) {
                sessao.setSala()(
                        new Sala(
                                dadosSala.getInt("SalaID"),
                                dadosSala.getInt("Numero"),
                                dadosSala.getInt("Capacidade")
                );
            }
        }

        return Sessao;
    }

    /**
     *
     * @param untilNow
     * @param beginDate
     * @param endDate
     * @return @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<Sessao> getAll() throws ClassNotFoundException, SQLException {
        String query = "select * from Sessoes order by Data desc;";
        System.out.println(query);
        ArrayList<Sessao> list = new ArrayList<>();

        ResultSet dados = contexto.executeQuery(query);

        while (dados.next()) {
            Sessao sessao = new Sessao();

            sessao.setSessaoID(dados.getInt("SessaoID"));
            sessao.setFilmeID(dados.getInt("FilmeID"));
            sessao.setSalaID(dados.getInt("SalaID"));
            sessao.setIngressos(dados.getInt("Ingressos"));
            sessao.setData(dados.getDate("Data").toLocalDate());
            sessao.setValorIngresso(dados.getValorIngresso("ValorIngresso"));

            String queryFilme = "select * from Filmes where FilmeID = '"
                    + dados.getInt("FilmeID")
                    + "';";
            ResultSet dadosFilme = contexto.executeQuery(queryFilme);

            while (dadosFilme.next()) {
                sessao.setFilme(
                        new Filme(
                            dadosFilme.getInt("FilmeID")),
                            dadosFilme.getString("Titulo"),
                            dadosFilme.getString("Diretor"),
                            dadosFilme.getString("Genero"),
                            dadosFilme.getString("Idioma"),
                            dadosFilme.getInt("Duracao")
                );
            }

            String querySala = "select * from Salas where SalaID = '"
                        + dados.getInt("SalaID")
                        + "';";
            ResultSet dadosSala = contexto.executeQuery(querySala);

            while (dadosCat.next()) {
                sessao.setSala()(
                        new Sala(
                                dadosSala.getInt("SalaID"),
                                dadosSala.getInt("Numero"),
                                dadosSala.getInt("Capacidade")
                );
            }

            list.add(Sessao);
        }

        return list;
    }
    
    /**
     *
     * @param Sessao
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean update(Sessao sessao) throws ClassNotFoundException, SQLException {
        StringBuilder columnsAndValues = new StringBuilder(255);

        columnsAndValues.append(" FilmeID= '")
                .append(sessao.getFilmeID())
                .append("',");
        columnsAndValues.append(" SalaID= '")
                .append(sessao.getSalaID())
                .append("',");
        columnsAndValues.append(" Ingressos= '")
                .append(sessao.getIngressos())
                .append("',");
        columnsAndValues.append(" Data= '")
                .append(sessao.getData())
                .append("',");
        columnsAndValues.append(" ValorIngresso= '")
                .append(sessao.getValorIngresso())
                .append("',");

        String query = "update Sessoes SET "
                + columnsAndValues.toString()
                + " WHERE SessaoID = " + Sessao.getSessaoID();

        int result = contexto.executeUpdate(query);

        return result > 0;
    }

    /**
     *
     * @param id
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean delete(int id) throws ClassNotFoundException, SQLException {
        String sql = "delete from Sessoes where SessaoID = ?";
        try (PreparedStatement preparedStatement = contexto.getConexao().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw e;
        }

        return true;
    }
}
