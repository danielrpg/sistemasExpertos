;;;;; TEMPLATE ;;;;;
;;; Definicion de plantillas (deftemplates)

(deftemplate orden
    (slot voz       (type SYMBOL)   (default ""))
    (slot estado    (type SYMBOL)   (allowed-values TRUE FALSE))
    (slot escuadra  (type NUMBER)   (default 1))
    (slot arma      (type SYMBOL)   (default sinArma)   (allowed-values sinArma mauser fal))
)
