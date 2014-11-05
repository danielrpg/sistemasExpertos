package sistemasExpertos.vista;

import sistemasExpertos.modelo.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class Sistema extends JFrame {

    private JLabel label_consulta;
    private JButton button_consulta;
    private JTextField consulta;
    
    public Sistema() {
        setLayout(new BoxLayout(this.getContentPane(),BoxLayout.Y_AXIS));
        label_consulta = new JLabel("Voz de mando :");
        button_consulta = new JButton("Consultar");
        consulta = new JTextField();
        add(label_consulta);
        add(consulta);
        add(button_consulta);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void addButtonListener(ActionListener listener) {
        button_consulta.addActionListener(listener);
    }

    public String getConsulta() {
        return consulta.getText();
    }
    
}
