package ex1e2;

public class MainMercado {
    public static void main(String[] args) {
        Comida comida1 = new Comida("Batata", "Vegetal", "21/12/2021");
        Jogo jogo1 = new Jogo("The Witcher 3", "RPG", "CD Projekt RED");
        Movel movel1 = new Movel("Cadeira", "Madeira", "Arthur interiores");
        Roupa roupa1 = new Roupa("Camisa", "Cinza", "Gucci");
        Revista revista1 = new Revista("Super Interessante", "Divulgação Científica", "Abril");


        System.out.println("=====================================================\n");
        System.out.println(comida1+"\n");
        System.out.println(jogo1+"\n");
        System.out.println(movel1+"\n");
        System.out.println(roupa1+"\n");
        System.out.println(revista1+"\n");

        Comida comida2 = new Comida("Frango");
        Jogo jogo2 = new Jogo("Deltarune");
        Movel movel2 = new Movel("Lustre");
        Roupa roupa2 = new Roupa("Meia");
        Revista revista2 = new Revista("Veja");
        
        System.out.println("=====================================================\n");
        System.out.println(comida2+"\n");
        System.out.println(jogo2+"\n");
        System.out.println(movel2+"\n");
        System.out.println(roupa2+"\n");
        System.out.println(revista2+"\n");
        
        System.out.println("=====================================================\n");
    }
}
