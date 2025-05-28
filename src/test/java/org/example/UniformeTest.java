package org.example;

// holaaa

import java.util.List;
import org.example.uniformesBonusQMP2.Institucion;
import org.example.uniformesBonusQMP2.Uniforme;
import org.example.uniformesBonusQMP2.criteriosUniforme.CriterioColor;
import org.example.uniformesBonusQMP2.criteriosUniforme.CriterioMaterial;
import org.example.uniformesBonusQMP2.criteriosUniforme.CriterioUniforme;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*; // ← ¡esto es clave!








class UniformeTest {

  List<CriterioUniforme> criteriosJhonson;
  List<Prenda> uniformeJhonson;
  List<Prenda> uniformeSanJuan;

  @BeforeEach
  void setUp() {

    // SAN JUAN
    Prenda zapatillasBlancas = new Prenda.Builder(Prenda.Tipo.ZAPATO, new Material(Material.TipoMaterial.CUERO)).setColorPrimario(Prenda.Color.BLANCO).build();
    Prenda chombaVerde = new Prenda.Builder(Prenda.Tipo.CHOMBA, new Material(Material.TipoMaterial.TELA,Material.Trama.PIQUE)).setColorPrimario(Prenda.Color.VERDE).build();
    Prenda pantalonAcetatoGris = new Prenda.Builder(Prenda.Tipo.PANTALON, new Material(Material.TipoMaterial.ACETATO)).setColorPrimario(Prenda.Color.GRIS).build();

    CriterioColor sanJuan1 = new CriterioColor(Prenda.Tipo.CHOMBA, Prenda.Color.VERDE);
    CriterioMaterial sanJuan2 = new CriterioMaterial(Prenda.Tipo.ZAPATO, Material.TipoMaterial.CUERO);
    CriterioColor sanJuan3 = new CriterioColor(Prenda.Tipo.CAMISA, Prenda.Color.GRIS);
    CriterioColor sanJuan4 = new CriterioColor(Prenda.Tipo.CAMISA, Prenda.Color.BLANCO);

    List<CriterioUniforme> criteriosSanJuan = List.of(sanJuan1, sanJuan2, sanJuan3, sanJuan4);
    List<Prenda> uniformeSanJuan = List.of(zapatillasBlancas, chombaVerde, pantalonAcetatoGris);


    // JHONSON
    Prenda camisaBlanca = new Prenda.Builder(Prenda.Tipo.CAMISA, new Material(Material.TipoMaterial.TELA)).setColorPrimario(Prenda.Color.BLANCO).build();
    Prenda pantalonDeVestirNegro = new Prenda.Builder(Prenda.Tipo.PANTALON, new Material(Material.TipoMaterial.DE_VESTIR)).setColorPrimario(Prenda.Color.NEGRO).build();
    Prenda zapatosNegros = new Prenda.Builder(Prenda.Tipo.ZAPATO,new Material(Material.TipoMaterial.CUERO)).setColorPrimario(Prenda.Color.NEGRO).build();


    CriterioColor jhonson1 = new CriterioColor(Prenda.Tipo.CAMISA, Prenda.Color.BLANCO);
    CriterioMaterial jhonson2 = new CriterioMaterial(Prenda.Tipo.PANTALON, Material.TipoMaterial.TELA);
    CriterioColor jhonson3 = new CriterioColor(Prenda.Tipo.ZAPATO, Prenda.Color.NEGRO);
    CriterioColor jhonson4 = new CriterioColor(Prenda.Tipo.PANTALON, Prenda.Color.NEGRO);

    List<CriterioUniforme> criteriosJhonson = List.of(jhonson1, jhonson2, jhonson3, jhonson4);
    List<Prenda> uniformeJhonson = List.of(camisaBlanca, pantalonDeVestirNegro, zapatosNegros);


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