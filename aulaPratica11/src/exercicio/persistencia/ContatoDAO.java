package exercicio.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import exercicio.exceptions.*;
import exercicio.dados.Contato;

public class ContatoDAO {
    private static ContatoDAO instance = null;

    private PreparedStatement selectNewId;
    private PreparedStatement selectAll;
    private PreparedStatement insert;
    private PreparedStatement delete;
    private PreparedStatement update;

    private ContatoDAO() throws ClassNotFoundException, SQLException, SelectException{
        Connection conexao = Conexao.getConexao();
        selectNewId = conexao.prepareStatement("select nextval('id_contato')");
        insert = conexao.prepareStatement("insert into contato values (?,?,?)");
        selectAll = conexao.prepareStatement("select * from contato");
        update = conexao.prepareStatement("update contato set nome = ?, telefone = ? where id = ?");
        delete = conexao.prepareStatement("delete from contato where id = ?");
    }

    public static ContatoDAO getInstance() throws ClassNotFoundException, SQLException, SelectException {
        if (instance == null){
            instance = new ContatoDAO();
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
            throw new SelectException("Erro ao buscar novo id da tabela contato");
        }

        return 0;
    }
    
    public void insert(Contato c) throws InsertException, SelectException {
        try {
            insert.setInt(1, SelectNewId());
            insert.setString(2, c.getNome());
            insert.setInt(3, c.getTelefone());

            insert.executeUpdate();
        } catch (Exception e) {
            throw new InsertException("Erro ao inserir contato!");
        }

    }

    public List<Contato> selectAll() throws SelectException{
        List<Contato> contatos = new LinkedList<Contato>();

        try {
            ResultSet rs = selectAll.executeQuery();

            while(rs.next()){
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                int telefone = rs.getInt(3);

                contatos.add(new Contato(id, nome, telefone));
            }

        } catch (Exception e) {
            throw new SelectException("Erro ao buscar contatos!");
        }

        return contatos;
    }

    public void update(Contato c) throws UpdateException {
        try{
            update.setString (1, c.getNome());
            update.setInt(2, c.getTelefone());
            
            update.setInt(3, c.getId());

            update.executeUpdate();
        }catch(SQLException e){
            throw new UpdateException("Erro ao atualizar contato!");
        }
    }

    public void delete (Contato c) throws DeleteException {
        try {

            delete.setInt(1, c.getId());
            delete.executeUpdate();
        } catch (Exception e) {
            throw new DeleteException("Erro ao deletar contato!");
        }
    }

}
