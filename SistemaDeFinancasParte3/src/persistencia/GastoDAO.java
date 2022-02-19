package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dados.Gasto;
import exceptions.*;

public class GastoDAO {
    private static GastoDAO instance = null;

    private PreparedStatement selectNewId;
    private PreparedStatement insert;
    private PreparedStatement select;
    private PreparedStatement selectAll;
    private PreparedStatement selectFromCateg;
    private PreparedStatement selectFromMes;
    private PreparedStatement update;
    private PreparedStatement delete;

    private GastoDAO() throws ClassNotFoundException, SQLException, SelectException {
        Connection conexao = Conexao.getConexao();

        selectNewId = conexao.prepareStatement("select nextval('id_gasto')");
        insert = conexao.prepareStatement("insert into gasto values (?,?,?,?,?,?,?)");
        delete = conexao.prepareStatement("delete from gasto where id = ?");
        select = conexao.prepareStatement("select * from gasto where id = ?");
        selectAll = conexao.prepareStatement("select * from gasto where id_usuario = ?");
        selectFromCateg = conexao.prepareStatement("select * from gasto where id_categoria = ? and id_usuario = ?");
        selectFromMes = conexao.prepareStatement("select * from gasto where (substring(data_do_gasto from 4 for 2)) = ? and id_usuario = ?");
        update = conexao.prepareStatement("update gasto set nome = ?, descricao = ?, data_do_gasto = ?, valor = ?, id_categoria = ? where id = ?");

    }

    public static GastoDAO getInstance() throws ClassNotFoundException, SQLException, SelectException {
        if(instance == null){
            instance = new GastoDAO();
        }
        return instance;
    }

    private int SelectNewId() throws SelectException {
        try {
            ResultSet rs = selectNewId.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        
        } catch (Exception e) {
            throw new SelectException("\nErro ao buscar novo id da tabela gasto! ");
        }

        return 0;
    }

    public void insert(Gasto gasto) throws InsertException {
        try {
            insert.setInt(1, SelectNewId());
            insert.setString(2, gasto.getNome());
            insert.setString(3, gasto.getDescricao());
            insert.setString(4, gasto.getData());
            insert.setFloat(5, gasto.getValor());
            insert.setInt(6, gasto.getCategoria());
            insert.setInt(7, gasto.getId_usuario());

            insert.executeUpdate();

        } catch (Exception e) {
            throw new InsertException("\nErro ao inserir gasto! ");
        }
    }

    public List<Gasto> selectAll(int id_logged) throws SelectException {
        List<Gasto> gastos = new LinkedList<Gasto>();

        try {
            selectAll.setInt(1, id_logged);
            ResultSet rs = selectAll.executeQuery();

            while(rs.next()){
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String descricao = rs.getString(3);
                String data = rs.getString(4);
                float valor = rs.getFloat(5);
                int id_categoria = rs.getInt(6);
                int id_usuario = rs.getInt(7);

                gastos.add(new Gasto(id, nome, descricao, data, valor, id_categoria, id_usuario));
            }

        } catch (Exception e) {
            throw new SelectException("\nErro ao retornar lista de gastos! ");
        }

        return gastos;
    }

    public Gasto select(int id_gasto) throws SelectException {
        try {
            select.setInt(1, id_gasto);
            ResultSet rs = select.executeQuery();

            if(rs.next()){
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String descricao = rs.getString(3);
                String data = rs.getString(4);
                float valor = rs.getFloat(5);
                int id_categoria = rs.getInt(6);
                int id_usuario = rs.getInt(7);

                return new Gasto(id, nome, descricao, data, valor, id_categoria, id_usuario);
            }

        } catch (Exception e) {
            throw new SelectException("\nErro ao retornar gasto! ");
        }

        return null;
    }

    public List<Gasto> selectFromCateg(int cat, int id_logged) throws SelectException {
        List<Gasto> gastosDaCat = new LinkedList<Gasto>();

        try {
            selectFromCateg.setInt(1, cat);
            selectFromCateg.setInt(2, id_logged);
            ResultSet rs = selectFromCateg.executeQuery();

            while(rs.next()){
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String descricao = rs.getString(3);
                String data = rs.getString(4);
                float valor = rs.getFloat(5);
                int id_categoria = rs.getInt(6);
                int id_usuario = rs.getInt(7);

                gastosDaCat.add(new Gasto(id, nome, descricao, data, valor, id_categoria, id_usuario));
            }

        } catch (Exception e) {
            throw new SelectException("\nErro ao selecionar gastos a partir da categoria! ");
        }

        return gastosDaCat;
    }

    public List<Gasto> selectFromMes(String mes, int id_logged) throws SelectException {
        List<Gasto> gastosFromMes = new LinkedList<Gasto>();
        try {
            selectFromMes.setString(1, mes);
            selectFromMes.setInt(2, id_logged);
            ResultSet rs = selectFromMes.executeQuery();

            while(rs.next()){
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String descricao = rs.getString(3);
                String data = rs.getString(4);
                float valor = rs.getFloat(5);
                int id_categoria = rs.getInt(6);
                int id_usuario = rs.getInt(7);

                gastosFromMes.add(new Gasto(id, nome, descricao, data, valor, id_categoria, id_usuario));
            }

        } catch (Exception e) {
            throw new SelectException("Erro ao selecionar gastos de um mês");
        }

        return gastosFromMes;
    }

    public void update(Gasto gasto) throws UpdateException {
        try {
            update.setString(1, gasto.getNome());
            update.setString(2, gasto.getDescricao());
            update.setString(3, gasto.getData());
            update.setFloat(4, gasto.getValor());
            update.setInt(5, gasto.getCategoria());

            update.setInt(6, gasto.getId());

            update.executeUpdate();

        } catch (Exception e) {
            throw new UpdateException("\nErro ao atualizar gasto!");
        }
    }

    public void delete(Gasto gasto) throws DeleteException{

        try {
            delete.setInt(1, gasto.getId());
            delete.executeUpdate();
        } catch (Exception e) {
            throw new DeleteException("\nErro ao deletar gasto!");
        }
    }

}
