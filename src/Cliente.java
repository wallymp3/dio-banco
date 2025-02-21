
public class Cliente {

	private String nome;
	private String email;
	private String endereco;
	private String dataNascimento;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	 // Método toString para exibir informações do cliente
	 @Override
	 public String toString() {
		 return "Nome: " + nome + "\nEndereço: " + endereco + "\nE-mail: " + email + "\nData de Nascimento: " + dataNascimento + "\n";
	 }
	
}
