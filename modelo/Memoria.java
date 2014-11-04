package sistemasExpertos.modelo;

import jess.*;

public class Memoria {
    private Rete memoria; 
    public Memoria() {
        memoria = new Rete();
    }
    
    public boolean Evaluar(String fact) {
        try {
            memoria.eval("(clear)");
            defineTemplate();
            memoria.eval(fact);
            defineConocimiento();
            memoria.eval("(reset)");
            memoria.eval("(focus ordenar)");
            int count = memoria.run();
            System.out.println("CANTIDAD: " + count);
            if( count > 0 ){
                String action = memoria.getGlobalContext().getVariable("*var*").stringValue(null);
                System.out.println("ACTION : " + action);
            } else {
                System.out.println("NO ACTION");
            }     
            return true;
        } catch (JessException ex) {
            System.out.println(ex);
            return false;
        }
    }

    private void defineTemplate() throws JessException {
            memoria.eval("(batch ../reglas/template.clp)");
    }

    private void defineConocimiento() throws JessException {
            memoria.eval("(batch ../reglas/ordencerrado.clp)");
    }
}
