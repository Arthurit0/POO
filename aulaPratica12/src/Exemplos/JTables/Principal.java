package Exemplos.JTables;

import javax.swing.JFrame;

public class Principal extends JFrame{
    public Principal(){
        setTitle("Exemplo de Tabela");
        setBounds(50, 50, 300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Principal exemplo = new Principal();
        exemplo.add(new ExemploJTable());
        exemplo.setVisible(true);
    }
}