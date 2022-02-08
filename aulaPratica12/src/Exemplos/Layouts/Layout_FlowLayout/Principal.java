package Exemplos.Layouts.Layout_FlowLayout;

import javax.swing.JButton;

public class Principal {
    public static void main(String[] args) {
        ExemploFlowLayout exemplo = new ExemploFlowLayout();
        exemplo.setVisible(true);

        JButton botao1 = new JButton("Botão 1");
        exemplo.add(botao1);

        JButton botao2 = new JButton("Botão 2");
        exemplo.add(botao2);

        JButton botao3 = new JButton("Botão 3");
        exemplo.add(botao3);

        JButton botao4 = new JButton("Botão 4");
        exemplo.add(botao4);

        JButton botao5 = new JButton("Botão 5");
        exemplo.add(botao5);
    }
}
