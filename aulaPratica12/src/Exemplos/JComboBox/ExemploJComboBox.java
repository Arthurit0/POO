package Exemplos.JComboBox;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class ExemploJComboBox extends JPanel{
    public ExemploJComboBox(){
        String[] items = new String[] {"Escolha 1", "Escolha 2"};
        JComboBox<String> comboBox = new JComboBox<String>(items);
        add(comboBox);
    }
}
