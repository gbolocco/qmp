package org.example;

import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import org.example.domain.Usuario;
import org.example.domain.prenda.Prenda;
import org.example.domain.sugerencia.MotorSugerencias;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QMP5Tests {

  Usuario propietario;
  Usuario colaborador;

  @BeforeEach
  public void setUp() throws Exception {

    propietario = new Usuario(20, mock(MotorSugerencias.class));

    propietario.crearGuardarropa("test", new ArrayList<>());

    colaborador = new Usuario(20, mock(MotorSugerencias.class));

    propietario.addColaborador(colaborador, "test");

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

}
