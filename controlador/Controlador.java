package sistemasExpertos.controlador;

import sistemasExpertos.modelo.*;
import sistemasExpertos.vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador {

    private Memoria memoria;
    private Sistema sistema;

    public Controlador(Memoria mem, Sistema sis) {
        memoria = mem;
        sistema = sis;

        sis.addButtonListener(new ActionListener(){
            public void actionPerformed(ActionEvent event) {
                sis.getConsulta();
                System.out.println(sis.getConsulta());
                mem.Evaluar(sis.getConsulta());
            }
        });

    }

}
