package br.com.lospapis.model;

/**
 * Created by Daniel Almeida on 12/11/2017.
 */

public class Jogador {

    private String nome;
    private String posicao;
    private int valor;
    private int ataque;
    private int defesa;
    private double altura;
    private double peso;
    private int cond_fisica;
    private int forca;
    private int drible;
    private int desarme;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getCond_fisica() {
        return cond_fisica;
    }

    public void setCond_fisica(int cond_fisica) {
        this.cond_fisica = cond_fisica;
    }

    public int getForca() {
        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDrible() {
        return drible;
    }

    public void setDrible(int drible) {
        this.drible = drible;
    }

    public int getDesarme() {
        return desarme;
    }

    public void setDesarme(int desarme) {
        this.desarme = desarme;
    }
}
