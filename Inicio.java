package sistemasExpertos;

import sistemasExpertos.modelo.*;

public class Inicio {
    public static void main(String[] unused) {
        Memoria mem = new Memoria();
        mem.Evaluar("(deffacts ordenes (orden (voz \"atencion-fir\") (estado FALSE) (escuadra 1) (arma sinArma)))");
        mem.Evaluar("(deffacts ordenes (orden (voz \"a discresion\") (estado TRUE) (escuadra 2) (arma fal)))");
    }
}
