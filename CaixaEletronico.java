import java.util.Scanner;

public class CaixaEletronico {
    private double saldo;

    public CaixaEletronico() {
        this.saldo = 0.0;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito realizado com sucesso! Saldo atual: R$" + saldo);
        } else {
            System.out.println("Valor inválido para depósito!");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso! Saldo atual: R$" + saldo);
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    public void consultarSaldo() {
        System.out.println("Seu saldo atual é: R$" + saldo);
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Caixa Eletrônico ===");
            System.out.println("1 - Depositar");
            System.out.println("2 - Sacar");
            System.out.println("3 - Consultar saldo");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");

            // Verifica se a entrada é um número válido
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o valor do depósito: ");
                        if (scanner.hasNextDouble()) {
                            double deposito = scanner.nextDouble();
                            depositar(deposito);
                        } else {
                            System.out.println("Valor inválido! Tente novamente.");
                            scanner.next(); // Limpa entrada inválida
                        }
                        break;
                    case 2:
                        System.out.print("Digite o valor do saque: ");
                        if (scanner.hasNextDouble()) {
                            double saque = scanner.nextDouble();
                            sacar(saque);
                        } else {
                            System.out.println("Valor inválido! Tente novamente.");
                            scanner.next();
                        }
                        break;
                    case 3:
                        consultarSaldo();
                        break;
                    case 4:
                        System.out.println("Obrigado por usar o caixa eletrônico!");
                        break;
                    default:
                        System.out.println("Opção inválida, tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida! Digite um número.");
                scanner.next(); // Limpa a entrada inválida
                opcao = -1; // Mantém o loop
            }
        } while (opcao != 4);

        scanner.close();
    }

    public static void main(String[] args) {
        CaixaEletronico caixa = new CaixaEletronico();
        caixa.exibirMenu();
    }
}
