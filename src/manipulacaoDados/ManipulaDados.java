package manipulacaoDados;

import classes.Indicador;
import classes.Pessoa;
import estruturaArvore.Arvore;
import estruturaLista.EstruturaLista;
import manipulacaoArquivo.ArquivoTextoEscrita;
import manipulacaoArquivo.ArquivoTextoLeitura;

public class ManipulaDados {

	private EstruturaLista estruturaLista = new EstruturaLista();
	private Arvore arvore = new Arvore();
	private ArquivoTextoLeitura leitorArquivo;
	private ArquivoTextoEscrita escritorArquivo;
	private String arquivo;

	public ManipulaDados(ArquivoTextoLeitura leitorArquivo, ArquivoTextoEscrita escritorArquivo, String arquivo) {
		setLeitorArquivo(leitorArquivo);
		setEscritorArquivo(escritorArquivo);
		setArquivo(arquivo);
	}

	public EstruturaLista getEstruturaLista() {
		return estruturaLista;
	}

	public void setEstruturaLista(EstruturaLista estruturaLista) {
		this.estruturaLista = estruturaLista;
	}

	public Arvore getArvore() {
		return arvore;
	}

	public void setArvore(Arvore arvore) {
		this.arvore = arvore;
	}

	public ArquivoTextoLeitura getLeitorArquivo() {
		return leitorArquivo;
	}

	public void setLeitorArquivo(ArquivoTextoLeitura leitorArquivo) {
		this.leitorArquivo = leitorArquivo;
	}

	public ArquivoTextoEscrita getEscritorArquivo() {
		return escritorArquivo;
	}

	public void setEscritorArquivo(ArquivoTextoEscrita escritorArquivo) {
		this.escritorArquivo = escritorArquivo;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public void carregaDadosArquivo() {
		String[] informacoes = new String[7];
		Pessoa pessoa;
		String linhaArquivo = leitorArquivo.ler();
		while (linhaArquivo != null && linhaArquivo.length() != 0) {
			informacoes = linhaArquivo.split(";");
			pessoa = new Pessoa(Long.parseLong(informacoes[0]), informacoes[1], informacoes[2].charAt(0),
					Integer.parseInt(informacoes[3]), informacoes[4], informacoes[5], informacoes[6]);
			populaListas(informacoes, pessoa);
			populaArvore(pessoa);
			linhaArquivo = leitorArquivo.ler();
		}
	}
	
	public void armazenaDadosArquivo() {
		StringBuilder aux = new StringBuilder(estruturaLista.getLista("masculino").listaCompleta());
		aux.append("\n" + estruturaLista.getLista("feminino").listaCompleta());
		escritorArquivo.abrirArquivo(arquivo);
		escritorArquivo.escrever(aux.toString());
		escritorArquivo.fecharArquivo();
	}
	
	private void populaArvore(Pessoa pessoa) {
		arvore.inserir(pessoa);
	}
	
	private void populaListas(String[] informacoes, Pessoa pessoa) {
		String[] categorias = new String[5];
		categorias = defineCategorias(informacoes);
		for(int i=0; i<5; i++) {
			estruturaLista.getLista(categorias[i]).inserirFinal(pessoa);
		}		
	}

	public String[] defineCategorias(String[] informacoes) {
		String[] categorias = new String[5];
		if (informacoes[2].charAt(0) == 'm' || informacoes[2].charAt(0) == 'M')
			categorias[0] = "masculino";
		else if (informacoes[2].charAt(0) == 'f' || informacoes[2].charAt(0) == 'F')
			categorias[0] = "feminino";
		if (Integer.parseInt(informacoes[3]) > 0 && Integer.parseInt(informacoes[3]) <= 12)
			categorias[1] = "0a12";
		else if(Integer.parseInt(informacoes[3]) >=13 && Integer.parseInt(informacoes[3]) <= 19)
			categorias[1] = "13a19";
		else if(Integer.parseInt(informacoes[3]) >=20 && Integer.parseInt(informacoes[3]) <= 25)
			categorias[1] = "20a25";
		else if(Integer.parseInt(informacoes[3]) >=26 && Integer.parseInt(informacoes[3]) <= 30)
			categorias[1] = "26a30";
		else if(Integer.parseInt(informacoes[3]) >=31 && Integer.parseInt(informacoes[3]) <= 45)
			categorias[1] = "31a45";
		else if(Integer.parseInt(informacoes[3]) >=46 && Integer.parseInt(informacoes[3]) <= 65)
			categorias[1] = "46a65";
		else if(Integer.parseInt(informacoes[3]) >65)
			categorias[1] = "+65";
		if (informacoes[4].equalsIgnoreCase("rural"))
			categorias[2] = "rural";
		else if (informacoes[4].equalsIgnoreCase("urbana") || informacoes[4].equalsIgnoreCase("urbano"))
			categorias[2] = "urbana";
		if (informacoes[5].equalsIgnoreCase("solteira") || informacoes[5].equalsIgnoreCase("solteiro"))
			categorias[3] = "solteiro";
		else if (informacoes[5].equalsIgnoreCase("casada") || informacoes[5].equalsIgnoreCase("casado"))
			categorias[3] = "casado";
		else if (informacoes[5].equalsIgnoreCase("divorciada") || informacoes[5].equalsIgnoreCase("divorciado"))
			categorias[3] = "divorciado";
		else if (informacoes[5].equalsIgnoreCase("viuva") || informacoes[5].equalsIgnoreCase("viúva") ||
				informacoes[5].equalsIgnoreCase("viuvo") || informacoes[5].equalsIgnoreCase("viúvo"))
			categorias[3] = "viuvo";
		if (informacoes[6].equalsIgnoreCase("parda") || informacoes[6].equalsIgnoreCase("pardo"))
			categorias[4] = "parda";
		else if (informacoes[6].equalsIgnoreCase("preta") || informacoes[6].equalsIgnoreCase("preto"))
			categorias[4] = "preta";
		else if (informacoes[6].equalsIgnoreCase("branca") || informacoes[6].equalsIgnoreCase("branco"))
			categorias[4] = "branca";
		else if (informacoes[6].equalsIgnoreCase("amarela") || informacoes[6].equalsIgnoreCase("amarelo"))
			categorias[4] = "amarela";
		else if (informacoes[6].equalsIgnoreCase("indigena") || informacoes[6].equalsIgnoreCase("indígena") ||
				informacoes[6].equalsIgnoreCase("indigeno") || informacoes[6].equalsIgnoreCase("indígeno"))
			categorias[4] = "indigena";
		return categorias;
	}
	
	public void pessoaNova(String[] dados) {
		Pessoa pessoaNova = new Pessoa(Long.parseLong(dados[0]), dados[1], dados[2].charAt(0), Integer.parseInt(dados[3]), dados[4],
				dados[5], dados[6]);
		populaListas(dados, pessoaNova);
		populaArvore(pessoaNova);
		armazenaDadosArquivo();
		System.out.println(pessoaNova.toString()); //verificar se precisa ou se colocou só para teste
	}
	
	public float populacaoTotal() {
		return estruturaLista.getLista("masculino").populacao()[0] + estruturaLista.getLista("feminino").populacao()[0];
	}
	
	public Indicador geraIndicadores() {
		return new Indicador(this);
	}
}
