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
    
    public Financas() throws ClassNotFoundException, SQLException, SelectException{
        String senha = "722010";
        Conexao.setSenha(senha);
        userDAO = UserDAO.getInstance();
        gastoDAO = GastoDAO.getInstance();
    }

    public void login(String login, String senha) throws SelectException, UsuarioNaoExisteException, SenhaIncorretaException{
        User usuario = userDAO.selectFromLogin(login);

        if(usuario == null){
            throw new UsuarioNaoExisteException("Usuário não registrado! ");
        }

        if(usuario.getSenha().equals(senha)){
            ID_logado = usuario.getId();
            loadGastos();
        }else{
            throw new SenhaIncorretaException("Senha Incorreta! ");
        }
    }

    public void logoff(){
        ID_logado = -1;
        gastos_logado.clear();
    }

    public void addGasto(Gasto gasto) throws InsertException, SelectException{
        gasto.setId_usuario(ID_logado);
        gastoDAO.insert(gasto);
    }

    public List<Gasto> seeAllGastos() throws SelectException{
        loadGastos();
        return gastos_logado;
    }

    public Gasto selectGasto(int id) throws SelectException{
        return gastoDAO.select(id);
    }

    public List<Gasto> selectGastosFromCategoria(int cat) throws SelectException{
        return gastoDAO.selectFromCateg(cat, ID_logado);
    }

    public List<Gasto> selectGastosFromMes(int mes) throws SelectException{
        String mesString = "";

        if(mes > 0 && mes <=12){
            if(mes < 10){
                mesString += "0"+mes;
            }else{
                mesString += mes;
            }
        }

        return gastoDAO.selectFromMes(mesString, ID_logado);

    }

    public void removeGasto(Gasto gasto) throws DeleteException{
        gasto.setId_usuario(ID_logado);
        gastoDAO.delete(gasto);
    }

    public void updateGasto(Gasto gasto) throws UpdateException{
        gasto.setId_usuario(ID_logado);
        gastoDAO.update(gasto);
    }

    private void loadGastos() throws SelectException{
        gastos_logado = gastoDAO.selectAll(ID_logado);
    }

    public void addUser(User user) throws InsertException, SelectException{
        userDAO.insert(user);
    }

    public void removeUser(String login) throws DeleteException, SelectException{
        userDAO.delete(userDAO.selectFromLogin(login));
    }

}
