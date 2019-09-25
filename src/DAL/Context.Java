package DAL;


public class Context {
    private static Connection _connection;

    public Context() {
        conectar();
    }

    public void conectar(){
        _connection = new Connection();
    }
}