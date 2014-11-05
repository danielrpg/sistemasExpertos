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
    private JComboBox lista;
    private JComboBox armas;
    
    public Sistema() {
        setLayout(new BorderLayout());
        String[] lista_nombres = {"en-circulo-mar",
            "a-formar-en-linea-mar",
            "a-formar-en-de-uno-mar",
            "a-formar-en-columnas-por-hilera-mar",
            "numerarse",
            "por-sus-funciones-nombrarse",
            "el-primero-tres-al-fren",
            "soldado-x-tres-al-fren",
            "el-primero-de-la-izquierda-tres-al-fren",
            "armar-la-bayoneta",
            "armar-la-bayoneta",
            "carguen-y-aseguren",
            "descarguen"
        };

        String[] lista_armas = {"sinArma", "mauser", "fal"};
        String[] lista_estados = {"al_paso", "a_la_carrera", "tendido", "de_pie"};

        lista = new JComboBox(lista_nombres);
        armas = new JComboBox(lista_armas);

        JPanel superior = new JPanel();
        superior.setLayout(new BoxLayout(superior,BoxLayout.X_AXIS));
        label_consulta = new JLabel("Voz de mando :");
        button_consulta = new JButton("Consultar");
        consulta = new JTextField();
        superior.add(label_consulta);
        superior.add(lista);
        superior.add(armas);
        //superior.add(consulta);
        superior.add(button_consulta);
        add(superior, BorderLayout.NORTH);
        setPreferredSize(new Dimension(800,200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }

    public void addButtonListener(ActionListener listener) {
        button_consulta.addActionListener(listener);
    }

    public String getConsulta() {
        return (String)lista.getSelectedItem();
    }
    
    public String getArma() {
        return (String)armas.getSelectedItem();
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
