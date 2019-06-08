public class ABBPessoa {

	public NodoPessoa raiz; // referência à raiz da árvore.

    /// Construtor da classe.
    /// Esse construtor cria uma nova árvore binária de alunos vazia. Para isso, esse método atribui null à raiz da árvore.
    public ABBPessoa()
    {
        raiz = null;
    }

   
    public Boolean arvoreVazia()
    {
        if (this.raiz == null)
            return true;
        else
            return false;
    }

    public int getTotalRaiz(NodoPessoa raiz) {
    	int a = 0;
    	if(raiz.direita!=null) {
    		return a + getTotalRaiz(raiz.direita); 
    	}
    	if(raiz.esquerda!=null)return a + getTotalRaiz(raiz.esquerda);
    	return a;
    }
// private NodoPessoa adicionar(NodoPessoa raizArvore, Pessoa alunoNovo, int numContaCorrente)
  //  {
        /// Se a raiz da árvore ou sub-árvore for null, a árvore está vazia e então um novo aluno é inserido.
      /*  if (raizArvore == null)
            raizArvore = new NodoPessoa(alunoNovo);
        else
        {
            /// Se o número de matrícula do aluno armazenado na raiz da árvore for maior do que o número de matrícula do aluno que deverá ser inserido na árvore:
            /// adicione esse aluno à sub-árvore esquerda; e atualize a referência para a sub-árvore esquerda modificada. 
            if (raizArvore.item.localizar(numContaCorrente).getId() > alunoNovo.getId())
                raizArvore.esquerda = adicionar(raizArvore.esquerda, alunoNovo);
            else
            {
                /// Se o número de matrícula do aluno armazenado na raiz da árvore for menor do que o número de matrícula do aluno que deverá ser inserido na árvore:
                /// adicione esse aluno à sub-árvore direita; e atualize a referência para a sub-árvore direita modificada.
                if (raizArvore.item.getNumMatricula() < alunoNovo.getNumMatricula())
                    raizArvore.direita = adicionar(raizArvore.direita, alunoNovo);
                else
                    /// O número de matrícula do aluno armazenado na raiz da árvore é igual ao número de matrícula do aluno que deveria ser inserido na árvore.
         //           System.out.println("O aluno " + alunoNovo.getNome() + ", cuja matrícula é " + alunoNovo.getNumMatricula() + ", já foi inserido anteriormente na árvore.");
            }
        }
        return raizArvore;*/
   // }

    /// Metodo que encapsula a adição recursiva de alunos à árvore.
    /// Parâmetro "alunoNovo": aluno que deverá ser inserido na árvore.
    public void inserir(Aluno alunoNovo)
    {
      //  this.raiz = adicionar(this.raiz, alunoNovo);
    }


    private NodoPessoa antecessor(NodoPessoa alunoRetirar, NodoPessoa raizArvore)
    {
        /// Se o antecessor do nó que deverá ser retirado da árvore ainda não foi encontrado...
        if (raizArvore.direita != null)
        {
            /// Pesquise o antecessor na sub-árvore direita.
            raizArvore.direita = antecessor(alunoRetirar, raizArvore.direita);
            return raizArvore;
        }
        /// O antecessor do nó que deverá ser retirado da árvore foi encontrado.
        else
        {
            /// O antecessor do nó que deverá ser retirado da árvore foi localizado e deverá substitui-lo.
           // alunoRetirar.item.setNumMatricula(raizArvore.item.getNumMatricula());
           // alunoRetirar.item.setNome(raizArvore.item.getNome());
           // alunoRetirar.item.setNota(raizArvore.item.getNota());
            /// A raiz da árvore ou sub-árvore é atualizada com os descendentes à esquerda do antecessor.
            /// Ou seja, retira-se o antecessor da árvore.
            return raizArvore.esquerda;
        }
    }

    /// Método recursivo responsável por localizar um aluno na árvore e retirá-lo da árvore.
    /// Parâmetro "raizArvore": raiz da árvore ou sub-árvore da qual o aluno será retirado.
    /// Parâmetro "matricula": número de matrícula do aluno que deverá ser localizado e removido da árvore.
    /// Retorna a raiz atualizada da árvore ou sub-árvore da qual o aluno foi retirado; ou null, caso não tenha sido localizado aluno com o número de matrícula informado.
    private NodoPessoa retirar(NodoPessoa raizArvore, int matricula)
    {
        /// Se a raiz da árvore ou sub-árvore for null, a árvore está vazia e o aluno, que deveria ser retirado dessa árvore, não foi encontrado.
        /// Nesse caso, deve-se retornar null.
        if (raizArvore == null)
        {
        	 System.out.println("O aluno, cuja matrícula é " + matricula + ", não foi encontrado.");
            return raizArvore;
        }
        else
        {
            /// O número de matrícula do aluno armazenado na raiz da árvore é igual ao número de matrícula do aluno que deve ser retirado dessa árvore.
            /// Ou seja, o aluno que deve ser retirado da árvore foi encontrado.
            if (raizArvore.item.localizar(matricula).getId() == matricula)
            {
                /// O nó da árvore que será retirado não possui descendentes à direita.
                /// Nesse caso, os descendentes à esquerda do nó que está sendo retirado da árvore passarão a ser descendentes do nó-pai do nó que está sendo retirado.
                if (raizArvore.direita == null)
                    return (raizArvore.esquerda);
                else
                    /// O nó da árvore que será retirado não possui descendentes à esquerda.
                    /// Nesse caso, os descendentes à direita do nó que está sendo retirado da árvore passarão a ser descendentes do nó-pai do nó que está sendo retirado.
                    if (raizArvore.esquerda == null)
                        return (raizArvore.direita);
                    else
                    {
                        /// O nó que está sendo retirado da árvore possui descendentes à esquerda e à direita.
                        /// Nesse caso, o antecessor do nó que está sendo retirado é localizado na sub-árvore esquerda desse nó. 
                        /// O antecessor do nó que está sendo retirado da árvore corresponde
                        /// ao nó que armazena o aluno cujo número de matrícula é o maior, 
                        /// dentre os números de matrícula menores do que o número de matrícula do nó que está sendo retirado.
                        /// Depois de ser localizado na sub-árvore esquerda do nó que está sendo retirado, 
                        /// o antecessor desse nó o substitui.
                        /// A sub-árvore esquerda do nó que foi retirado é atualizada com a remoção do antecessor.
                        raizArvore.esquerda = antecessor(raizArvore, raizArvore.esquerda);
                        /// Retorna a raiz atualizada da árvore ou sub-árvore da qual o aluno foi retirado.
                        return (raizArvore);
                    }
            }
            else
            {
                /// Se o número de matrícula do aluno armazenado na raiz da árvore for maior do que o número de matrícula do aluno que deverá ser localizado e retirado da árvore:
                /// pesquise e retire esse aluno da sub-árvore esquerda.
                if (raizArvore.item.localizar(matricula).getId() > matricula)
                    raizArvore.esquerda = retirar(raizArvore.esquerda, matricula);
                else
                    /// Se o número de matrícula do aluno armazenado na raiz da árvore for menor do que o número de matrícula do aluno que deverá ser localizado e retirado da árvore:
                    /// pesquise e retire esse aluno da sub-árvore direita.
                    raizArvore.direita = retirar(raizArvore.direita, matricula);
                /// Retorna a raiz atualizada da árvore ou sub-árvore da qual o aluno foi retirado.
                return raizArvore;
            }
        }
    }

    /// Método que encapsula a retirada recursiva de um aluno da árvore.
    /// Parâmetro "matriculaRemover": número de matrícula do aluno que deverá ser localizado e removido da árvore.
    public void remover(int matriculaRemover)
    {
        /// Chama o método recursivo "retirar", que será responsável por pesquisar o aluno, cujo número de matrícula foi passado como parâmetro, na árvore e retirá-lo da árvore.
        /// O método "retirar" receberá, como primeiro parâmetro, a raiz atual da árvore; e, como segundo parâmetro, o número de matrícula do aluno que deverá ser localizado e retirado dessa árvore.
        this.raiz = retirar(this.raiz, matriculaRemover);
    }
}
