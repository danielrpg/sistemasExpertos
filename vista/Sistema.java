package sistemasExpertos.vista;

import sistemasExpertos.modelo.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

public class Sistema extends JFrame {

    private JLabel label_consulta;
    private JButton button_consulta;
    private JTextField consulta;
    private JPanel center;
    
    public Sistema() {
        setLayout(new BorderLayout());
        JPanel superior = new JPanel();
        superior.setLayout(new BoxLayout(superior,BoxLayout.X_AXIS));
        label_consulta = new JLabel("Voz de mando :");
        button_consulta = new JButton("Consultar");
        consulta = new JTextField();
        superior.add(label_consulta);
        superior.add(consulta);
        superior.add(button_consulta);
        add(superior, BorderLayout.NORTH);
        setPreferredSize(new Dimension(400,200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    public void addButtonListener(ActionListener listener) {
        button_consulta.addActionListener(listener);
    }

    public String getConsulta() {
        return consulta.getText();
    }

    public void addPanel(ArrayList<String> pasos) {
        center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.PAGE_AXIS));
        for(int i=0; i< pasos.size(); i++) {
            center.add(new JLabel(i + ".- " + pasos.get(i)));
        }
        this.add(center, BorderLayout.CENTER);
        System.out.println("Chevere");
        this.revalidate();
    }   
}
