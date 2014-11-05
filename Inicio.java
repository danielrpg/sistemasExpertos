package sistemasExpertos;

import sistemasExpertos.modelo.*;
import sistemasExpertos.vista.*;
import sistemasExpertos.controlador.*;

public class Inicio {
    public static void main(String[] unused) {
        Memoria mem = new Memoria();
        Sistema system = new Sistema();
        Controlador controller = new Controlador(mem, system);
        //mem.Evaluar("(deffacts ordenes (orden (voz \"atencion-fir\") (estado FALSE) (escuadra 1) (arma sinArma)))");
        //mem.Evaluar("(deffacts ordenes (orden (voz \"a discresion\") (estado TRUE) (escuadra 2) (arma fal)))");
    }
}
