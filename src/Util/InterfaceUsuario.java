package Util;

import java.util.Scanner;

public class InterfaceUsuario {
    private Scanner scanner;

    public InterfaceUsuario() {
        scanner = new Scanner(System.in);
    }

    public double pedirValorImovel() {
        System.out.print("Digite o valor do imóvel: ");
        return scanner.nextDouble();
    }

    public int pedirPrazoFinanciamento() {
        System.out.print("Digite o prazo do financiamento (em anos): ");
        return scanner.nextInt();
    }

    public double pedirTaxaJurosAnual() {
        System.out.print("Digite a taxa de juros anual (%): ");
        return scanner.nextDouble();
    }

    public double pedirDesconto() {
        System.out.print("Digite o valor do desconto: ");
        return scanner.nextDouble();
    }

    public int pedirTipoImovel() {
        System.out.println("Digite o tipo de imóvel:");
        System.out.println("1. Casa");
        System.out.println("2. Apartamento");
        System.out.println("3. Terreno");
        return scanner.nextInt();
    }
}
