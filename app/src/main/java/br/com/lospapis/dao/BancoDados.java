package br.com.lospapis.dao;

import android.provider.BaseColumns;

/**
 * Created by Daniel Almeida on 12/11/2017.
 */

public class BancoDados {

    private BancoDados() {
    }

    /**
     * Versão do banco de dados da aplicação
     */
    public static final int BANCO_VERSAO = 1;
    /**
     * Nome do banco de dados da aplicação
     */
    public static final String BANCO_NOME = "LosPapis.db";

    /**
     * Esta classe interna contem todas as informações necessárias para criação
     * e acesso as tabelas do banco de dados
     */
    public static class Tabela implements BaseColumns {

        /**
         * Dados padrão SQL
         */
        private static final String CRIAR_TABELA = "CREATE TABLE IF NOT EXISTS ";
        private static final String EXCLUIR_TABELA = "DROP TABLE IF EXISTS ";
        private static final String CHAVE_PRIMARIA = " PRIMARY KEY";
        private static final String AUTO_INCREMENTO = " AUTOINCREMENT";
        private static final String PARENTESES_ENTRADA = " (";
        private static final String PARENTESES_SAIDA = " )";
        private static final String VIRGULA = ",";

        /**
         * Tipos de dados dos atributos das colunas
         */
        private static final String TIPO_TEXTO = " TEXT";
        private static final String TIPO_INTEIRO = " INTEGER";
        private static final String TIPO_NUMERICO = " NUMERIC";

        /**
         * Dados da tabela de usuario
         */
        public static final String TABELA_USUARIO = "tabelaUsuario";
        public static final String COLUNA_USUARIO_USUARIO = "usuario";
        public static final String COLUNA_USUARIO_SENHA = "senha";
        public static final String COLUNA_USUARIO_BALANCE = "balance";
        public static final String COLUNA_USUARIO_RATING = "rating";

        /**
         * Dados da tabela de jogador
         */
        public static final String TABELA_JOGADOR = "tabelaJogador";
        public static final String COLUNA_JOGADOR_NOME = "nome";
        public static final String COLUNA_JOGADOR_POSICAO = "posicao";
        public static final String COLUNA_JOGADOR_VALOR = "valor";
        public static final String COLUNA_JOGADOR_ATAQUE = "ataque";
        public static final String COLUNA_JOGADOR_DEFESA = "defesa";
        public static final String COLUNA_JOGADOR_ALTURA = "altura";
        public static final String COLUNA_JOGADOR_PESO = "peso";
        public static final String COLUNA_JOGADOR_COND_FISICA = "condFisica";
        public static final String COLUNA_JOGADOR_FORCA = "forca";
        public static final String COLUNA_JOGADOR_DRIBLE = "drible";
        public static final String COLUNA_JOGADOR_DESARME = "desarme";
    }

    public static final String CRIAR_TABELA_USUARIO = Tabela.CRIAR_TABELA + Tabela.TABELA_USUARIO + Tabela.PARENTESES_ENTRADA +
            Tabela._ID + Tabela.TIPO_INTEIRO + Tabela.CHAVE_PRIMARIA + Tabela.AUTO_INCREMENTO + Tabela.VIRGULA +
            Tabela.COLUNA_USUARIO_USUARIO + Tabela.TIPO_TEXTO + Tabela.VIRGULA +
            Tabela.COLUNA_USUARIO_SENHA + Tabela.TIPO_TEXTO + Tabela.VIRGULA +
            Tabela.COLUNA_USUARIO_BALANCE + Tabela.TIPO_INTEIRO + Tabela.VIRGULA +
            Tabela.COLUNA_USUARIO_RATING + Tabela.TIPO_INTEIRO + Tabela.PARENTESES_SAIDA;

    /**
     * Comando SQL para criar a tabela de classificaçao
     */
    public static final String CRIAR_TABELA_JOGADOR = Tabela.CRIAR_TABELA + Tabela.TABELA_JOGADOR + Tabela.PARENTESES_ENTRADA +
            Tabela._ID + Tabela.TIPO_INTEIRO + Tabela.CHAVE_PRIMARIA + Tabela.AUTO_INCREMENTO + Tabela.VIRGULA +
            Tabela.COLUNA_JOGADOR_NOME + Tabela.TIPO_TEXTO + Tabela.VIRGULA +
            Tabela.COLUNA_JOGADOR_POSICAO + Tabela.TIPO_TEXTO + Tabela.VIRGULA +
            Tabela.COLUNA_JOGADOR_VALOR + Tabela.TIPO_INTEIRO + Tabela.VIRGULA +
            Tabela.COLUNA_JOGADOR_ATAQUE + Tabela.TIPO_INTEIRO + Tabela.VIRGULA +
            Tabela.COLUNA_JOGADOR_DEFESA + Tabela.TIPO_INTEIRO + Tabela.VIRGULA +
            Tabela.COLUNA_JOGADOR_ALTURA + Tabela.TIPO_NUMERICO + Tabela.VIRGULA +
            Tabela.COLUNA_JOGADOR_PESO + Tabela.TIPO_NUMERICO + Tabela.VIRGULA +
            Tabela.COLUNA_JOGADOR_COND_FISICA + Tabela.TIPO_INTEIRO + Tabela.VIRGULA +
            Tabela.COLUNA_JOGADOR_FORCA + Tabela.TIPO_INTEIRO + Tabela.VIRGULA +
            Tabela.COLUNA_JOGADOR_DRIBLE + Tabela.TIPO_INTEIRO + Tabela.VIRGULA +
            Tabela.COLUNA_JOGADOR_DESARME + Tabela.TIPO_INTEIRO + Tabela.PARENTESES_SAIDA;

    /**
     * Comando SQL para excluir a tabela de usuario
     */
    public static final String DELETAR_TABELA_USUARIO =
            Tabela.EXCLUIR_TABELA + Tabela.TABELA_USUARIO;

    /**
     * Comando SQL para excluir a tabela de jogador
     */
    public static final String DELETAR_TABELA_JOGADOR =
            Tabela.EXCLUIR_TABELA + Tabela.TABELA_JOGADOR;
}