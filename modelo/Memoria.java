package sistemasExpertos.modelo;

import jess.*;
import java.util.ArrayList;

public class Memoria {
    private Rete memoria; 
    public Memoria() {
        memoria = new Rete();
    }
    
    public ArrayList<String> Evaluar(String fact) {
        String consulta = "(deffacts ordenes (orden (voz \"";
        consulta = consulta.concat(fact);
        consulta = consulta.concat("\") (estado FALSE) (escuadra 1) (arma sinArma)))"); 
        System.out.println(consulta);
        try {
            memoria.eval("(clear)");
            defineTemplate();

            memoria.eval(consulta);
            defineConocimiento();
            memoria.eval("(reset)");
            memoria.eval("(focus ordenar)");
            int count = memoria.run();
            System.out.println("CANTIDAD: " + count);
            ArrayList<String> action = new ArrayList<String>();
            if( count > 0 ){
                action = (ArrayList<String>)memoria.getGlobalContext().getVariable("*list*").javaObjectValue(null);
                System.out.println("ACTION : " + action.size());
                for(int i=0; i<action.size(); i++) {
                    System.out.println("VALUE: " + action.get(i));
                }
            } else {
                System.out.println("NO ACTION");
            }     
            return action;
        } catch (JessException ex) {
            System.out.println(ex);
            return (new ArrayList<String>());
        }
    }

    private void defineTemplate() throws JessException {
            memoria.eval("(batch ../reglas/template.clp)");
    }

    private void defineConocimiento() throws JessException {
            memoria.eval("(batch ../reglas/ordencerrado.clp)");
    }
}
