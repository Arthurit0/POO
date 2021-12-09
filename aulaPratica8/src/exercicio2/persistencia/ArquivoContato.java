package exercicio2.persistencia;

import java.util.LinkedList;
import java.util.List;

import exercicio2.dados.Contato;

public class ArquivoContato {
    private final String caminho = "aulaPratica8\\src\\exercicio2\\z listaDeContatos\\contatos.csv";
    private static EditorTexto editorTexto = new EditorTexto();

    private String toCSV(Contato c){
        String str = "";

        str += c.getNome()+", ";
        str += c.getTelefone();

        return str;
    }

    private Contato fromCSV(String s){
        String[] atributos = s.split(", ");
        Contato contato = new Contato();

        contato.setNome(atributos[0]);
        contato.setTelefone(Integer.parseInt(atributos[1]));

        return contato;
    }

    private List<Contato> StringsToContatos(List<String> file){
        List<Contato> contatos = new LinkedList<Contato>();
        
        return contatos;
    }
}
