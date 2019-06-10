package estruturaArvore;

import classes.Pessoa;

public class NodoPessoa {

	Pessoa item;           // contém os dados da pessoa armazenada no nodo da árvore.
	NodoPessoa direita;    // referência ao nodo armazenado, na árvore, à  direita da pessoa em questão.
    NodoPessoa esquerda;   // referência ao nodo armazenado, na árvore, à  esquerda da pessoa em questão.

    public NodoPessoa(Pessoa registro) {
    	item = registro;
    	direita = null;
    	esquerda = null;
    }
}
