package expressão;

import java.util.Stack;

public class No {
	
	private No esquerdo;
	private No direito;
	private String operacao;
	private String expressaop = "";
	private String expressaor = "";
	
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
	
	public String caminhoPolones(No no){
		if(no != null){
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
        	expressaor += no.getOperacao();
		}
		return expressaor;
	}	
	
	public String imprimeArvore(No no) {
		Stack<No> globalStack = new Stack<>();
	      globalStack.push(no) ;
	      int nQuebraLinha = 1;
	      boolean isLinhaVazia = false;
	      String arv ="";

	      while(isLinhaVazia==false)
	         {
	         Stack<No> localStack = new Stack<>();
	         isLinhaVazia = true;

	          for(int j=0; j<nQuebraLinha; j++) {
	        	  arv += " \n";
	          }
	          
	         while(globalStack.empty()==false){
	            No temp = globalStack.peek(); //Armazena o topo da pilha
	            globalStack.pop();
	            if(temp != null){
	            	
	            	arv += temp.operacao; 
	            	localStack.push(temp.esquerdo);
	            	localStack.push(temp.direito);	               

	               if(temp.esquerdo != null ||  temp.direito != null)
	                  isLinhaVazia = false;
	               }
	            else{
	            	arv += "--";
	               localStack.push(null);
	               localStack.push(null);
	              }
	            for(int j=0; j<nQuebraLinha*2; j++)
	            	arv += " ";
	            }
	         
	         while(localStack.empty()==false)
	            {
	            globalStack.push( localStack.peek() );
	            localStack.pop();
	            }	         
	         arv +="\n";
	         }
		return arv;
	}
	
}


