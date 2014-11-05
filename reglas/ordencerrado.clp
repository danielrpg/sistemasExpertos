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

;(reset)
;(focus ordenar)
;(run)
