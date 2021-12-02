package Ex3;

public class Main {
    public static void main(String[] args) {
        Digrafo digrafo = new Digrafo();
        Grafo grafo = new Grafo();

        grafo.adicionarVertice();
        grafo.adicionarVertice();
        grafo.adicionarVertice();
        grafo.adicionarVertice();

        digrafo.adicionarVertice();
        digrafo.adicionarVertice();
        digrafo.adicionarVertice();
        digrafo.adicionarVertice();


        System.out.println("=> Grafo Vazio:\n");
        System.out.println(grafo.toString());
        System.out.println("=> Digrafo Vazio:\n");
        System.out.println(digrafo.toString());

        testeAdicionarArestas(digrafo);
        testeAdicionarArestas(grafo);

        System.out.println("==> Executando mesmas operações em ambos:\n");

        System.out.println("=> Grafo:\n");
        System.out.println(grafo.toString());

        System.out.println("=> Digrafo:\n");
        System.out.println(digrafo.toString());

    }

    private static void testeAdicionarArestas(Digrafo digrafo) {
        digrafo.adicionarAresta(0, 1);
        digrafo.adicionarAresta(0, 2);
        digrafo.adicionarAresta(1, 1);
        digrafo.adicionarAresta(1, 3);
        digrafo.adicionarAresta(2, 0);
        digrafo.adicionarAresta(2, 1);
        digrafo.adicionarAresta(2, 3);
        digrafo.adicionarAresta(3, 4);
        digrafo.adicionarAresta(4, 1);
    }
}
