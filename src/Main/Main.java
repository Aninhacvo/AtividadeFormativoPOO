package Main;

import Util.InterfaceUsuario;
import Modelo.Financiamento;
import Modelo.Casa;
import Modelo.Apartamento;
import Modelo.Terreno;
import Modelo.DescontoMaiorDoQueJurosException;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario();
        List<Financiamento> financiamentos = new ArrayList<>();

        int tipoImovel = interfaceUsuario.pedirTipoImovel();
        double valorImovel = interfaceUsuario.pedirValorImovel();
        int prazoFinanciamento = interfaceUsuario.pedirPrazoFinanciamento();
        double taxaJurosAnual = interfaceUsuario.pedirTaxaJurosAnual();

        if (tipoImovel == 1) {
            Casa casa = new Casa(valorImovel, prazoFinanciamento, taxaJurosAnual, 100, 200);
            double desconto = interfaceUsuario.pedirDesconto();
            try {
                casa.aplicarDesconto(desconto);
            } catch (DescontoMaiorDoQueJurosException e) {
                System.out.println("Erro: " + e.getMessage());
            }
            financiamentos.add(casa);
        } else if (tipoImovel == 2) {
            Apartamento apartamento = new Apartamento(valorImovel, prazoFinanciamento, taxaJurosAnual, 2, 5);
            financiamentos.add(apartamento);
        } else if (tipoImovel == 3) {
            Terreno terreno = new Terreno(valorImovel, prazoFinanciamento, taxaJurosAnual, "Residencial");
            financiamentos.add(terreno);
        }

        financiamentos.add(new Casa(200000, 30, 5, 150, 300));
        financiamentos.add(new Apartamento(300000, 20, 4, 2, 5));
        financiamentos.add(new Apartamento(400000, 25, 3, 1, 10));
        financiamentos.add(new Terreno(100000, 15, 6, "Residencial"));

        double totalValorImoveis = 0;
        double totalValorFinanciamentos = 0;

        for (Financiamento financiamento : financiamentos) {
            financiamento.mostrarDadosFinanciamento();
            totalValorImoveis += financiamento.getValorImovel();
            totalValorFinanciamentos += financiamento.calcularTotalPagamento();
            if (financiamento instanceof Casa) {
                Casa casa = (Casa) financiamento;
                System.out.println("Área Construída: " + casa.getAreaConstruida());
                System.out.println("Tamanho do Terreno: " + casa.getTamanhoTerreno());
            } else if (financiamento instanceof Apartamento) {
                Apartamento apartamento = (Apartamento) financiamento;
                System.out.println("Número de Vagas na Garagem: " + apartamento.getNumVagasGaragem());
                System.out.println("Número do Andar: " + apartamento.getNumAndar());
            } else if (financiamento instanceof Terreno) {
                Terreno terreno = (Terreno) financiamento;
                System.out.println("Tipo de Zona: " + terreno.getTipoZona());
            }
            System.out.println();
        }

        System.out.printf("Total de todos os imóveis: R$ %.2f%n", totalValorImoveis);
        System.out.printf("Total de todos os financiamentos: R$ %.2f%n", totalValorFinanciamentos);
    }
}
