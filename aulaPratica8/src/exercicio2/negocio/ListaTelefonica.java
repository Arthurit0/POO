package exercicio2.negocio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exercicio2.dados.Contato;
import exercicio2.persistencia.ContatoDAO;

public class ListaTelefonica {
    ContatoDAO contatoDAO = new ContatoDAO();
    Map<Character, List<Contato>> listaDeContatos = new HashMap<Character, List<Contato>>();

    public ListaTelefonica(){
        atualiza();
    }
    
    public void atualiza(){
        listaDeContatos = contatoDAO.getAll();
    }

    public void adicionaContato(Contato contato){
        contatoDAO.insert(contato);
        atualiza();
    }

    public void removeContato (Contato contato){
        contatoDAO.delete(contato);
        atualiza();
    }

    public List<Contato> buscarContatos(char letra){
        return listaDeContatos.get(letra);
    }

    public Map<Character, List<Contato>> buscarContatos(){
        return listaDeContatos;
    }

}