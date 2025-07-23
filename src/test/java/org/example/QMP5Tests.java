package org.example;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import org.example.domain.Guardarropa.Guardarropa;
import org.example.domain.Usuario;
import org.example.domain.prenda.Prenda;
import org.example.domain.sugerencia.MotorSugerencias;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QMP5Tests {

  Usuario propietario;
  Usuario colaborador;
  Prenda prenda;

  @BeforeEach
  public void setUp() throws Exception {

    propietario = new Usuario(20, mock(MotorSugerencias.class));

    propietario.crearGuardarropa("test", new ArrayList<>());

    colaborador = new Usuario(20, mock(MotorSugerencias.class));

    propietario.addColaborador(colaborador, "test");

    prenda =  mock(Prenda.class);

  }

  @Test
  public void seAgregaColaboradorYpuedeVisualizarGuardarropa() throws Exception {
    Assertions.assertFalse(propietario.getGuardarropaSegunCriterio("test").getColaboradores().isEmpty());
    Assertions.assertFalse(colaborador.getGuardarropas().isEmpty());
  }

  @Test
  public void propietarioPuedeRemoverAColaborador() throws Exception {
    propietario.removeColaborador(colaborador, "test");
    Assertions.assertTrue(propietario.getGuardarropaSegunCriterio("test").getColaboradores().isEmpty());
  }


  @Test
  void propietarioPuedeAgregarPrendaYBorrarla() throws Exception {
    Prenda prenda = mock(Prenda.class);
    propietario.addPrenda("test",prenda);
    Assertions.assertTrue(propietario.getGuardarropaSegunCriterio("test").getPrendas().contains(prenda));
    propietario.removePrenda("test", prenda);
    Assertions.assertFalse(propietario.getGuardarropaSegunCriterio("test").getPrendas().contains(prenda));
  }

  @Test
  void sePuedeAceptarPropuestaYAgregarUnaPrenda() throws Exception {
    Guardarropa guardarropa = new Guardarropa(mock(Usuario.class),"test",  new ArrayList<>());
    guardarropa.proponerAgregar(prenda);
    Assertions.assertTrue(guardarropa.getPrendas().isEmpty());
    guardarropa.getPropuestas().stream().findFirst().ifPresent(guardarropa::aceptar);
    Assertions.assertTrue(guardarropa.getPrendas().contains(prenda));
  }

  @Test
  void sePuedeaceptarPropuestaYRemoverUnaPrenda() throws Exception {
    Guardarropa guardarropa = new Guardarropa(mock(Usuario.class),"test", new ArrayList<>());
    guardarropa.addPrenda(prenda);
    guardarropa.proponerRemover(prenda);
    Assertions.assertFalse(guardarropa.getPrendas().isEmpty());
    guardarropa.getPropuestas().stream().findFirst().ifPresent(guardarropa::aceptar);
    Assertions.assertFalse(guardarropa.getPrendas().contains(prenda));
  }

  @Test
  void sePuedeDeshacerUnaModificacion(){
    Guardarropa guardarropa = new Guardarropa(mock(Usuario.class),"test",  new ArrayList<>());
    guardarropa.proponerAgregar(prenda);
    guardarropa.getPropuestas().stream().findFirst().ifPresent(guardarropa::aceptar);
    Assertions.assertTrue(guardarropa.getPrendas().contains(prenda));
    guardarropa.getPropuestasAceptadas().stream().findFirst().ifPresent(guardarropa::deshacer);
    Assertions.assertFalse(guardarropa.getPrendas().contains(prenda));
  }

}
