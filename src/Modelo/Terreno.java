package Modelo;

public class Terreno extends Financiamento {
    private String tipoZona;

    public Terreno(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, String tipoZona) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.tipoZona = tipoZona;
    }

    public String getTipoZona() {
        return tipoZona;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = getTaxaJurosAnual() / 12 / 100;
        int totalMeses = getPrazoFinanciamento() * 12;
        double valorImovel = getValorImovel();
        double pagamentoMensal = (valorImovel * taxaMensal) / (1 - Math.pow(1 + taxaMensal, -totalMeses));
        return pagamentoMensal * 1.02; // Adicionando 2% sobre o valor da parcela
    }
}
