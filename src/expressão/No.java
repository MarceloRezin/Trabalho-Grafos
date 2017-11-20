package expressão;

import java.lang.reflect.Array;
import java.util.Set;

import javax.xml.transform.SourceLocator;

public class No {
	
	private No esquerdo;
	private No direito;
	private String operacao;
	
	public No() {
		this.esquerdo = null;
		this.direito = null;
		this.operacao = null;
	}
	
	public No(No esquerdo, No direito, String operacao) {
		this.esquerdo = esquerdo;
		this.direito = direito;
		this.operacao = operacao;
	}

	public No getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(No esquerdo) {
		this.esquerdo = esquerdo;
	}

	public No getDireito() {
		return direito;
	}

	public void setDireito(No direito) {
		this.direito = direito;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	
	public String toString() {
		String dir;
		String esq;
		
		if(direito == null) {
			dir = "nulo";
		}else {
			dir = direito.toString();
		}
		
		if(esquerdo == null) {
			esq = "nulo";
		}else {
			esq = esquerdo.toString();
		}
		
		return "\nRaiz: " + operacao + "\nDireito: " + dir + "\nEsquerdo: " + esq + "\n";
	}	
	String expressaop = "";
	String expressaor = "";
	
	public String caminhoPolones(No no){
		if(no != null){
			//System.out.println(no.getOperacao());
			expressaop += no.getOperacao();
			caminhoPolones(no.esquerdo);
			caminhoPolones(no.direito);


        }
		return expressaop;
	}
	
	public String caminhoPolonesReversa(No no) {
		if(no != null){
        	caminhoPolonesReversa(no.esquerdo);
        	caminhoPolonesReversa(no.direito);        	
        	//System.out.println(no.getOperacao());
        	expressaor += no.getOperacao();
		}
		return expressaor;
	}
		
	String arv = "";
	public String imprimeArvore(No no) {
		
		if(no != null) {
			arv += no.operacao;	
			arv += "\n / \n";
			imprimeArvore(no.esquerdo);
			arv += "\n \\  \n";
			imprimeArvore(no.direito);
		}
		return arv;
		
	}
	
}


