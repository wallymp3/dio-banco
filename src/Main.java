import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		try (Scanner terminal = new Scanner(System.in)) {
			int escolha = 0;
			ArrayList<Cliente> clientes = new ArrayList<>();
			while(escolha != 3){

				System.out.println("Escolha a opção abaixo:");
				System.out.println("1 - Cadastrar Cliente");
				System.out.println("2 - Consultar Clientes");
				System.out.println("3 - Sair do sistema");
			
				escolha = terminal.nextInt();  // ?? deve ser nextInt() para ler um número inteiro.
				terminal.nextLine();
			
				switch (escolha) {
					case 1:
						System.out.println("===== CADASTRO DE CLIENTE =====");

						Cliente cliente = new Cliente();
						System.out.println("Digite o nome do cliente:");
						cliente.setNome(terminal.nextLine());

						System.out.println("Digite o endereço do cliente:");
						cliente.setEndereco(terminal.nextLine());

						System.out.println("Digite o e-mail do cliente:");
						cliente.setEmail(terminal.nextLine());

						System.out.println("Digite a Data de Nascimento:");
						cliente.setDataNascimento(terminal.nextLine());

						clientes.add(cliente);
						
						System.out.println("\nDeseja realizar deposito (s/n)?");
						String deposito = terminal.nextLine();

						if(deposito.equals("s")){
							System.out.println("Qual o valor do deposito:");
							int valor = terminal.nextInt();
							System.out.println("Escolha a opção de conta:");
							System.out.println("1 - Corrente");
							System.out.println("2 - Poupança");
							int contaDeposito = terminal.nextInt();
							terminal.nextLine(); // Consome a linha restante após nextInt()

							switch (contaDeposito) {
								case 1:
									Conta cc = new ContaCorrente(cliente);
									cc.depositar(valor);
									cc.imprimirExtrato();

									break;
								case 2:
									Conta poupanca = new ContaPoupanca(cliente);
									poupanca.depositar(valor);
									poupanca.imprimirExtrato();
									break;
								default:
									System.out.println("Opção de conta inválida.");
									break;
							}
						}else{
							System.out.println("\nCliente cadastrado com sucesso!");

						}

						break;
					case 2:
						System.out.println("===== CONSULTA DE CLIENTES =====");

						if (clientes.isEmpty()) {
							System.out.println("Não há clientes cadastrados.\n");
						} else {
							// Exibe todos os clientes cadastrados
							for (Cliente c : clientes) {
								System.out.println(c + "\n"); // Aqui você vai precisar de um método toString na classe Cliente
							}
						}


						break;
					case 3:
						System.out.println("Saindo do sistema...");
						escolha = 3;
						return; // Sai do programa
					default:
						System.out.println("Opção inválida. Tente novamente.");
					}
			}
		}

	}

}
