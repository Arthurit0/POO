package ex3;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SistemaArquivos {
    Map<String, List<Arquivo>> diretorios = new HashMap<String, List<Arquivo>>();

    public void criarDocumento(String nome, String diretorio, String texto) throws NomeInvalidoException{
        try {
            Documento documento = new Documento(nome);

            documento.setTexto(texto);
            
            if(VerificaDiretorio(diretorio)){
                List<Arquivo> local = diretorios.get(diretorio);

                local.add(documento);
            }else{
                List<Arquivo> novoLocal = new LinkedList<Arquivo>();

                diretorios.put(diretorio, novoLocal);

                novoLocal.add(documento);
            }

        } catch (NomeInvalidoException e) {
            throw e;
        }

    }

    public void criarMusica(String nome, String diretorio, int duracao) throws NomeInvalidoException{
        try {
            Musica musica = new Musica(nome);

            musica.setDuracao(duracao);
            
            if(VerificaDiretorio(diretorio)){
                List<Arquivo> local = diretorios.get(diretorio);

                local.add(musica);
            }else{
                List<Arquivo> novoLocal = new LinkedList<Arquivo>();

                diretorios.put(diretorio, novoLocal);

                novoLocal.add(musica);
            }

        } catch (NomeInvalidoException e) {
            throw e;
        }

    }

    public void criarVideo(String nome, String diretorio, Qualidade qualidade) throws NomeInvalidoException{
        try {
            Video video = new Video(nome);

            video.setQualidade(qualidade);
            
            if(VerificaDiretorio(diretorio)){
                List<Arquivo> local = diretorios.get(diretorio);

                local.add(video);
            }else{
                List<Arquivo> novoLocal = new LinkedList<Arquivo>();

                diretorios.put(diretorio, novoLocal);

                novoLocal.add(video);
            }

        } catch (NomeInvalidoException e) {
            throw e;
        }

    }

    private boolean VerificaDiretorio(String diretorio) {
        for (String dir : diretorios.keySet()) {
            if(diretorio.equals(dir)){
                return true;
            }
        }

        return false;
    }

    public String toString() {
        String str = "";

        for (String pasta : diretorios.keySet()) {
            str += pasta+":\n\n";

            List<Arquivo> listaNoDiretorio = diretorios.get(pasta);

            for (Arquivo file : listaNoDiretorio) {
                str += file+"\n\n";
            }


        }

        return str;

    }
}
