package exercicio1.persistencia;

import java.util.List;

import exercicio1.dados.Pessoa;

public class PessoaDAO {
    private ArquivoPessoaDAO arquivoPessoaDAO = new ArquivoPessoaDAO();
    
    public void insert(Pessoa p){
        arquivoPessoaDAO.salvaPessoaArquivo(p);
    }

    public void delete(Pessoa p){
        List<Pessoa> pessoas = arquivoPessoaDAO.lePessoasArquivo();

        pessoas.remove(p);

        arquivoPessoaDAO.salvaPessoasArquivo(pessoas);
    }

    public List<Pessoa> getAll(){
        return arquivoPessoaDAO.lePessoasArquivo();
    }
}
