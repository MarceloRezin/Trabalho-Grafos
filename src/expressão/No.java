package expressão;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

import javax.xml.transform.SourceLocator;

import telas.TelaPrincipal;

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
	
	public String imprimeArvore(No no) {
		Stack<No> globalStack = new Stack<>();
	      globalStack.push(no) ;
	      int nBlanks = 1;
	      boolean isRowEmpty = false;
	      String arv ="";

	      System.out.println("......................................................");
	      while(isRowEmpty==false)
	         {
	         Stack<No> localStack = new Stack<>();
	         isRowEmpty = true;

	          for(int j=0; j<nBlanks; j++)
	        	  arv += " \n";
	        	  System.out.println(" ");

	         while(globalStack.empty()==false){
	            No temp = globalStack.peek();
	            globalStack.pop();
	            if(temp != null){
	            	
	            	arv += temp.operacao;
	            	System.out.print(temp.operacao);  
	            	localStack.push(temp.esquerdo);
	            	localStack.push(temp.direito);	               

	               if(temp.esquerdo != null ||  temp.direito != null)
	                  isRowEmpty = false;
	               }
	            else
	               {
	            	arv += "--";
	               System.out.print("--");
	               localStack.push(null);
	               localStack.push(null);
	               }
	            for(int j=0; j<nBlanks*2; j++)
	            	arv += " ";
	               System.out.print(" ");
	            }  
	         System.out.println("");
	         //nBlanks /=2;
	         while(localStack.empty()==false)
	            {
	            globalStack.push( localStack.peek() );
	            localStack.pop();
	            }	         
	         arv +="\n";
	         }
	      System.out.println("......................................................");    
	      
		return arv;
	}
	
}


