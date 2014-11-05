;;;;; TEMPLATE ;;;;;
;;; Definicion de plantillas (deftemplates)

(deftemplate orden
    (slot voz       (type SYMBOL)   (default ""))
    (slot estado    (type SYMBOL)   (allowed-values al_paso a_la_carrera tendido))
    (slot escuadra  (type NUMBER)   (default 1))
    (slot arma      (type SYMBOL)   (default sinArma)   (allowed-values sinArma mauser fal))
)
