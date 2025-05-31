package org.example;

import static org.mockito.Mockito.mock;

import java.util.List;
import org.example.borrador.Borrador;
import org.example.prenda.Color;
import org.example.prenda.Formalidad;
import org.example.prenda.Material;
import org.example.prenda.Prenda;
import org.example.prenda.Tipo;
import org.example.sugerencia.MotorSugerencias;
import org.example.sugerencia.ProveedorDeMotor;
import org.example.sugerencia.Sugerencia;
import org.example.sugerencia.SugerenciaCombinaciones;
import org.example.sugerencia.SugerenciasSegunFormalidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SugerenciasTest {

  Usuario usuario;

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


    usuario = new Usuario(List.of(zapatoNegroDeCuero, zapatoDeTelaAmarilla, pantalonNegro, camisaBlanca), 60, new SugerenciaCombinaciones());

  }


  @Test
  void guardarropasConPrendas(){
    Assertions.assertFalse(usuario.getGuardarropa().isEmpty());
  }

  @Test
  void seGenerarSugerencias(){
    usuario.setMotor(new SugerenciaCombinaciones());
    List<Sugerencia> sugerencias = usuario.generarSugerencias();
    Assertions.assertFalse(sugerencias.isEmpty());
  }

  @Test
  void seGeneranSugerenciasSegunMotorDeSugerenciasAleatorias(){
    usuario.setMotor(new SugerenciaCombinaciones());
    List<Sugerencia> sugerencias = usuario.generarSugerencias();
    Assertions.assertEquals(2, sugerencias.size());
  }

  @Test
  void seGeneranSugerenciasSegunMotorDeFormalidad(){
    usuario.setMotor(new SugerenciasSegunFormalidad());
    List<Sugerencia> sugerencias = usuario.generarSugerencias();
    Assertions.assertEquals(1, sugerencias.size());
  }
}
