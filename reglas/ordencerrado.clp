;;;;; ORDEN CERRADO ;;;;;

;;; Definicion de plantillas (deftemplates)

;(deftemplate orden
;    (slot voz       (type SYMBOL)   (default ""))
;    (slot estado    (type SYMBOL)   (allowed-values TRUE FALSE))
;    (slot escuadra  (type NUMBER)   (default 1))
;    (slot arma      (type SYMBOL)   (default sinArma)   (allowed-values sinArma mauser fal))
;)

;(deffacts ordenes
;    (orden (voz "atencion-fir") (estado FALSE) (escuadra 1) (arma sinArma))
;    (orden (voz "a discresion") (estado TRUE) (escuadra 2) (arma fal))
;)

(defmodule ordenar) ;indica que tipo de orden es y que acciones tomar.
(defglobal ?*list* = (new java.util.ArrayList))

(bind ?*list* (new java.util.ArrayList)) 

(defrule atencion
    ?p <- (orden (voz "atencion-fir"))
    =>
    (?*list* add "Hizo atencion fir!!!")
    (?*list* add "paso de a discresion")
)
(defrule discresion
    ?p <- (orden (voz "a discresion") (escuadra ?e) )
    =>
    (?*list* add "Hizo a discresion Escuadra ")
    (?*list* add "Paso de atencion fir")
)
(defrule en-circulo-mar
    ?p <- (orden (voz "en-circulo-mar"))
    =>
    (?*list* add "Los soldados se mueven con paso vivo y forman un semicirculo.")
    (?*list* add "El primero que llega se coloca inmovil nueve pasos delante del superior que manda.")
    (?*list* add "Los demas conforme llegan se colocan alternativamente a derecha e izquierda de este formando el semicirculo.")
    (?*list* add "todos los soldados permanecen inmoviles hasta que el superior mande A discrecion.")
)

(defrule a-formar-en-linea-mar
    ?p <- (orden (voz "a-formar-en-linea-mar"))
    =>
    (?*list* add "El primer hombre se coloca cinco pasos frente al superior.")
    (?*list* add "El segundo hombre forma un asegunda fila colocandose ochenta centimetros de distancia del primer hombre de la primera fila.")
    (?*list* add "Los demas hombres se colocan a la izquierda del primer y segundo hombre, de la primera y segunda fila respectivamente.")
)

(defrule a-formar-de-uno-mar
    ?p <- (orden (voz "a-formar-en-de-uno-mar"))
    =>   
    (?*list* add "El primer soldado se coloca cinco pasos delante del que manda.")
    (?*list* add "Los demas hombres conforme llegan se situan unos detras de otros con ochenta centimetros de distancia.")
    (?*list* add "A la voz de Discrecion el ultimo hombre de la cola pasa a discrecion.")
)

(defrule a-formar-en-columnas-por-hilera-mar
    ?p <- (orden (voz "a-formar-en-columnas-por-hilera-mar"))
    =>   
    (?*list* add "Los dos primeros hombres que llegan se colocan cinco pasos al frente del que manda formando dos columnas.")
    (?*list* add "Los demas hombres conforme llegan se colocan detras de ambas columnas con ochenta centimetros de distancia.")
    (?*list* add "a la voz de discrecion el ultimo hombre de la columna izquierda pasa a discrecion.")
)

(defrule numerarse
    ?p <- (orden (voz "numerarse"))
    =>
    (?*list* add "El primer hombre gira con energia la cabeza a la izquierda.")
    (?*list* add "Pasa el numero ¡un! En voz alta.")
    (?*list* add "Vuelve la cabeza con energia.")
    (?*list* add "Los otros soldados pasan sucesivamente el numero que le corresponde.")
)

(defrule por-sus-funciones-nombrarse
    ?p <- (orden (voz "por-sus-funciones-nombrarse"))
    =>
    (?*list* add "Los soldados pasan la voz indicando en voz alta las funciones que desempeñan en la escuadra.")
    (?*list* add "O Los soldados pasan la voz indicando en voz alta las funciones que desempeñan en la escuadra seguidamente del numero que tienen en ella.")
)

(defrule el-primero-tres-al-fren
    ?p <- (orden (voz "el-primero-tres-al-fren"))
    =>
    (?*list* add "El primer hombre de la derecha avanza tres pasos, hace alto.")
    (?*list* add "Corrige su posicion (posicion firmes) Permaneciendo inmovil con la vista al frente hasta que el comandante de escuadra vuelve a mandar diciendo: 'El siguiente alinee-¡ar!'.")
    (?*list* add "El segundo soldado dirige la vista hacia la cabeza del primer hombre.")
    (?*list* add "a la ejecutiva de “ar”.")
    (?*list* add "Se coloca rapidamente a la izquierda del primer hombre.")
    (?*list* add "Los demas hombres hacen lo mismo.")
)

(defrule soldado-x-tres-al-fren
    ?p <- (orden (voz "soldado-x-tres-al-fren")) 
    =>
    (?*list* add "El comandante de escuadra vuelve a mandar: 'Soldado X, alinee-¡ar!'.")
    (?*list* add "Corrige su posicion (posicion firmes) Permaneciendo inmovil con la vista al frente hasta que el comandante de escuadra vuelve a mandar diciendo: 'El siguiente vista a la izquier alinee-¡ar!'.")
    (?*list* add "El soldado de la derecha dirige la vista hacia la cabeza del primer hombre")
    (?*list* add "a la ejecutiva de 'ar'.")
    (?*list* add "Se coloca rapidamente a la derecha del primer hombre.")
    (?*list* add "Los demas hombres hacen lo mismo.")
)

(defrule el-primero-de-la-izquierda-tres-al-fren
    ?p <- (orden (voz "el-primero-de-la-izquierda-tres-al-fren"))
    =>
    (?*list* add "El primer hombre de la izquierda avanza tres pasos, hace alto.")
    (?*list* add "Corrige su posicion (posicion firmes) Permaneciendo inmovil con la vista al frente hasta que el comandante de escuadra vuelve a mandar diciendo: 'El siguiente vista a la izquier alinee-¡ar!'.")
    (?*list* add "El segundo soldado dirige la vista hacia la cabeza del primer hombre.")
    (?*list* add "a la ejecutiva de 'ar'.")
    (?*list* add "Se coloca rapidamente a la derecha del primer hombre.")
    (?*list* add "Los demas hombres hacen lo mismo.")
)

(defrule armar-la-bayoneta
    ?p <- (orden (voz "armar-la-bayoneta") (arma mauser))
    =>
    (?*list* add "el soldado descansa.")
    (?*list* add "se pone a discresion.")
    (?*list* add "arma la bayoneta.")
)

(defrule carguen-y-aseguren
    ?p <- (orden (voz "carguen-y-aseguren") (arma mauser) (estado al_paso))
    =>
    (?*list* add "Ir al paso.")
    (?*list* add "Pasar a posicion a discresion.")
    (?*list* add "baja la cabeza.") 
    (?*list* add "Arma el fusil mauser.")
    (?*list* add "pasa el fusil a la posicion inicial.")
    (?*list* add "lleva la vista al frente con energia.")
)

(defrule descarguen
    ?p <- (orden (voz "descarguen") (arma mauser) (estado al_paso))
    =>
    (?*list* add "Ir al paso.")
    (?*list* add "Ponerse de pie.")
    (?*list* add "Bajar la cabeza.")
    (?*list* add "Desarma el fusil mauser.")
    (?*list* add "Pasa el fusil a la posicion inicial.")
    (?*list* add "Lleva la vista al frente.")
)





;(reset)
;(focus ordenar)
;(run)
