package exercicio1.negocio;

import java.util.List;

import exercicio1.dados.Pessoa;
import exercicio1.persistencia.PessoaDAO;

public class Sistema {
    private PessoaDAO pessoaDAO = new PessoaDAO();

    public void adicionarPessoa(Pessoa p){
        pessoaDAO.insert(p);
    }

    public void removerPessoa(Pessoa p){
        pessoaDAO.delete(p);
    }

    public List<Pessoa> getList(){
        return pessoaDAO.getAll();
    }
}