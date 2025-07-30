package org.example.domain.usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {

  private static UsuarioRepository instance;

  private UsuarioRepository() {}

  public static UsuarioRepository getInstance() {
    return instance;
  }

  public List<Usuario> usuarios = new ArrayList<>();

  public List<Usuario> getUsuarios() {
    return usuarios;
  }

  public void generarSugerencias() {
//    usuarios.forEach(u ->  u.generarSugerencias());
  }

}
