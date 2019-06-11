package classes;

import estruturaLista.Lista;
import manipulacaoDados.ManipulaDados;

public class Indicador {

	private ManipulaDados manipulador;
	private float populacaoTotal;
	private float populacaoF;
	private float populacaoM;
	private float ate12;
	private float de13a19;
	private float de20a25;
	private float de26a30;
	private float de31a45;
	private float de46a65;
	private float mais65;
	private float rural;
	private float urbana;
	private float solteiro;
	private float casado;
	private float divorciado;
	private float viuvo;
	private float parda;
	private float preta;
	private float branca;
	private float amarela;
	private float indigena;
	private float totalIdadeF;
	private float totalIdadeM;
	private float totalIdadeRural;
	private float totalIdadeUrbana;
	private float totalIdadeSolteiro;
	private float totalIdadeCasado;
	private float mediaF;
	private float mediaM;
	private float mediaRural;
	private float mediaUrbana;
	private float mediaSolteiro;
	private float mediaCasado;
	private float desvioPadraoSolteiro;
	private float desvioPadraoCasado;

	public Indicador(ManipulaDados manipulador) {
		setManipulador(manipulador);
		setPopulacaoTotal(manipulador.populacaoTotal());
		setPopulacaoF(manipulador.getEstruturaLista().getLista("feminino").populacao());
		setPopulacaoM(manipulador.getEstruturaLista().getLista("masculino").populacao());
		setAte12(manipulador.getEstruturaLista().getLista("0a12").populacao());
		setDe13a19(manipulador.getEstruturaLista().getLista("13a19").populacao());
		setDe20a25(manipulador.getEstruturaLista().getLista("20a25").populacao());
		setDe26a30(manipulador.getEstruturaLista().getLista("26a30").populacao());
		setDe31a45(manipulador.getEstruturaLista().getLista("31a45").populacao());
		setDe46a65(manipulador.getEstruturaLista().getLista("46a65").populacao());
		setMais65(manipulador.getEstruturaLista().getLista("+65").populacao());
		setRural(manipulador.getEstruturaLista().getLista("rural").populacao());
		setUrbana(manipulador.getEstruturaLista().getLista("urbana").populacao());
		setSolteiro(manipulador.getEstruturaLista().getLista("solteiro").populacao());
		setCasado(manipulador.getEstruturaLista().getLista("casado").populacao());
		setDivorciado(manipulador.getEstruturaLista().getLista("divorciado").populacao());
		setViuvo(manipulador.getEstruturaLista().getLista("viuvo").populacao());
		setParda(manipulador.getEstruturaLista().getLista("parda").populacao());
		setPreta(manipulador.getEstruturaLista().getLista("preta").populacao());
		setBranca(manipulador.getEstruturaLista().getLista("branca").populacao());
		setAmarela(manipulador.getEstruturaLista().getLista("amarela").populacao());
		setIndigena(manipulador.getEstruturaLista().getLista("indigena").populacao());
		setMediaF(totalIdadeF/populacaoF);   /*************AQUI***************/
		setMediaM(totalIdadeM/populacaoM);   /*************AQUI***************/
		setMediaRural(totalIdadeRural/rural);
		setMediaUrbana(totalIdadeUrbana/urbana);
		setMediaSolteiro(totalIdadeSolteiro/solteiro);
		setMediaCasado(totalIdadeCasado/casado);
		setDesvioPadraoSolteiro(manipulador.getEstruturaLista().getLista("solteiro"));
		setDesvioPadraoCasado(manipulador.getEstruturaLista().getLista("casado"));
	}

	public void setManipulador(ManipulaDados manipulador) {
		this.manipulador = manipulador;
	}

	public float getPopulacaoTotal() {
		return populacaoTotal;
	}

	public void setPopulacaoTotal(float populacaoTotal) {
		this.populacaoTotal = populacaoTotal;
	}

	public float getPopulacaoF() {
		return populacaoF;
	}

	public void setPopulacaoF(float[] populacaoF) {
		this.populacaoF = populacaoF[0];
		this.totalIdadeF = populacaoF[1];
	}

	public float getPopulacaoM() {
		return populacaoM;
	}

	public void setPopulacaoM(float[] populacaoM) {
		this.populacaoM = populacaoM[0];
		this.totalIdadeM = populacaoM[1];
	}

	public float getAte12() {
		return ate12;
	}

	public void setAte12(float[] ate12) {
		this.ate12 = ate12[0];
	}

	public float getDe13a19() {
		return de13a19;
	}

	public void setDe13a19(float[] de13a19) {
		this.de13a19 = de13a19[0];
	}

	public float getDe20a25() {
		return de20a25;
	}

	public void setDe20a25(float[] de20a25) {
		this.de20a25 = de20a25[0];
	}

	public float getDe26a30() {
		return de26a30;
	}

	public void setDe26a30(float[] de26a30) {
		this.de26a30 = de26a30[0];
	}

	public float getDe31a45() {
		return de31a45;
	}

	public void setDe31a45(float[] de31a45) {
		this.de31a45 = de31a45[0];
	}

	public float getDe46a65() {
		return de46a65;
	}

	public void setDe46a65(float[] de46a65) {
		this.de46a65 = de46a65[0];
	}

	public float getMais65() {
		return mais65;
	}

	public void setMais65(float[] mais65) {
		this.mais65 = mais65[0];
	}

	public float getRural() {
		return rural;
	}

	public void setRural(float[] rural) {
		this.rural = rural[0];
		this.totalIdadeRural = rural[1];
	}

	public float getUrbana() {
		return urbana;
	}

	public void setUrbana(float[] urbana) {
		this.urbana = urbana[0];
		this.totalIdadeUrbana = urbana[1];
	}

	public float getSolteiro() {
		return solteiro;
	}

	public void setSolteiro(float[] solteiro) {
		this.solteiro = solteiro[0];
		this.totalIdadeSolteiro = solteiro[1];
	}

	public float getCasado() {
		return casado;
	}

	public void setCasado(float[] casado) {
		this.casado = casado[0];
		this.totalIdadeCasado = casado[1];
	}

	public float getDivorciado() {
		return divorciado;
	}

	public void setDivorciado(float[] divorciado) {
		this.divorciado = divorciado[0];
	}

	public float getViuvo() {
		return viuvo;
	}

	public void setViuvo(float[] viuvo) {
		this.viuvo = viuvo[0];
	}

	public float getParda() {
		return parda;
	}

	public void setParda(float[] parda) {
		this.parda = parda[0];
	}

	public float getPreta() {
		return preta;
	}

	public void setPreta(float[] preta) {
		this.preta = preta[0];
	}

	public float getBranca() {
		return branca;
	}

	public void setBranca(float[] branca) {
		this.branca = branca[0];
	}

	public float getAmarela() {
		return amarela;
	}

	public void setAmarela(float[] amarela) {
		this.amarela = amarela[0];
	}

	public float getIndigena() {
		return indigena;
	}

	public void setIndigena(float[] indigena) {
		this.indigena = indigena[0];
	}

	public float getTotalIdadeF() {
		return totalIdadeF;
	}

	public float getTotalIdadeM() {
		return totalIdadeM;
	}

	public float getTotalIdadeRural() {
		return totalIdadeRural;
	}

	public float getTotalIdadeUrbana() {
		return totalIdadeUrbana;
	}

	public float getTotalIdadeSolteiro() {
		return totalIdadeSolteiro;
	}

	public float getTotalIdadeCasado() {
		return totalIdadeCasado;
	}

	public float getMediaF() {
		return mediaF;
	}

	public void setMediaF(float mediaF) {
		this.mediaF = mediaF;
	}

	public float getMediaM() {
		return mediaM;
	}

	public void setMediaM(float mediaM) {
		this.mediaM = mediaM;
	}

	public float getMediaRural() {
		return mediaRural;
	}

	public void setMediaRural(float mediaRural) {
		this.mediaRural = mediaRural;
	}

	public float getMediaUrbana() {
		return mediaUrbana;
	}

	public void setMediaUrbana(float mediaUrbana) {
		this.mediaUrbana = mediaUrbana;
	}

	public float getMediaSolteiro() {
		return mediaSolteiro;
	}

	public void setMediaSolteiro(float mediaSolteiro) {
		this.mediaSolteiro = mediaSolteiro;
	}

	public float getMediaCasado() {
		return mediaCasado;
	}

	public void setMediaCasado(float mediaCasado) {
		this.mediaCasado = mediaCasado;
	}

	public float getDesvioPadraoSolteiro() {
		return desvioPadraoSolteiro;
	}

	public void setDesvioPadraoSolteiro(Lista listaSolteiro) {
		float variancia = listaSolteiro.variancia(mediaSolteiro);
		this.desvioPadraoSolteiro = (float) Math.sqrt(variancia/solteiro);
	}

	public float getDesvioPadraoCasado() {
		return desvioPadraoCasado;
	}

	public void setDesvioPadraoCasado(Lista listaCasado) {
		float variancia = listaCasado.variancia(mediaCasado);
		this.desvioPadraoCasado = (float) Math.sqrt(variancia/casado);
	}

}
