package com.projeto.Model;

public class Elevador {
    // Atributos
    private int andarAtual;
    private boolean fechado;
    private boolean parado;

    // Construtores
    public Elevador() {
        this.andarAtual = 1;
        this.fechado = true;
        this.parado = true;
    }

    public int getAndarAtual() {
        return andarAtual;
    }

    public void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }

    public Elevador(boolean fechado, boolean parado) {
        this.fechado = fechado;
        this.parado = parado;
    }

    // Getters and setters
    public boolean isFechado() {
        return fechado;
    }

    public void setFechado(boolean fechado) {
        this.fechado = fechado;
    }

    public boolean isParado() {
        return parado;
    }

    public void setParado(boolean parado) {
        this.parado = parado;
    }

    // Métodos para movimentação
    public void abrirPortas() {
        fechado = false;
    }

    public void fecharPortas() {
        fechado = true;
    }

    public void iniciarMovimento() {
        parado = false;
    }

    public void pararMovimento() {
        parado = true;
    }

    public boolean estaDisponivel() {
        return fechado && parado;
    }

}
