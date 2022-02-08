package Exemplos.Layouts.Layout_BorderLayout;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class ExemploBorderLayout extends JFrame{
    public ExemploBorderLayout(){
        setTitle("Exemplo");
        setSize(300, 300);
        setLocation(50, 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }
}
