package exemplo.negocio;

import java.sql.SQLException;
import java.util.List;

import exemplo.dados.Pessoa;
import exemplo.exceptions.DeleteException;
import exemplo.exceptions.InsertException;
import exemplo.exceptions.SelectException;
import exemplo.exceptions.UpdateException;
import exemplo.persistencia.Conexao;
import exemplo.persistencia.PessoaDAO;

public class Sistema {
    private PessoaDAO pessoaDAO;

    public Sistema(String senha) throws ClassNotFoundException, SQLException, SelectException {
        Conexao.setSenha(senha);
        pessoaDAO = PessoaDAO.getInstance();
    }

    public void inserirPessoa(Pessoa p) throws InsertException, SelectException {
        pessoaDAO.insert(p);
    }

    public List<Pessoa> selectAll() throws SelectException {
        return pessoaDAO.selectAll();
    }

    public void deletePessoa(Pessoa p) throws DeleteException {
        pessoaDAO.delete(p);
    }

    public void atualizarPessoa(Pessoa p) throws UpdateException {
        pessoaDAO.update(p);
    }
}
