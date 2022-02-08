package Exemplos.JLabel_Imagens;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExemploImagem extends JPanel{
    public ExemploImagem(){
        JLabel imagem = new JLabel(new ImageIcon("C:\\Users\\arthu\\Desktop\\GitHub\\POO\\aulaPratica12\\Udesc.jpg"));
        add(imagem);
    }
}
