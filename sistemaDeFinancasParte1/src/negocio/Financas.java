package negocio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dados.*;

public class Financas {
    private Map<User, List<Gasto>> usuarios = new HashMap<User, List<Gasto>>();
    private User logado = new User();

    public Financas(){
        novoUsuario("teste", "123");
        loginUsuario("teste", "123");
        novoGasto(new Gasto("Gasto 1", "Um Teste", new Data(12, 1, 2021), (float)10.25, 1));
        novoGasto(new Gasto("Gasto 2", "Outro Teste", new Data(13, 3, 2021), (float)22.50, 2));
        novoGasto(new Gasto("Gasto 3", "Teste...", new Data(14, 3, 2021), (float)2.50, 5));
        novoGasto(new Gasto("Gasto 4", "Teste?", new Data(15, 12, 2021), (float)44.75, 5));
        novoGasto(new Gasto("Gasto 5", "Teste!", new Data(16, 9, 2021), 200, 3));

        logoffUsuario();

    }

    public void novoUsuario(String login, String senha){
        User user = new User(login, senha);
        List<Gasto> gastos = new ArrayList<Gasto>();

        usuarios.put(user, gastos);
    }

    public boolean loginUsuario(String login, String senha){
        for (User user : usuarios.keySet()) {
            if(user.getLogin().equals(login)){
                if(user.getSenha().equals(senha)){
                    logado = user;
                    return true;
                }
            }
        }

        return false;
    }

    public void logoffUsuario(){
        logado = new User();
    }

    public boolean verifLog(){
        if(logado.getLogin() != null && logado.getSenha() != null){
            return true;
        }else{
            return false;
        }
    }

    public boolean novoGasto(Gasto gasto){
        if(verifLog()){
            usuarios.get(logado).add(gasto);
            return true;
        }
        
        return false;
        
    }

    public List<Gasto> getGastos(){
        return usuarios.get(logado);
    }

    public List<Gasto> filtraGastosMes(int mes){
        List<Gasto> gastosMes = new ArrayList<Gasto>();

        for (Gasto gasto : usuarios.get(logado)) {
            if(gasto.getData().getMes() == mes){
                gastosMes.add(gasto);
            }
        }

        return gastosMes;
    }

    public List<Gasto> filtraGastosCategoria(int categoria){
        List<Gasto> gastosCateg = new ArrayList<Gasto>();

        for(Gasto gasto : usuarios.get(logado)){
            if(gasto.getCategoria() == Categorias.values()[categoria]){
                gastosCateg.add(gasto);
            }
        }

        return gastosCateg;
    }

    public boolean deletaGasto(int index){
        if(verifLog()){
            usuarios.get(logado).remove(index);
            return true;
        }

        return false;
    }

    public boolean editaGastoNome(int index, String nome){
        if(verifLog()){
            usuarios.get(logado).get(index).setNome(nome);
            return true;
        }

        return false;
    }

    public boolean editaGastoDescricao(int index, String desc){
        if(verifLog()){
            usuarios.get(logado).get(index).setDescricao(desc);
            return true;
        }

        return false;
    }

    public boolean editaGasto(int index, Data data){
        if(verifLog()){
            usuarios.get(logado).get(index).setData(data);
            return true;
        }

        return false;
    }

    public boolean editaGasto(int index, float valor){
        if(verifLog()){
            usuarios.get(logado).get(index).setValor(valor);
            return true;
        }

        return false;
    }

    public boolean editaGasto(int index, int categoria){
        if(verifLog()){
            usuarios.get(logado).get(index).setCategoria(categoria);
            return true;
        }

        return false;
    }



}
