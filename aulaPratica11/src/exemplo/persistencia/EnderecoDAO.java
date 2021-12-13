package exemplo.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.SQLException;

import exemplo.dados.Endereco;
import exemplo.exceptions.InsertException;
import exemplo.exceptions.SelectException;

public class EnderecoDAO {
    private static EnderecoDAO instance = null;

    private PreparedStatement selectNewId;
    private PreparedStatement select;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;

    private EnderecoDAO() throws ClassNotFoundException, SQLException, SelectException {
        Connection conexao = Conexao.getConexao();
        selectNewId = conexao.prepareStatement("select nextval('id_endereco')");
        insert = conexao.prepareStatement("insert into endereco values (?,?,?,?,?)");
    }

    public static EnderecoDAO getInstance() throws ClassNotFoundException, SQLException, SelectException {
        if (instance == null){
            instance = new EnderecoDAO();
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
            throw new SelectException("Erro ao buscar novo id da tabela endereco");
        }

        return 0;
    }

    public void insert(Endereco endereco) throws InsertException, SelectException {
        try {
            insert.setInt(1, SelectNewId());
            insert.setString(2,endereco.getRua());
            insert.setInt(3, endereco.getNumero());
            insert.setString(4, endereco.getCidade());
            insert.setInt(5, endereco.getIdPessoa());

        } catch (Exception e) {
            throw new InsertException("Erro ao inserir endereco");
        }
    }
}
