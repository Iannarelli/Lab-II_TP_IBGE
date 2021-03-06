package classes;

public class Pessoa {
	private long identidade;
	private String nome;
	private char sexo;
	private int idade;
	private String moradia; //rural ou urbana
	private String estadoCivil;
	private String raca;

	public Pessoa() {};

	public Pessoa(long identidade, String nome, char sexo, int idade, String moradia, String estadoCivil, String raca) {
		setIdentidade(identidade);
		setNome(nome);
		setSexo(sexo);
		setIdade(idade);
		setMoradia(moradia);
		setEstadoCivil(estadoCivil);
		setRaca(raca);
	}

	public long getIdentidade() {
		return identidade;
	}

	public void setIdentidade(long identidade) {
		this.identidade = identidade;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getMoradia() {
		return moradia;
	}
	
	public void setMoradia(String moradia) {
		this.moradia = moradia;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	@Override
	public String toString() {
		return "Identidade: " + identidade + "\nNome: " + nome + "\nSexo: " + sexo + "\nIdade: " + idade + " ano(s)\nMoradia: "
				+ moradia + "\nEstado civil: " + estadoCivil + "\nRa�a: " + raca;
	}
}
