package negocio;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dados.*;
import exceptions.DeleteException;
import exceptions.InsertException;
import exceptions.SelectException;
import exceptions.SenhaIncorretaException;
import exceptions.UpdateException;
import exceptions.UsuarioNaoExisteException;
import persistencia.Conexao;
import persistencia.GastoDAO;
import persistencia.UserDAO;

public class Financas {
    private UserDAO userDAO; 
    private GastoDAO gastoDAO;
    private int ID_logado = -1;
    private List<Gasto> gastos_logado = new LinkedList<Gasto>();
    
    public Financas(String senha) throws ClassNotFoundException, SQLException, SelectException{
        Conexao.setSenha(senha);
        userDAO = UserDAO.getInstance();
        gastoDAO = GastoDAO.getInstance();
    }

    public boolean login(String login, String senha) throws SelectException, UsuarioNaoExisteException, SenhaIncorretaException{
        User usuario = userDAO.selectFromLogin(login);

        if(usuario == null){
            throw new UsuarioNaoExisteException("Usuário não registrado!");
        }

        if(usuario.getSenha().equals(senha)){
            ID_logado = usuario.getId();
            loadGastos();

            return true;
        }else{
            throw new SenhaIncorretaException("Senha Incorreta!");
        }


    }

    public void logoff(){
        ID_logado = -1;
        gastos_logado.clear();
    }

    public void add(Gasto gasto) throws InsertException, SelectException{
        gasto.setId_usuario(ID_logado);
        gastoDAO.insert(gasto);
    }

    public List<Gasto> seeAll() throws SelectException{
        loadGastos();
        return gastos_logado;
    }

    public void rmv(Gasto gasto) throws DeleteException{
        gasto.setId_usuario(ID_logado);
        gastoDAO.delete(gasto);
    }

    public void updt(Gasto gasto) throws UpdateException{
        gasto.setId_usuario(ID_logado);
        gastoDAO.update(gasto);
    }

    private void loadGastos() throws SelectException{
        gastos_logado = gastoDAO.selectAll(ID_logado);
    }

}
