package br.com.lospapis.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import br.com.lospapis.model.Jogador;

/**
 * Created by Daniel Almeida on 12/11/2017.
 */

public class JogadorDAO {

    public void inserirDados(SQLiteDatabase bd, Jogador jogador) {

        ContentValues valores = new ContentValues();

        valores.put(BancoDados.Tabela.COLUNA_JOGADOR_NOME, jogador.getNome());
        valores.put(BancoDados.Tabela.COLUNA_JOGADOR_POSICAO, jogador.getPosicao());
        valores.put(BancoDados.Tabela.COLUNA_JOGADOR_VALOR, jogador.getValor());
        valores.put(BancoDados.Tabela.COLUNA_JOGADOR_ATAQUE, jogador.getAtaque());
        valores.put(BancoDados.Tabela.COLUNA_JOGADOR_DEFESA, jogador.getDefesa());
        valores.put(BancoDados.Tabela.COLUNA_JOGADOR_ALTURA, jogador.getAltura());
        valores.put(BancoDados.Tabela.COLUNA_JOGADOR_PESO, jogador.getPeso());
        valores.put(BancoDados.Tabela.COLUNA_JOGADOR_COND_FISICA, jogador.getCond_fisica());
        valores.put(BancoDados.Tabela.COLUNA_JOGADOR_FORCA, jogador.getForca());
        valores.put(BancoDados.Tabela.COLUNA_JOGADOR_DRIBLE, jogador.getDrible());
        valores.put(BancoDados.Tabela.COLUNA_JOGADOR_DESARME, jogador.getDesarme());

        long id = bd.insert(BancoDados.Tabela.TABELA_JOGADOR, null, valores);
    }

    public void deletarDados(SQLiteDatabase bd) {
        bd.delete(BancoDados.Tabela.TABELA_JOGADOR, null, null);
    }

    public Jogador[] listarDados(Context context) {

        SQLiteDatabase bd = BancoDadosHelper.FabricaDeConexao.getConexaoLeitura(context);
        ArrayList<Jogador> retLista = new ArrayList<>();
        Jogador[] lista = null;
        Jogador jogador;
        Cursor c = null;
        String t = null;

        try {

            String[] selectColunasFrom = {BancoDados.Tabela._ID,
                    BancoDados.Tabela.COLUNA_JOGADOR_NOME,
                    BancoDados.Tabela.COLUNA_JOGADOR_POSICAO,
                    BancoDados.Tabela.COLUNA_JOGADOR_VALOR,
                    BancoDados.Tabela.COLUNA_JOGADOR_ATAQUE,
                    BancoDados.Tabela.COLUNA_JOGADOR_DEFESA,
                    BancoDados.Tabela.COLUNA_JOGADOR_ALTURA,
                    BancoDados.Tabela.COLUNA_JOGADOR_PESO,
                    BancoDados.Tabela.COLUNA_JOGADOR_COND_FISICA,
                    BancoDados.Tabela.COLUNA_JOGADOR_FORCA,
                    BancoDados.Tabela.COLUNA_JOGADOR_DRIBLE,
                    BancoDados.Tabela.COLUNA_JOGADOR_DESARME};


            c = bd.query(BancoDados.Tabela.TABELA_JOGADOR,
                    selectColunasFrom,
                    null,
                    null,
                    null,
                    null,
                    null
            );

            if (c.getCount() != 0) {
                while (c.moveToNext()) {
                    jogador = new Jogador();
                    jogador.setNome(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_JOGADOR_NOME)));
                    jogador.setPosicao(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_JOGADOR_POSICAO)));
                    jogador.setValor(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_JOGADOR_VALOR)));
                    jogador.setAtaque(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_JOGADOR_ATAQUE)));
                    jogador.setDefesa(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_JOGADOR_DEFESA)));
                    jogador.setAltura(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_JOGADOR_ALTURA)));
                    jogador.setPeso(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_JOGADOR_PESO)));
                    jogador.setCond_fisica(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_JOGADOR_COND_FISICA)));
                    jogador.setForca(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_JOGADOR_FORCA)));
                    jogador.setDrible(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_JOGADOR_DRIBLE)));
                    jogador.setDesarme(c.getInt(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_JOGADOR_DESARME)));

                    retLista.add(jogador);
                }
                lista = retLista.toArray(new Jogador[0]);
            } else {
                lista = new Jogador[0];
            }
        } catch (Exception e) {
            lista = new Jogador[0];
        } finally {
            if (c != null) {
                c.close();
            }
        }

        return lista;
    }
}
