package exercicio.negocio;

import exercicio.dados.Contato;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;



public class ListaTelefonica {
    private Map<Character, List<Contato>> contatos = new HashMap<Character, List<Contato>>();

    public ListaTelefonica(){
        for (char i = 'A'; i < 'Z'+1; i++) {
            List<Contato> lista = new LinkedList<Contato>();
            contatos.put(i,lista);
        }
    }

    public void adicionaContato(Contato contato){
        char chave = contato.getNome().toUpperCase().charAt(0);

        contatos.get(chave).add(contato);
    }

    public void removeContato (Contato contato){
        char chave = contato.getNome().toUpperCase().charAt(0);

        contatos.get(chave).remove(contato);
    }

    public List<Contato> buscarContatos(char letra){
        return contatos.get(letra);
    }

    public Map<Character, List<Contato>> buscarContatos(){
        return contatos;
    }
}