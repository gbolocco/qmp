package org.example.domain.PropuestaModificacion;

import org.example.domain.Guardarropa.Guardarropa;
import org.example.domain.prenda.Prenda;

public class PropuestaAgregarPrenda extends PropuestaGuardarropa {

    public PropuestaAgregarPrenda(Prenda prenda) {
        super(prenda);
    }

    public void aceptar(Guardarropa guardarropa){
        guardarropa.addPrenda(prenda);
    }

    public void rechazar(Guardarropa guardarropa){}
}
