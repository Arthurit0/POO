package Exemplos.JLabel_Imagens;

import javax.swing.JFrame;

public class Principal extends JFrame{
    public Principal() {
        setTitle("Exemplo");
        setBounds(50, 50, 800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        Principal exemplo = new Principal();
        exemplo.add(new ExemploImagem());
        exemplo.setVisible(true);
    }
}
