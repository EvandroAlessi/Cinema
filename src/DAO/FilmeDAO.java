package DAO;

import DAL.Contexto;
import Models.Filme;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Filme
 */
public class FilmeDAO {
    private final Contexto contexto = new Contexto();

    /**
     *
     * @return @throws ClassNotFoundException
     * @throws SQLException
     */
    public String[] getAllMetaData() throws ClassNotFoundException, SQLException {
        String query = "select * from Filme;";
        ResultSetMetaData fields = contexto.executeQuery(query).getMetaData();
        String[] columns = new String[fields.getColumnCount()];

        for (int i = 1; i <= fields.getColumnCount(); i++) {
            columns[i - 1] = fields.getColumnName(i);
        }

        return columns;
    }

    /**
     * Cria uma nova filme a partir do objeto recebido
     * @param filme
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean create(Filme filme) throws SQLException, ClassNotFoundException {
        String sql = "insert into Filme(Descricao, Positiva)values(?,?)";
        try (PreparedStatement preparestatement = contexto.getConexao().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparestatement.setString(1, filme.getDiretor()); //substitui o ? pelo dado do usuario
            preparestatement.setInt(2, filme.get);

            //executando comando sql
            int result = preparestatement.executeUpdate();
            if (result > 0) {
                ResultSet id = preparestatement.getGeneratedKeys();
                if (id.next()) {
                    filme.setFilmeID(id.getInt(1));
                    return true;
                }
            }
            
            return false;
        } catch (SQLException e) {
            throw e;
        }
    }

    public boolean exists(String desc, boolean positiva) throws ClassNotFoundException, SQLException {
        String query = "select FilmeID from Filme where Descricao like '" + desc + "' AND Positiva = '" + (positiva ? 1 : 0) + "';";

        ResultSet dados = contexto.executeQuery(query);

        return dados.next();
    }

    /** 
     * Busca a filme a partir do id informado
     * 
     * @param id
     * @return 
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Filme get(int id) throws ClassNotFoundException, SQLException {
        String query = "select * from Filme where FilmeID = '" + id + "';";
        Filme filme = new Filme();
        ResultSet dados = contexto.executeQuery(query);

        while (dados.next()) {
            filme.setDescricao(dados.getString("Descricao"));
            filme.setFilmeID(dados.getInt("FilmeID"));
            filme.setPositiva(dados.getBoolean("Positiva"));
        }

        return filme;
    }

    /**
     * Busca todas as filmes existentes no banco de dados
     *
     * @return ArrayList<Filme> lista de todas as filme
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<Filme> getAll() throws SQLException, ClassNotFoundException {
        String query = "select * from Filme order by Titulo;";
        ArrayList<Filme> lista = new ArrayList<>();

        ResultSet dados = contexto.executeQuery(query);

        while (dados.next()) {
            Filme filme = new Filme();
            filme.setDescricao(dados.getString("Descricao"));
            filme.setFilmeID(dados.getInt("FilmeID"));
            filme.setPositiva(dados.getBoolean("Positiva"));

            lista.add(filme);
        }

        return lista;
    }

    /**
     * Busca todas as filmes existentes no banco de dados
     *
     * @param positiva despesa/receita
     * @return ArrayList<Filme> lista de todas as filme
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<Filme> getAll(boolean positiva) throws SQLException, ClassNotFoundException {
        String query = "select * from Filme where Positiva = '" + (positiva ? 1 : 0) + "' order by Descricao;";
        ArrayList<Filme> lista = new ArrayList<>();

        ResultSet dados = contexto.executeQuery(query);

        while (dados.next()) {
            Filme filme = new Filme();
            filme.setDescricao(dados.getString("Descricao"));
            filme.setFilmeID(dados.getInt("FilmeID"));
            filme.setPositiva(dados.getBoolean("Positiva"));

            lista.add(filme);
        }

        return lista;
    }

    /**
     * Atualiza a Categoria a partir dos dados da mesma
     *
     * @param filme Objeto do tipo Categoria com todos os campos para a
     * atualização
     * @return true caso ocorra com sucesso; false caso não ocorra com sucesso;
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean update(Filme filme) throws ClassNotFoundException, SQLException {
        StringBuilder columnsAndValues = new StringBuilder(255);

        columnsAndValues.append("Descricao= '")
                .append(filme.getDescricao())
                .append("'");
        columnsAndValues.append("Positiva= '")
                .append(filme.isPositiva())
                .append("'");

        String query = "update Filme SET "
                + columnsAndValues.toString()
                + " WHERE FilmeID = " + filme.getFilmeID();

        int result = contexto.executeUpdate(query);

        return result > 0;
    }

    /**
     * Exclui uma filme a partir do id indicado
     *
     * @param id id da filme
     * @return true caso ocorra com sucesso; false caso não ocorra com sucesso;
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public boolean delete(int id) throws ClassNotFoundException, SQLException {
        String sql = "delete from Filme where FilmeID = ?";
        try (PreparedStatement preparedStatement = contexto.getConexao().prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw e;
        }

        return true;
    }
}