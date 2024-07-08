package Modelo;

public class Apartamento extends Financiamento {
    private int numVagasGaragem;
    private int numAndar;

    public Apartamento(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, int numVagasGaragem, int numAndar) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.numVagasGaragem = numVagasGaragem;
        this.numAndar = numAndar;
    }

    public int getNumVagasGaragem() {
        return numVagasGaragem;
    }

    public int getNumAndar() {
        return numAndar;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = getTaxaJurosAnual() / 12 / 100;
        int totalMeses = getPrazoFinanciamento() * 12;
        double valorImovel = getValorImovel();
        return (valorImovel * Math.pow((1 + taxaMensal), totalMeses) * taxaMensal) / (Math.pow((1 + taxaMensal), totalMeses) - 1);
    }
}

