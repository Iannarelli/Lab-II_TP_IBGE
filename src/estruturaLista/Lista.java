package estruturaLista;

import classes.Pessoa;
import manipulacaoDados.ManipulaDados;

public class Lista { 
	 
	private CelulaPessoa primeiro; 
	private CelulaPessoa ultimo;
	private float populacao = 0;
 
	public Lista() { 
		primeiro = new CelulaPessoa(); 
 
		ultimo = primeiro; 
	}

	public float getPopulacao( ) {
		return populacao;
	}

	public void setPopulacao(float populacao) {
		this.populacao = populacao;
	}

	public void inserirFinal(Pessoa pessoa) { 
		CelulaPessoa aux = new CelulaPessoa(); 

		ultimo.proximo = aux; 

		aux.item = pessoa; 

		ultimo = ultimo.proximo;
	} 
 
	public Pessoa retirar(float identidade) { 
		CelulaPessoa aux, anterior; 
 
		anterior = primeiro; 
 
		aux = primeiro.proximo; 
 
		while (aux != null) { 
			if (aux.item.getIdentidade() == identidade) { 
				anterior.proximo = aux.proximo; 
 
				if (aux == ultimo) { 
					ultimo = anterior; 
				} 
				return aux.item; 
			} else { 
				anterior = aux; 
				aux = aux.proximo; 
			} 
		} 
		return null; 
	} 
 
	public Pessoa localizar(float identidade) { 
		CelulaPessoa aux = primeiro.proximo;
		
		while (aux != null) {
			if (aux.item.getIdentidade() == identidade) 
				return aux.item; 
			else 
				aux = aux.proximo; 
		} 
		return null;
	} 
 
	public Boolean listaVazia() { 
		if (primeiro == ultimo) { 
			return true; 
		} else { 
			return false; 
		} 
	}
	
	public String listaCompleta() {
		StringBuilder aux = new StringBuilder();
		CelulaPessoa celulaAux = primeiro.proximo;
		Pessoa pessoa;
		while (celulaAux != null) {
			pessoa = celulaAux.item;
			aux.append(String.valueOf(pessoa.getIdentidade()) + ";" + pessoa.getNome() + ";" + String.valueOf(pessoa.getSexo())
					+ ";" + String.valueOf(pessoa.getIdade()) + ";" + pessoa.getMoradia() + ";" + pessoa.getEstadoCivil() + ";"
					+ pessoa.getRaca() + "\n");
			celulaAux = celulaAux.proximo;
		}
		return aux.toString();
	}
 
	public float[] populacao() {
		CelulaPessoa aux = primeiro.proximo;
		float[] cont = new float[2];
		cont[0] = 0;
		cont[1] = 0;
		while (aux != null) {
			cont[0]++;
			cont[1] += aux.item.getIdade();
			aux = aux.proximo;
		} 
		return cont;
	}

	public float variancia(float media) {
		CelulaPessoa aux = primeiro.proximo;
		float variancia = 0;
		while (aux != null) {
			variancia += Math.pow((aux.item.getIdade() - media),2);
			aux = aux.proximo;
		}
		return variancia;
	}

	public void imprimir() { 
		 
		 
	} 
}