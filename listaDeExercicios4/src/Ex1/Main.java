package Ex1;

public class Main {
    public static void main(String[] args) {
        Cachorro cao = new Cachorro("Totó");
        Gato gato = new Gato("Garfield");
        Passaro ave = new Passaro("Jorge");
        Cachorro cao2 = new Cachorro("Fred");
        Gato gato2 = new Gato("Nora");
        Passaro ave2 = new Passaro("Bemtevi");

        System.out.println(cao.emitirSom());
        System.out.println(gato.emitirSom());
        System.out.println(ave.emitirSom());
        System.out.println(cao2.emitirSom());
        System.out.println(gato2.emitirSom());
        System.out.println(ave2.emitirSom());

        System.out.println();
        System.out.printf("Nome era "+cao.getNome());
        cao.setNome("Tototó");
        System.out.printf(" e agora será "+cao.getNome()+";");
        System.out.printf("\nNome era "+gato.getNome());
        gato.setNome("Garf");
        System.out.printf(" e agora será "+gato.getNome()+";");
        System.out.printf("\nNome era "+ave.getNome());
        ave.setNome("Jorgim");
        System.out.printf(" e agora será "+ave.getNome());

        System.out.println("\n");
        System.out.println("Testando mudança de nome: ");
        System.out.println(cao.emitirSom());
        System.out.println(gato.emitirSom());
        System.out.println(ave.emitirSom());

    }
}
