package Exemplos.JTabbledPane;

import javax.swing.JFrame;

public class Principal extends JFrame{
    public Principal(){
        setTitle("Exemplo de Tabbled Panes");
        setBounds(50, 50, 300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Principal exemplo = new Principal();
        exemplo.add(new ExemploJTabbledPane());
        exemplo.setVisible(true);
    }
}
