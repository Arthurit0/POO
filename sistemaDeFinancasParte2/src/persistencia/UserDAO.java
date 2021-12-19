package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dados.User;
import exceptions.*;

public class UserDAO {
    private static UserDAO instance = null;

    private PreparedStatement selectNewId;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement selectFromLogin;
    private PreparedStatement select;

    private UserDAO() throws ClassNotFoundException, SQLException, SelectException {
        Connection conexao = Conexao.getConexao();
        selectNewId = conexao.prepareStatement("select nextval('id_usuario')");
        insert = conexao.prepareStatement("insert into usuario values (?,?,?)");
        delete = conexao.prepareStatement("delete from usuario where login = ?");
        selectFromLogin = conexao.prepareStatement("select * from usuario where login = ?");
        select = conexao.prepareStatement("select * from usuario where id = ?");
    }

    public static UserDAO getInstance() throws ClassNotFoundException, SQLException, SelectException {
        if(instance == null){
            instance = new UserDAO();
        }

        return instance;
    }

    private int SelectNewId() throws SelectException {
        try {
            ResultSet rs = selectNewId.executeQuery();

            if(rs.next()){
                return rs.getInt(1);
            }

        } catch (SQLException e) {
            throw new SelectException("Erro ao buscar novo id da tabela usuario");
        }

        return 0;
    }

    public void insert(User user) throws InsertException, SelectException {
        try {
            insert.setInt(1, SelectNewId());
            insert.setString(2, user.getLogin());
            insert.setString(3, user.getSenha());

            insert.executeUpdate();

        } catch (Exception e) {
            throw new InsertException("Erro ao inserir usuário! ");
        }
    }

    public void delete(String login) throws DeleteException {
        try {
            delete.setString(1, login);
            delete.executeUpdate();

        } catch (Exception e) {
            throw new DeleteException("Erro ao deletar usuário! ");
        }
    }

    public User selectFromLogin(String lgn) throws SelectException {
        try {
            selectFromLogin.setString(1, lgn);
            ResultSet rs = selectFromLogin.executeQuery();

            if(rs.next()){
                int id = rs.getInt(1);
                String login = rs.getString(2);
                String senha = rs.getString(3);

                return new User(id, login, senha);
            }

        } catch (SQLException e) {
            throw new SelectException("(1) Erro ao retornar usuário! ");
        }

        return null;
    }

    public User select(int id) throws SelectException {
        try {
            select.setInt(1, id);
            ResultSet rs = select.executeQuery();

            if(rs.next()){
                int id_user = rs.getInt(1);
                String login = rs.getString(2);
                String senha = rs.getString(3);

                return new User(id_user, login, senha);
            }


        } catch (Exception e) {
            throw new SelectException("(2) Erro ao retornar usuário! ");
        }
        return null;

    }
}
