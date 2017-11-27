package br.com.lospapis.service;

import br.com.lospapis.model.Usuario;
import br.com.lospapis.rest.UsuarioRest;

/**
 * Created by Daniel Almeida on 12/11/2017.
 */

public class UsuarioService {

    private UsuarioRest usuarioRest;

    public UsuarioService(){
        usuarioRest = new UsuarioRest();
    }

    public Usuario getUsuario(String urlBase, String usuario, String senha) throws Exception{
        return usuarioRest.get(urlBase, usuario, senha);
    }
}
