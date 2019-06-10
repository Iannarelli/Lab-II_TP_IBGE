package manipulacaoDados;

import classes.Pessoa;
import estruturaLista.EstruturaLista;
import manipulacaoArquivo.ArquivoTextoLeitura;

public class ManipulaDados {

	private EstruturaLista estruturaLista = new EstruturaLista();

	public void carregaDadosArquivo(ArquivoTextoLeitura leitorArquivo) {
		String[] informacoes = new String[7];
		String[] categorias = new String[5];
		Pessoa pessoa;
		String linhaArquivo = leitorArquivo.ler();
		while (linhaArquivo != null) {
			informacoes = linhaArquivo.split(";");
			pessoa = new Pessoa(Float.parseFloat(informacoes[0]), informacoes[1], informacoes[2].charAt(0),
					Integer.parseInt(informacoes[3]), informacoes[4], informacoes[5], informacoes[6]);
			defineCategorias(informacoes, categorias);
			for(int i=0; i<5; i++) {
				estruturaLista.getLista(categorias[i]).inserirFinal(pessoa);
			}
			linhaArquivo = leitorArquivo.ler();
		}
	}
	
	private void defineCategorias(String[] informacoes, String[] categorias) {
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
		if (informacoes[4].equalsIgnoreCase("Rural"))
			categorias[2] = "rural";
		else if (informacoes[4].equalsIgnoreCase("Urbana"))
			categorias[2] = "urbana";
		if (informacoes[5].equalsIgnoreCase("solteiro"))
			categorias[3] = "solteiro";
		else if (informacoes[5].equalsIgnoreCase("casado"))
			categorias[3] = "casado";
		else if (informacoes[5].equalsIgnoreCase("divorciado"))
			categorias[3] = "divorciado";
		else if (informacoes[5].equalsIgnoreCase("divorciado"))
			categorias[3] = "divorciado";
		else if (informacoes[5].equalsIgnoreCase("viuvo") || informacoes[5].equalsIgnoreCase("viúvo"))
			categorias[3] = "viuvo";
		if (informacoes[6].equalsIgnoreCase("parda"))
			categorias[4] = "parda";
		else if (informacoes[6].equalsIgnoreCase("preta"))
			categorias[4] = "preta";
		else if (informacoes[6].equalsIgnoreCase("branca"))
			categorias[4] = "branca";
		else if (informacoes[6].equalsIgnoreCase("amarela"))
			categorias[4] = "amarela";
		else if (informacoes[6].equalsIgnoreCase("indigena") || informacoes[6].equalsIgnoreCase("indígena"))
			categorias[4] = "indigena";
	}
}
