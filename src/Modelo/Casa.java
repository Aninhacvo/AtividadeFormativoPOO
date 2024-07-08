package Modelo;

public class Casa extends Financiamento {
    private double areaConstruida;
    private double tamanhoTerreno;

    public Casa(double valorImovel, int prazoFinanciamento, double taxaJurosAnual, double areaConstruida, double tamanhoTerreno) {
        super(valorImovel, prazoFinanciamento, taxaJurosAnual);
        this.areaConstruida = areaConstruida;
        this.tamanhoTerreno = tamanhoTerreno;
    }

    public double getAreaConstruida() {
        return areaConstruida;
    }

    public double getTamanhoTerreno() {
        return tamanhoTerreno;
    }

    @Override
    public double calcularPagamentoMensal() {
        double taxaMensal = getTaxaJurosAnual() / 12 / 100;
        int totalMeses = getPrazoFinanciamento() * 12;
        double valorImovel = getValorImovel();
        double pagamentoMensal = (valorImovel * taxaMensal) / (1 - Math.pow(1 + taxaMensal, -totalMeses));
        return pagamentoMensal + 80; // Adicionando R$ 80 por parcela
    }

    public void aplicarDesconto(double desconto) throws DescontoMaiorDoQueJurosException {
        double jurosMensal = getTaxaJurosAnual() / 12 / 100 * getValorImovel();
        if (desconto > jurosMensal) {
            throw new DescontoMaiorDoQueJurosException("Desconto maior do que os juros mensais.");
        }

        // Calcular o novo valor do financiamento com o desconto
        double novoValorImovel = getValorImovel() - desconto;

        // Atualizar o valor do imóvel no financiamento
        setValorImovel(novoValorImovel);

        // Mensagem de confirmação
        System.out.println("Desconto aplicado com sucesso. Novo valor do imóvel: " + novoValorImovel);
    }

	private void setValorImovel(double novoValorImovel) {
		// TODO Auto-generated method stub
		
	}
}
