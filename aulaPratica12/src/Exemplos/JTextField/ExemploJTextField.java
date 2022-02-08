package Exemplos.JTextField;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExemploJTextField extends JPanel{
    public ExemploJTextField() {
        JTextField textField = new JTextField();
        textField.setColumns(10);
        add(textField);
    }
}
