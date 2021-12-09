package exercicio2.persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.LinkedList;
import java.util.List;

public class EditorTexto {
    
    public List<String> leTexto(String caminho){
        List<String> dados = new LinkedList<String>();
        FileReader arq; BufferedReader leArq;

        try {
            arq = new FileReader(caminho);
            leArq = new BufferedReader(arq);
            String str = leArq.readLine();

            while(str != null){
                dados.add(str);
                str = leArq.readLine();
            }

            arq.close();

        } catch (Exception e) {
            System.err.println("Erro ao manipular o arquivo");
            System.exit(0);
        }

        return dados;
    }

    public void gravaTexto(String caminho, List<String> dados){
        FileWriter arq;

        try {
            arq = new FileWriter(caminho);

            for (String i : dados) {
                arq.write(i + "\n");
            }

            arq.close();

        } catch (Exception e) {
            System.err.println("Erro ao manipular o arquivo");
            System.exit(0);
        }
    }

    public void gravaTexto(String caminho, String dado){
        FileWriter arq;

        try {
            arq = new FileWriter(caminho, true);
            arq.write(dado + "\n");

            arq.close();

        } catch (Exception e) {
            System.err.println("Erro ao manipular o arquivo");
            System.exit(0);
        }
    }
}
