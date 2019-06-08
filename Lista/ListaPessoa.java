public class ListaPessoa {

	private CelulaPessoa primeiro;
	private CelulaPessoa ultimo;

	public ListaPessoa() {
		primeiro = new CelulaPessoa();

		ultimo = primeiro;
	}

	public void inserirFinal(ContaCorrente cc) {
		CelulaPessoa aux = new CelulaPessoa();

		ultimo.proximo = aux;

		//aux.item = cc;

		ultimo = ultimo.proximo;
	}

	public ContaCorrente retirar(int numContaCorrente) {
		CelulaPessoa aux, anterior;

		anterior = primeiro;

		aux = primeiro.proximo;

		while (aux != null) {
			if (aux.item.getId() == numContaCorrente) {
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
