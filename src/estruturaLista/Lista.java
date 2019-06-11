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
 
	public ContaCorrente retirar(int numContaCorrente) { 
		CelulaPessoa aux, anterior; 
 
		anterior = primeiro; 
 
		aux = primeiro.proximo; 
 
		while (aux != null) { 
			if (aux.item.getIdentidade() == numContaCorrente) { 
				anterior.proximo = aux.proximo; 
 
				if (aux == ultimo) { 
					ultimo = anterior; 
				} 
				//return aux.item; 
			} else { 
				anterior = aux; 
				aux = aux.proximo; 
			} 
		} 
		return null; 
	} 
 
	public Pessoa localizar(int numContaCorrente) { 
		//CelulaPessoa aux; 
		numContaCorrente = 0; 
	//	aux = primeiro.proximo; 
return null; 
	} 
 
	public Boolean listaVazia() { 
		if (primeiro == ultimo) { 
			return true; 
		} else { 
			return false; 
		} 
	} 

	public void imprimir() { 
		 
		 
	} 
}