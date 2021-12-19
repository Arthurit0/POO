package exercicio.negocio;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import exercicio.exceptions.DeleteException;
import exercicio.exceptions.InsertException;
import exercicio.exceptions.SelectException;
import exercicio.exceptions.UpdateException;
import exercicio.dados.Contato;
import exercicio.persistencia.Conexao;
import exercicio.persistencia.ContatoDAO;

public class ListaTelefonica {
    private ContatoDAO contatoDAO;
    private Map<Character, List<Contato>> listaDeContatos = new HashMap<Character, List<Contato>>();

    public ListaTelefonica(String senha) throws ClassNotFoundException, SQLException, SelectException {
        Conexao.setSenha(senha);
        contatoDAO = ContatoDAO.getInstance();

        for (char i = 'A'; i < 'Z'+1; i++) {
            List<Contato> lista = new LinkedList<Contato>();
            listaDeContatos.put(i,lista);
        }
    }


    public void adicionaContato(Contato c) throws SelectException, InsertException {
        contatoDAO.insert(c);
    }

    public void removeContato (Contato c) throws DeleteException{
        contatoDAO.delete(c);
    }

    public void atualizaContato(Contato c) throws UpdateException{
        contatoDAO.update(c);
    }

    public Map<Character, List<Contato>> getAllContatos() throws SelectException{
        limpaListaLocal();

        List<Contato> contatosNaTabela;

        contatosNaTabela = contatoDAO.selectAll();
        for(Character letra : listaDeContatos.keySet()){

            for(Contato contato : contatosNaTabela){

                if(letra == contato.getNome().toUpperCase().charAt(0)){

                    List<Contato> listaDaLetra = listaDeContatos.get(letra);
                    listaDaLetra.add(contato);
                }
            }
        }          

        return listaDeContatos;
        
    }

    private void limpaListaLocal() {//Evita repetições de contatos já salvos nas listas do map quando o getAll foi chamado. Tudo isso é para não precisar reconstruir o Map de A a Z em todas as chamadas
        for(Character letra : listaDeContatos.keySet()){
            listaDeContatos.get(letra).clear();
        }
    }
}