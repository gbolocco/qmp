package org.example;

public class Prenda {

  public enum Color { ROJO, VERDE, AZUL, AMARILLO, VIOLETA, NEGRO, BLANCO, MARRON, NARANJA, ROSA, GRIS, NO_COLOR }

  public enum Tipo {                //Los enums son objetos que pueden tener comportamiento y atributos!!!!

    CAMISA(Categoria.PARTE_SUPERIOR),
    PANTALON(Categoria.PARTE_INFERIOR),
    ZAPATO(Categoria.CALZADO),
    CHOMBA(Categoria.PARTE_SUPERIOR),
    RELOJ(Categoria.ACCESORIO);

    // Atributo del enum
    private Categoria categoria;

    // Constructor
    Tipo(Categoria categoria) {
          this.categoria = categoria;
    }

    // Getter
    public Categoria getCategoria() {return categoria;}

    // Enum anidad(categorias)
    public enum Categoria {CALZADO, PARTE_SUPERIOR, PARTE_INFERIOR, ACCESORIO;}
  }


  private Tipo tipo;
  private Material material;
  private Color colorPrimario;
  private Color colorSecundario;

  //constructor
  private Prenda(Builder builder){
    this.tipo = builder.tipo;
    this.colorPrimario = builder.colorPrimario;
    this.colorSecundario = builder.colorSecundario;
    this.material = builder.material;
  }

  public static class Builder{
    final private Tipo tipo;
    final private Material material;
    private Color colorPrimario;
    private Color colorSecundario;

    public Builder(Tipo tipo, Material material){
      this.tipo = tipo;
      this.material = material;
    }

    public Builder setColorPrimario(Color colorPrimario){
      this.colorPrimario = colorPrimario;
      return this;
    }

    public Builder setColorSecundario(Color colorSecundario){
      this.colorSecundario = colorSecundario;
      return this;
    }

    public Prenda build(){
      return new Prenda(this);
    }
  }
  public Tipo getTipo() {
    return tipo;
  }

  public Color getColorPrimario() { return colorPrimario; }

  public Material.TipoMaterial getMaterial() { return material.tipoMaterial; }

}

// >> Prenda camisa = new Prenda(Tipo.CAMISA, Color.ROJO,null, Material.TELA);
