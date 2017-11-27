package br.com.lospapis.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import br.com.lospapis.model.Usuario;

/**
 * Created by Daniel Almeida on 12/11/2017.
 */

public class UsuarioDAO {

    public void inserirDados(SQLiteDatabase bd, Usuario usuario) {

        ContentValues valores = new ContentValues();

        valores.put(BancoDados.Tabela.COLUNA_USUARIO_USUARIO, usuario.getUsuario());
        valores.put(BancoDados.Tabela.COLUNA_USUARIO_SENHA, usuario.getSenha());
        valores.put(BancoDados.Tabela.COLUNA_USUARIO_BALANCE, usuario.getBalance());
        valores.put(BancoDados.Tabela.COLUNA_USUARIO_RATING, usuario.getRating());

        long id = bd.insert(BancoDados.Tabela.TABELA_USUARIO, null, valores);
    }

    public void deletarDados(SQLiteDatabase bd) {
        bd.delete(BancoDados.Tabela.TABELA_USUARIO, null, null);
    }

    public Usuario buscarUsuario(Context context, String usuarioS, String senha) {

        SQLiteDatabase bd = BancoDadosHelper.FabricaDeConexao.getConexaoLeitura(context);
        Usuario usuario = null;
        Cursor c = null;

        try {

            String[] selectColunasFrom = {BancoDados.Tabela._ID,
                    BancoDados.Tabela.COLUNA_USUARIO_USUARIO,
                    BancoDados.Tabela.COLUNA_USUARIO_BALANCE,
                    BancoDados.Tabela.COLUNA_USUARIO_RATING};

            String where =
                    BancoDados.Tabela.COLUNA_USUARIO_USUARIO + " = ?"
                            + " AND " + BancoDados.Tabela.COLUNA_USUARIO_SENHA + " = ?";

            String[] valorWhere =
                    { usuarioS, senha };

            c = bd.query(BancoDados.Tabela.TABELA_USUARIO,
                    selectColunasFrom,
                    where,
                    valorWhere,
                    null,
                    null,
                    null
            );

            if (c.moveToFirst()) {
                usuario = new Usuario();
                usuario.setUsuario(c.getString(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_USUARIO_USUARIO)));
                usuario.setBalance(c.getDouble(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_USUARIO_BALANCE)));
                usuario.setRating(c.getDouble(c.getColumnIndexOrThrow(BancoDados.Tabela.COLUNA_USUARIO_RATING)));
            } else {
                usuario = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (c != null) {
                c.close();
            }
        }

        return usuario;
    }

    public long buscarId(Context context, String usuarioS, String senha) {

        SQLiteDatabase bd = BancoDadosHelper.FabricaDeConexao.getConexaoLeitura(context);
        long id = -1;
        Cursor c = null;

        try {

            String[] selectColunasFrom = {BancoDados.Tabela._ID};

            String where =
                    BancoDados.Tabela.COLUNA_USUARIO_USUARIO + " = ?"
                            + " AND " + BancoDados.Tabela.COLUNA_USUARIO_SENHA + " = ?";

            String[] valorWhere =
                    { usuarioS, senha };

            c = bd.query(BancoDados.Tabela.TABELA_USUARIO,
                    selectColunasFrom,
                    where,
                    valorWhere,
                    null,
                    null,
                    null
            );

            if (c.moveToFirst()) {
                id = c.getLong(c.getColumnIndexOrThrow(BancoDados.Tabela._ID));
            } else {
                id = -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (c != null) {
                c.close();
            }
        }

        return id;
    }

    public void atualizarDados(Context context, Usuario usuario){

        SQLiteDatabase bd = BancoDadosHelper.FabricaDeConexao.getConexaoGravacao(context);

        ContentValues valores = new ContentValues();
        valores.put(BancoDados.Tabela.COLUNA_USUARIO_USUARIO, usuario.getUsuario());
        valores.put(BancoDados.Tabela.COLUNA_USUARIO_SENHA, usuario.getSenha());
        int count = bd.update(
                BancoDados.Tabela.TABELA_USUARIO,
                valores,
                null,
                null
        );
    }
}
