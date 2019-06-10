package estruturaLista;

import java.util.Vector;

public final class EstruturaLista {

	private Lista[] listas = new Lista[20];
		
	private Vector<String> caracteristicas = new Vector<String>();
	
	public EstruturaLista() {
		caracteristicas.add("masculino");
		caracteristicas.add("feminino");
		caracteristicas.add("solteiro");
		caracteristicas.add("casado");
		caracteristicas.add("divorciado");
		caracteristicas.add("viuvo");
		caracteristicas.add("parda");
		caracteristicas.add("preta");
		caracteristicas.add("branca");
		caracteristicas.add("amarela");
		caracteristicas.add("indigena");
		caracteristicas.add("rural");
		caracteristicas.add("urbana");
		caracteristicas.add("0a12");
		caracteristicas.add("13a19");
		caracteristicas.add("20a25");
		caracteristicas.add("26a30");
		caracteristicas.add("31a45");
		caracteristicas.add("46a65");
		caracteristicas.add("+65");
		for(int i=0;i<20;i++)
			listas[i] = new Lista();
	}

	public Lista getLista(String opcao) {
		return listas[caracteristicas.indexOf(opcao)];
	}
}
