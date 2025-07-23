package org.example;

import static org.mockito.Mockito.mock;

import java.io.IOException;
import java.util.List;
import org.example.domain.Guardarropa.Guardarropa;
import org.example.domain.Usuario;
import org.example.domain.borrador.Borrador;
import org.example.domain.prenda.Color;
import org.example.domain.prenda.Formalidad;
import org.example.domain.prenda.Material;
import org.example.domain.prenda.Prenda;
import org.example.domain.prenda.Tipo;
import org.example.domain.sugerencia.Sugerencia;
import org.example.domain.sugerencia.SugerenciaCombinaciones;
import org.example.domain.sugerencia.SugerenciasSegunFormalidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QMP3Tests {

  Usuario usuario;
  Guardarropa guardarropa;

  @BeforeEach
  void setUp(){


    // tengo que settear el motor de sugerencias antes
    //ProveedorDeMotor.getInstance().setMotor(new SugerenciaCombinaciones());


    Borrador borradorZapatoFormal = new Borrador(Tipo.ZAPATO, new Material(Material.TipoMaterial.CUERO));
    borradorZapatoFormal.setColorPrimario(Color.NEGRO);
    borradorZapatoFormal.setFormalidad(Formalidad.FORMAL);
    Prenda zapatoNegroDeCuero = borradorZapatoFormal.crearPrenda();

    Borrador borradorZapatoInformal = new Borrador(Tipo.ZAPATO, new Material(Material.TipoMaterial.TELA));
    borradorZapatoInformal.setColorPrimario(Color.AMARILLO);
    borradorZapatoInformal.setFormalidad(Formalidad.INFORMAL);
    Prenda zapatoDeTelaAmarilla = borradorZapatoInformal.crearPrenda();

    Borrador borradorCamisa = new Borrador(Tipo.CAMISA, new Material(Material.TipoMaterial.TELA));
    borradorCamisa.setColorPrimario(Color.BLANCO);
    borradorCamisa.setFormalidad(Formalidad.FORMAL);
    Prenda camisaBlanca = borradorCamisa.crearPrenda();

    Borrador borradorPantalon = new Borrador(Tipo.PANTALON, new Material(Material.TipoMaterial.TELA));
    borradorPantalon.setColorPrimario(Color.BLANCO);
    borradorPantalon.setFormalidad(Formalidad.FORMAL);
    Prenda pantalonNegro = borradorPantalon.crearPrenda();


    usuario = new Usuario(69 , new SugerenciaCombinaciones());
    usuario.crearGuardarropa("test", List.of(zapatoNegroDeCuero, zapatoDeTelaAmarilla, pantalonNegro, camisaBlanca));

  }


  @Test
  void seAgregaGuardarropaAlUsuario(){
    Assertions.assertFalse(usuario.getGuardarropas().isEmpty());
  }

  @Test
  void guardarropasConPrendas(){
    Assertions.assertFalse(usuario.getGuardarropaSegunCriterio("test").getPrendas().isEmpty());
  }

  @Test
  void seGenerarSugerencias() throws Exception {
    usuario.setMotor(new SugerenciaCombinaciones());
    List<Sugerencia> sugerencias = usuario.generarSugerencias("test");
    Assertions.assertFalse(sugerencias.isEmpty());
  }

  @Test
  void seGeneranSugerenciasSegunMotorDeSugerenciasAleatorias() throws Exception {
    usuario.setMotor(new SugerenciaCombinaciones());
    List<Sugerencia> sugerencias = usuario.generarSugerencias("test");
    Assertions.assertEquals(2, sugerencias.size());
  }

  @Test
  void seGeneranSugerenciasSegunMotorDeFormalidad() throws Exception {
    usuario.setMotor(new SugerenciasSegunFormalidad());
    List<Sugerencia> sugerencias = usuario.generarSugerencias("test");
    Assertions.assertEquals(1, sugerencias.size());
  }
}
