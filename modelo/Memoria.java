package sistemasExpertos.modelo;

import jess.*;
import java.util.ArrayList;

public class Memoria {
    private Rete memoria; 
    public Memoria() {
        memoria = new Rete();
    }
    
    public ArrayList<String> Evaluar(String fact, String arma) {
        String consulta = "(deffacts ordenes (orden (voz \"";
        consulta = consulta.concat(fact);
        consulta = consulta.concat("\") (estado al_paso) (escuadra 1) (arma ");
        consulta = consulta.concat(arma);
        consulta = consulta.concat(")))");
        
        System.out.println(consulta);
        try {
            memoria.eval("(clear)");
            defineTemplate();

            memoria.eval(consulta);
            defineConocimiento();
            memoria.eval("(reset)");
            memoria.eval("(focus ordenar)");
            int count = memoria.run();
            ArrayList<String> action = new ArrayList<String>();
            if( count > 0 ){
                action = (ArrayList<String>)memoria.getGlobalContext().getVariable("*list*").javaObjectValue(null);
                System.out.println("ACTION : " + action.size());
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
