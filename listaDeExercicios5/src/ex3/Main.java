package ex3;

public class Main {
    static SistemaArquivos sistema = new SistemaArquivos();
    public static void main(String[] args) {
        instanciaArquivos();

        System.out.print(sistema);
    }
    private static void instanciaArquivos() {
        try {
            sistema.criarMusica("Lo-fi Compilation", "Area de Trabalho", 55);
            sistema.criarVideo("Arcane: Season 2 Announcement", "Area de Trabalho", Qualidade.QualidadeDe720p);
            sistema.criarDocumento("Lista de Afazeres", "Area de Trabalho", "Limpar chão");
            sistema.criarDocumento("Tarefa de EDA1", "Tarefas", "Entrega do código 5");
            sistema.criarDocumento("Tarefa de POO", "Tarefas", "Aula Prática 10");

        } catch (NomeInvalidoException e) {
            System.err.printf(e.getMessage());
        }

    }
}
