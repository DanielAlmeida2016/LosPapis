package br.com.lospapis.service;

import java.util.StringTokenizer;

import br.com.lospapis.model.Jogador;
import br.com.lospapis.rest.JogadorRest;

/**
 * Created by Daniel Almeida on 12/11/2017.
 */

public class JogadorService {

    private JogadorRest jogadorRest;

    public JogadorService(){
        jogadorRest = new JogadorRest();
    }

    public Jogador getJogador(String urlBase, int id) throws Exception{
        return jogadorRest.get(urlBase, id);
    }
}
