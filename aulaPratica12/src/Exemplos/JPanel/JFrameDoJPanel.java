package Exemplos.JPanel;

import javax.swing.JFrame;

public class JFrameDoJPanel extends JFrame {
    
    public JFrameDoJPanel(){
        setTitle("Exemplo de JPanel");
        setBounds(50, 50, 300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        JFrameDoJPanel exemplo = new JFrameDoJPanel();
        exemplo.add(new ExemploJPanel());
        exemplo.setVisible(true);

    }
}
