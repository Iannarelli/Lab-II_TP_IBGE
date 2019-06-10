package estruturaLista;

import classes.Pessoa;

public class Lista { 
	 
	private CelulaPessoa primeiro; 
	private CelulaPessoa ultimo; 
 
	public Lista() { 
		primeiro = new CelulaPessoa(); 
 
		ultimo = primeiro; 
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