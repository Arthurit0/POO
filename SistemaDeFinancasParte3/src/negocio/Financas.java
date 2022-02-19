package negocio;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTable;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import dados.*;
import exceptions.*;
import interfaceGráfica.TabelaGastos;
import persistencia.*;

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
            LoadGastos();
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
        LoadGastos();
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

    private void LoadGastos() throws SelectException{
        gastos_logado = gastoDAO.selectAll(ID_logado);
    }

    public void addUser(User user) throws InsertException{
        userDAO.insert(user);
    }

    public void removeUser(User user) throws DeleteException{
        userDAO.delete(user);
    }

    public JTable tabelaDeGastos() throws SelectException{
        TabelaGastos tabelaDeGastos = new TabelaGastos();
        JTable tabela = new JTable(tabelaDeGastos);
        
        tabela.setFont(new java.awt.Font("Roboto", 0, 14));
        tabela.setRowHeight(30);


        tabelaDeGastos.populateGastos(seeAllGastos());


        tabela.getColumnModel().getColumn(0).setResizable(false);
        tabela.getColumnModel().getColumn(1).setResizable(false);
        tabela.getColumnModel().getColumn(2).setResizable(false);
        tabela.getColumnModel().getColumn(3).setResizable(false);
        tabela.getColumnModel().getColumn(4).setResizable(false);

        return tabela;
    }

    public JTable tabelaDeGastos(List<Gasto> gastos){
        TabelaGastos tabelaDeGastos = new TabelaGastos();
        JTable tabela = new JTable(tabelaDeGastos);
        
        tabela.setFont(new java.awt.Font("Roboto", 0, 14));
        tabela.setRowHeight(30);

        tabelaDeGastos.populateGastos(gastos);

        tabela.getColumnModel().getColumn(0).setResizable(false);
        tabela.getColumnModel().getColumn(1).setResizable(false);
        tabela.getColumnModel().getColumn(2).setResizable(false);
        tabela.getColumnModel().getColumn(3).setResizable(false);
        tabela.getColumnModel().getColumn(4).setResizable(false);

        return tabela;
    }

    public CategoryDataset barraDeGastos(){
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        float comida = 0, lazer = 0, educacao = 0, saude = 0, transporte = 0, outros = 0;

        for (Gasto gasto : gastos_logado) {
            int cat = gasto.getCategoria();
            float valor = gasto.getValor();

            switch (cat) {
                case 1:
                    comida += valor;
                    break;
                case 2:
                    lazer += valor;
                    break;
                case 3:
                    educacao += valor;
                    break;
                case 4:
                    saude += valor;
                    break;
                case 5:
                    transporte += valor;
                    break;
                case 6:
                    outros += valor;
                    break;
            
                default:
                    break;
            }
        }

        dataset.addValue(comida, "", "Comida");
        dataset.addValue(lazer, "", "Lazer");
        dataset.addValue(educacao, "", "Educação");
        dataset.addValue(saude, "", "Saúde");
        dataset.addValue(transporte, "", "Transporte");
        dataset.addValue(outros, "", "Outros");

        return dataset;
    }

    public XYDataset scatterDeGastos(){
        final XYSeriesCollection dataset = new XYSeriesCollection();
        XYSeries mesValues = new XYSeries("Mês");
        float jan = 0, fev = 0, mar = 0, abr = 0, mai = 0, jun = 0, jul = 0, agos = 0, set = 0, out = 0, nov = 0, dez = 0;

        for (Gasto gasto : gastos_logado) {
            int mes = Integer.parseInt(gasto.getData().substring(3,5));
            float valor = gasto.getValor();

            switch (mes) {
                case 1:
                    jan += valor;
                    break;
                case 2:
                    fev += valor;
                    break;
                case 3:
                    mar += valor;
                    break;
                case 4:
                    abr += valor;
                    break;
                case 5:
                    mai += valor;
                    break;
                case 6:
                    jun += valor;
                    break;
                case 7:
                    jul += valor;
                    break;
                case 8:
                    agos += valor;
                    break;
                case 9:
                    set += valor;
                    break;
                case 10:
                    out += valor;
                    break;
                case 11:
                    nov += valor;
                    break;
                case 12:
                    dez += valor;
                    break;
            
                default:
                    break;
            }
        }

        mesValues.add(1, jan);
        mesValues.add(2, fev);
        mesValues.add(3, mar);
        mesValues.add(4, abr);
        mesValues.add(5, mai);
        mesValues.add(6, jun);
        mesValues.add(7, jul);
        mesValues.add(8, agos);
        mesValues.add(9, set);
        mesValues.add(10, out);
        mesValues.add(11, nov);
        mesValues.add(12, dez);

        dataset.addSeries(mesValues);

        return dataset;
    }

}
