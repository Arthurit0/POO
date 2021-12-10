package ex1;

public class Multiplicacao extends Soma {
    @Override
    public int executar(int valor1, int valor2) {
        int resultado = 0;

        for (int i = 0; i < valor1; i++) {
            resultado = super.executar(resultado, valor2);
        }

        return resultado;
    }
}
