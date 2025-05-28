package org.example;

// holaaa

import java.util.List;
import org.example.borrador.Borrador;
import org.example.prenda.Color;
import org.example.prenda.Material;
import org.example.prenda.Prenda;
import org.example.prenda.Tipo;
import org.example.uniformesBonusQMP2.Institucion;
import org.example.uniformesBonusQMP2.Uniforme;
import org.example.uniformesBonusQMP2.criteriosUniforme.CriterioColor;
import org.example.uniformesBonusQMP2.criteriosUniforme.CriterioMaterial;
import org.example.uniformesBonusQMP2.criteriosUniforme.CriterioUniforme;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.*; // ← ¡esto es clave!








class UniformeTest {

  List<CriterioUniforme> criteriosJhonson;
  List<CriterioUniforme> criteriosSanJuan;
  List<Prenda> uniformeJhonson;
  List<Prenda> uniformeSanJuan;
  List<Prenda> uniformeNoValido;

  @BeforeEach
  void setUp() {

    // SAN JUAN
    Prenda zapatillasBlancas = new Borrador(Tipo.ZAPATO, new Material(Material.TipoMaterial.CUERO)).setColorPrimario(Color.BLANCO).crearPrenda();
    Prenda chombaVerde = new Borrador(Tipo.CHOMBA, new Material(Material.TipoMaterial.TELA,Material.Trama.PIQUE)).setColorPrimario(Color.VERDE).crearPrenda();
    Prenda pantalonAcetatoGris = new Borrador(Tipo.PANTALON, new Material(Material.TipoMaterial.ACETATO)).setColorPrimario(Color.GRIS).crearPrenda();

    CriterioColor sanJuan1 = new CriterioColor(Tipo.CHOMBA, Color.VERDE);
    CriterioMaterial sanJuan2 = new CriterioMaterial(Tipo.ZAPATO, Material.TipoMaterial.CUERO);
    CriterioColor sanJuan3 = new CriterioColor(Tipo.CAMISA, Color.GRIS);
    CriterioColor sanJuan4 = new CriterioColor(Tipo.CAMISA, Color.BLANCO);

    criteriosSanJuan = List.of(sanJuan1, sanJuan2, sanJuan3, sanJuan4);
    uniformeSanJuan = List.of(zapatillasBlancas, chombaVerde, pantalonAcetatoGris);


    // JHONSON
    Prenda camisaBlanca = new Borrador(Tipo.CAMISA, new Material(Material.TipoMaterial.TELA)).setColorPrimario(Color.BLANCO).crearPrenda();
    Prenda pantalonDeVestirNegro = new Borrador(Tipo.PANTALON, new Material(Material.TipoMaterial.DE_VESTIR)).setColorPrimario(Color.NEGRO).crearPrenda();
    Prenda zapatosNegros = new Borrador(Tipo.ZAPATO,new Material(Material.TipoMaterial.CUERO)).setColorPrimario(Color.NEGRO).crearPrenda();


    CriterioColor jhonson1 = new CriterioColor(Tipo.CAMISA, Color.BLANCO);
    CriterioMaterial jhonson2 = new CriterioMaterial(Tipo.PANTALON, Material.TipoMaterial.TELA);
    CriterioColor jhonson3 = new CriterioColor(Tipo.ZAPATO, Color.NEGRO);
    CriterioColor jhonson4 = new CriterioColor(Tipo.PANTALON, Color.NEGRO);

    criteriosJhonson = List.of(jhonson1, jhonson2, jhonson3, jhonson4);
    uniformeJhonson = List.of(camisaBlanca, pantalonDeVestirNegro, zapatosNegros);

    uniformeNoValido = List.of(chombaVerde, pantalonAcetatoGris); // solo tiene parte superior y parte inferior

  }

  @Test
  void uniformeNoValido(){
    assertThrows(IllegalArgumentException.class, () -> new Uniforme(uniformeNoValido));
  }

  @Test
  void validarUniformeJhonson_valido() {
    Institucion jhonson = new Institucion(criteriosJhonson);
    assertDoesNotThrow(() -> new Uniforme(uniformeJhonson, jhonson));

  }


  @Test
  void validarUniformeJhonson_invalidoFalla() {

    // Quitar un criterio para que falle
    Institucion jhonson = new Institucion(criteriosJhonson.subList(0, 2));

    assertThrows(IllegalArgumentException.class, () -> new Uniforme(uniformeJhonson, jhonson));
  }
}