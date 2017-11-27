package br.com.lospapis.service;

import br.com.lospapis.model.Loja;
import br.com.lospapis.rest.LojaRest;

/**
 * Created by Daniel Almeida on 12/11/2017.
 */

public class LojaService {

    private LojaRest lojaRest;

    public LojaService(){
        lojaRest = new LojaRest();
    }

    public Loja getJogadores(String urlBase, int id) throws Exception{
        return lojaRest.get(urlBase);
    }
}
