package br.com.lospapis.service;

import android.content.Context;

import br.com.lospapis.dao.UsuarioDAO;
import br.com.lospapis.model.Usuario;
import br.com.lospapis.rest.UsuarioRest;
import br.com.lospapis.util.TesteConectividade;

/**
 * Created by Daniel Almeida on 12/11/2017.
 */

public class UsuarioService {

    private UsuarioRest usuarioRest;
    private UsuarioDAO usuarioDAO;

    public UsuarioService() {
        usuarioRest = new UsuarioRest();
        usuarioDAO = new UsuarioDAO();
    }

    public Usuario login(Context context, String urlBase, String usuarioS, String senha) throws Exception {

        Usuario usuario;

        if (TesteConectividade.isConnected(context)) {
            usuario = usuarioRest.get(urlBase, usuarioS, senha);
            usuarioDAO.atualizarDados(context, usuario);
        } else {
            usuario = usuarioDAO.buscarUsuario(context, usuarioS, senha);
        }
        return usuario;
    }
}
