public class NodoPessoa {

	ListaPessoa item;          
	NodoPessoa direita;   
    NodoPessoa esquerda;   

    public NodoPessoa(ListaPessoa registro) {
    	item = registro;
    	direita = null;
    	esquerda = null;
    }
}
