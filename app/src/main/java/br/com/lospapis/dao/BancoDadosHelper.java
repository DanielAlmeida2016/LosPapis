package br.com.lospapis.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Daniel Almeida on 12/11/2017.
 */

public class BancoDadosHelper extends SQLiteOpenHelper {

    /**
     * Construtor utilizado para criação e acesso ao banco de dados
     *
     * @param context Contexto da aplicação onde será criado o banco
     */
    private BancoDadosHelper(Context context) {
        super(context, BancoDados.BANCO_NOME, null, BancoDados.BANCO_VERSAO);
    }

    /**
     * Este método cria todas as tabelas do bando de dados da aplicação
     * Ele é executado apenas na primeira vez que a classe é instanciada
     *
     * @param bd Conexão passada para execução dos comandos SQL de criação de tabelas
     */
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(BancoDados.CRIAR_TABELA_USUARIO);
        bd.execSQL(BancoDados.CRIAR_TABELA_JOGADOR);
    }

    /**
     * Este método serve para realizar updrade na versão do banco de dados da aplicação
     * Ele deleta as tabelas e cria novas tabelas
     *
     * @param bd           Conexão passada para execução dos comando SQL para dropar as tabelas
     * @param versaoAntiga Versão atual do banco de dados aplicação
     * @param novaVersao   Nova versão que será utilizada pelo banco de dados da aplicação
     */
    public void onUpgrade(SQLiteDatabase bd, int versaoAntiga, int novaVersao) {
        bd.execSQL(BancoDados.DELETAR_TABELA_USUARIO);
        bd.execSQL(BancoDados.DELETAR_TABELA_JOGADOR);
        onCreate(bd);
    }

    /**
     * Classe interna para fornecer conexão ao banco de dados da aplicação
     */
    public static class FabricaDeConexao {

        private static SQLiteDatabase CONEXAO_LEITURA = null;
        private static SQLiteDatabase CONEXAO_GRAVACAO = null;

        private static BancoDadosHelper BANCO_DADOS_HELPER;

        /**
         * @author Daniel Almeida
         * Este método serve para fornecer uma conexão única de leitura
         */
        private FabricaDeConexao() {
        }

        public static SQLiteDatabase getConexaoLeitura(Context context) {

            if (CONEXAO_LEITURA == null) {
                BANCO_DADOS_HELPER = new BancoDadosHelper(context);
                CONEXAO_LEITURA = BANCO_DADOS_HELPER.getReadableDatabase();
            }
            return CONEXAO_LEITURA;
        }

        /**
         * @author Daniel Almeida
         * Este método serve para fornecer uma conexão única de gravação no banco
         */
        public static SQLiteDatabase getConexaoGravacao(Context context) {

            if (CONEXAO_GRAVACAO == null) {
                BANCO_DADOS_HELPER = new BancoDadosHelper(context);
                CONEXAO_GRAVACAO = BANCO_DADOS_HELPER.getWritableDatabase();
            }
            return CONEXAO_GRAVACAO;
        }

        /**
         * @author Daniel Almeida
         * Este método deverá ser chamado para criar a primeira instância da classe SQLiteOpenHelper
         * e assim criar o banco de dados e as tabelas
         */
        public static void criarBancoDados(Context context) {
            getConexaoLeitura(context);
        }

        /**
         * @author Daniel Almeida
         * Este método serve para encerrar a conexão de leitura se estiver aberta
         */
        public static void fecharConexaoAplicacao() {
            if (CONEXAO_LEITURA != null) {
                CONEXAO_LEITURA.close();
            }
        }

        /**
         * @author Daniel Almeida
         * Este método serve para encerrar a conexão de gravação se estiver aberta
         */
        public static void fecharConexaoServico() {
            if (CONEXAO_GRAVACAO != null) {
                CONEXAO_GRAVACAO.close();
            }
        }
    }

}
