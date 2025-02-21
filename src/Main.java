import java.util.ArrayList;
import java.util.Scanner;

public class Main {
// Função para realizar o depósito em uma conta selecionada
	public static void realizarDeposito(int tipoConta, Cliente clienteSelecionado, int valor) {
		switch (tipoConta) {
			case 1:
				Conta cc = new ContaCorrente(clienteSelecionado); // Conta Corrente
				cc.depositar(valor);
				cc.imprimirExtrato();
				break;
			case 2:
				Conta poupanca = new ContaPoupanca(clienteSelecionado); // Conta Poupança
				poupanca.depositar(valor);
				poupanca.imprimirExtrato();
				break;
			default:
				System.out.println("Opção de conta inválida.");
				break;
		}
	}

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

							realizarDeposito(contaDeposito, cliente, valor);

						}else{
							System.out.println("\nCliente cadastrado com sucesso!");
						}

						break;
					case 2:
						System.out.println("===== CONSULTA DE CLIENTES =====");

                        if (clientes.isEmpty()) {
                            System.out.println("Não há clientes cadastrados.\n");
                        } else {
                            // Exibe todos os clientes cadastrados com índice para seleção
                            System.out.println("Escolha o cliente para realizar um depósito:");
                            for (int i = 0; i < clientes.size(); i++) {
                                System.out.println(i + 1 + " - " + clientes.get(i).getNome());
                            }

                            int clienteEscolhido = terminal.nextInt();
                            terminal.nextLine(); // Consome a linha restante após nextInt()
                            
                            if (clienteEscolhido > 0 && clienteEscolhido <= clientes.size()) {
                                Cliente clienteSelecionado = clientes.get(clienteEscolhido - 1); // Ajusta o índice

                                System.out.println("\nCliente selecionado: " + clienteSelecionado.getNome());
                                System.out.println("Deseja realizar depósito para este cliente (s/n)?");
                                String depositoEscolhido = terminal.nextLine();
                                if (depositoEscolhido.equals("s")) {
                                    System.out.println("Qual o valor do depósito:");
                                    int valor = terminal.nextInt();
                                    System.out.println("Escolha a opção de conta:");
                                    System.out.println("1 - Corrente");
                                    System.out.println("2 - Poupança");
                                    int contaDeposito = terminal.nextInt();
                                    terminal.nextLine(); // Consome a linha restante após nextInt()

									realizarDeposito(contaDeposito, clienteSelecionado, valor);

                                } else {
                                    System.out.println("Depósito não realizado.");
                                }
                            } else {
                                System.out.println("Opção inválida. Nenhum cliente selecionado.");
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
