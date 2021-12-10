package exercicio2.persistencia;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import exercicio2.dados.Contato;

public class ContatoDAO {
    ArquivoContato arquivoContato = new ArquivoContato();
    Map<Character, List<Contato>> listaDeContatos = new HashMap<Character, List<Contato>>();

    public ContatoDAO(){
        for (char i = 'A'; i < 'Z'+1; i++) {
            List<Contato> lista = new LinkedList<Contato>();
            listaDeContatos.put(i,lista);
        }
    }
    
    public void insert(Contato c){
        arquivoContato.salvaContatos(c);
    }

    public void delete(Contato c){
        List<Contato> contatos = arquivoContato.leContatos();

        contatos.remove(c);

        arquivoContato.salvaContatos(contatos);
    }

    public Map<Character, List<Contato>> getAll(){
        limpaListaLocal();

        List<Contato> contatosNoFile = arquivoContato.leContatos();

            for(Character letra : listaDeContatos.keySet()){

                for(Contato contato : contatosNoFile){

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
