package Exemplos.Layouts.Layout_NullLayout;

import javax.swing.JButton;

public class Principal {
    public static void main(String[] args) {
        ExemploNullLayout exemplo = new ExemploNullLayout();
        exemplo.setVisible(true);

        JButton botao1 = new JButton("Botão 1");
        botao1.setBounds(50, 50, 100, 20);
        exemplo.add(botao1);

        JButton botao2 = new JButton("Botão 2");
        botao2.setBounds(120, 80, 100, 20);
        exemplo.add(botao2);

        JButton botao3 = new JButton("Botão 3");
        botao3.setBounds(85, 110, 100, 20);
        exemplo.add(botao3);
    }
}
