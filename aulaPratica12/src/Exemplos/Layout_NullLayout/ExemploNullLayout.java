package Exemplos.Layout_NullLayout;

import javax.swing.JFrame;

public class ExemploNullLayout extends JFrame{
    public ExemploNullLayout(){
        setTitle("Exemplo");
        setSize(300, 300);
        setLocation(50, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
    }
}
