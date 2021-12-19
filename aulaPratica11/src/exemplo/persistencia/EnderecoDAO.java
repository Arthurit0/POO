package exemplo.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exemplo.dados.Endereco;
import exemplo.exceptions.DeleteException;
import exemplo.exceptions.InsertException;
import exemplo.exceptions.SelectException;
import exemplo.exceptions.UpdateException;

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
        select = conexao.prepareStatement("select * from endereco where id_pessoa = ?");
        update = conexao.prepareStatement("update endereco set rua = ?, numero = ?, cidade = ? where id_pessoa = ?");
        delete = conexao.prepareStatement("delete from endereco where id_pessoa = ?");
    
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
            insert.executeUpdate();

        } catch (Exception e) {
            throw new InsertException("Erro ao inserir endereco");
        }
    }

    public Endereco select(int pessoa) throws SelectException {
        try {
            select.setInt(1, pessoa);
            ResultSet rs = select.executeQuery();

            if(rs.next()){
                int id = rs.getInt(1);
                String rua = rs.getString(2);
                int numero = rs.getInt(3);
                String cidade = rs.getString(4);
                int IdPessoa = rs.getInt(5); //ADICIONEI ESSA LINHA POIS DAVA ERRADO SEM
                return new Endereco(id, rua, numero, cidade, IdPessoa);
            }

        } catch (SQLException e) {
            throw new SelectException("Erro ao buscar endereço da pessoa ");
        }

        return null;
    }

    public void update (Endereco endereco) throws UpdateException {
        try {
            update.setString(1, endereco.getRua());
            update.setInt(2, endereco.getNumero());
            update.setString(3, endereco.getCidade());
            update.setInt(4, endereco.getIdPessoa());
            update.executeUpdate();

        } catch (SQLException e) {
            throw new UpdateException("Erro ao atualizar endereço");
        }
    }

    public void delete (Endereco endereco) throws DeleteException {
        try {
            delete.setInt(1, endereco.getId());
            delete.executeUpdate();
        } catch (Exception e) {
            throw new DeleteException("Erro ao deletar endereço");
        }
    }
}
