package apresentacao;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Janela extends JFrame implements ActionListener{

    JPanel painelPrincipal = new JPanel();
    JLabel userLabel = new JLabel("Login");
    JLabel passwordLabel = new JLabel ("Senha");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();


    public Janela(){
        setTitle("Sistema de Finanças");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 1280;
        int height = 720;
        setBounds(center.x - width / 2, center.y - height / 2, width, height);

        addPainelPrincipal();
        setLocationAndSize();
    }

    private void addPainelPrincipal() {
        painelPrincipal.setBackground(new java.awt.Color(230,251,255));
        setContentPane(painelPrincipal);
    }

    private void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    public static void main(String[] args) {
        Janela window = new Janela();

        window.setVisible(true);
    }



}
