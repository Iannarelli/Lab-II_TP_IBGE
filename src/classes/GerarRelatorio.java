package classes;

import manipulacaoDados.ManipulaDados;

public class GerarRelatorio {
	private ManipulaDados manipulador;

	public GerarRelatorio(ManipulaDados manipulador) {
		setManipulador(manipulador);
	}

	public ManipulaDados getManipulador( ) {
		return manipulador;
	}

	public void setManipulador(ManipulaDados manipulador) {
		this.manipulador = manipulador;
	}

	public float populacaoTotal(){
		String op = "masculino", op1 = "feminino";
		return manipulador.getEstruturaLista().getLista(op).getPopulacao() + manipulador.getEstruturaLista().getLista(op1).getPopulacao();
	}
	
	public void taxaSexo(){
		String op = "masculino", op1 = "feminino";
		int i=0, fem=0, mas=0;
		while(i< populacaoTotal()) {
			if(manipulador.getEstruturaLista().getLista(op1).listaVazia() != null) {
				fem+=1;
			}
			if(manipulador.getEstruturaLista().getLista(op).listaVazia() != null) {
				mas+=1;
			}
			i++;
		}
	}
	
	public void EstadoCivil(){
		String op = "solteiro", op1 = "casado", op2 = "divorciado", op3 = "viuvo";
		int i=0, montante=0, sol=0, cas=0, div=0, viu=0;
		while(i< populacaoTotal()) {
			if(manipulador.getEstruturaLista().getLista(op).listaVazia() != null) {
				sol+=1;
			}
			if(manipulador.getEstruturaLista().getLista(op1).listaVazia() != null) {
				cas+=1;
			}
			if(manipulador.getEstruturaLista().getLista(op2).listaVazia() != null) {
				div+=1;
			}
			if(manipulador.getEstruturaLista().getLista(op3).listaVazia() != null) {
				viu+=1;
			}
			
			i++;
		}
	
	}

	public void Moradia(){
		String op = "rural", op1 = "urbano";
		int i=0, rur=0, urb=0;
		while(i< populacaoTotal()) {
			if(manipulador.getEstruturaLista().getLista(op).listaVazia() != null) {
				rur+=1;
			}
			if(manipulador.getEstruturaLista().getLista(op1).listaVazia() != null) {
				urb+=1;
			}
		}
	}
	
	public double faixaEtaria(){
		String op = "0a12", op1 = "13a19", op2 = "20a25", op3 = "26a30", op4 = "31a45", op5 = "46a65", op6 = "+65";
		int i=0;
		double montante;
		while(i< populacaoTotal()) {
			if(manipulador.getEstruturaLista().getLista(op).listaVazia() != null) 
				montante+= manipulador.getPessoa().getIdade();
	
			if(manipulador.getEstruturaLista().getLista(op1).listaVazia() != null) 
				montante+=manipulador.getPessoa().getIdade();
			
			if(manipulador.getEstruturaLista().getLista(op2).listaVazia() != null) 
				montante+=manipulador.getPessoa().getIdade();
			
			if(manipulador.getEstruturaLista().getLista(op3).listaVazia() != null) 
				montante+=manipulador.getPessoa().getIdade();
			if(manipulador.getEstruturaLista().getLista(op4).listaVazia() != null)
				montante+=manipulador.getPessoa().getIdade();
			if(manipulador.getEstruturaLista().getLista(op5).listaVazia() != null)
				montante+=manipulador.getPessoa().getIdade();
			if(manipulador.getEstruturaLista().getLista(op6).listaVazia() != null)
				montante+=manipulador.getPessoa().getIdade();
			i++;
		}
		return montante/
	
	}
	
	public void mediaIdade(){
		int i=0, montante=0;
		while(i< 21) {
			if()
		}
	}
	
	public void MediaIdesvioP() {
		int i=0, montante=0;
		while(i< 21) {
			if()
		}
	}
}
