package Exemplos.JTabbledPane;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class ExemploJTabbledPane extends JTabbedPane {
    
    public ExemploJTabbledPane(){
        this.addTab("Aba 1", new JPanel());
        this.addTab("Aba 2", new JPanel());
        this.addTab("Aba 3", new JPanel());
    }
}
