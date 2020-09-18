package fila;

import elemento.Elemento;

public class Fila {
	private Elemento primeiro;
	private Elemento ultimo;
	private int totalDeElementos = 0;

	public Fila() {
		this.primeiro = null;
		this.ultimo = null;
		this.totalDeElementos = 0;
	}

	// ================================================ Construtor
	// 2.1================
	
	public Fila(int v) {
		this.primeiro = new Elemento(v);
		ultimo = primeiro;
		this.totalDeElementos++;
	}

	// ================================================Construtor
	// 2.2================
	
	public Fila(Fila f) {
		
		Elemento clone = f.clonar();// retorna primeiro Elemento da fila do parâmnetro

		Fila auxFila = new Fila();// cria uma nova fila auxFila

		while (clone != null) { //Percorre o clone e enfileira na fila auxFila
			auxFila.enfileirar(clone.getValor());
			clone = clone.getProximo();
		}
		
		while (auxFila.primeiro != null) { // percorre a fila aux fila.
			this.enfileirar(auxFila.desenfileirar().getValor()); // desenfileira da fila auxFila e enfileira na fila original.
		}
	}

	// ================================================Construtor
	// 2.3================
	
	public Fila(int[] v) {
		this.primeiro = new Elemento(v[0]);
		this.ultimo = this.primeiro;
		totalDeElementos++;

		for (int i = 1; i < v.length; i++) {
			this.enfileirar(v[i]);
		}
	}

	// ================================================Método 3.1================
	
	public void enfileirar(int v) { // Igual ao do Eriko

		Elemento e = new Elemento(v);
		if (this.primeiro == null) {
			this.primeiro = e;
			this.ultimo = this.primeiro;
		}
		this.ultimo.setProximo(e);
		this.ultimo = e;
		this.totalDeElementos++;
	}

	// ================================================Método 3.2================
	
	public Elemento desenfileirar() {

		Elemento aux = this.primeiro;
		this.primeiro = this.primeiro.getProximo();
		totalDeElementos--;
		return aux;
	}

	// ================================================================
	
	public Elemento getPrimeiro() {
		return this.primeiro;
	}

	// ================================================================
	
	public Elemento getUltimo() {
		return this.ultimo;
	}

	// ================================================Método 3.13================
	
	public int getTamanho() {
		return totalDeElementos;
	}

	// ================================================Método 3.3================

	public void inserirPosicao(int v, int p) {
		Fila f = new Fila();

		// Desenfileira e enfileira da Fila original para a Fila f
		while (this.primeiro != null) {
			f.enfileirar(this.desenfileirar().getValor());
		}

		// Verifica se a posição é maior que totalDeElementos
		if (p > f.totalDeElementos - 1 || p < 0) {
			System.out.println("A posição " + p + " não existe nesta fila!\n");
		}

		int cont = 0;
		// Desenfileira e enfileira da Fila f para a Fila original
		while (f.primeiro != null) {

			// coloca o valor v na posição p
			if (cont == p) {
				this.enfileirar(v);
			}

			this.enfileirar(f.desenfileirar().getValor());
			cont++;
		}

	}

	// ================================================Método 3.4================
	
	public int valorPosicao(int p) {

		if (p < 0 || p > this.totalDeElementos - 1) {
			System.out.println("Posição " + p + " não existe nesta fila!\n");
		}

		Fila aux = new Fila();

		while (this.primeiro != null) {
			aux.enfileirar(this.desenfileirar().getValor());
		}

		int cont = 0;
		int valorRetorno = 0;
		while (aux.primeiro != null) {
			if (cont == p) {
				valorRetorno = aux.primeiro.getValor();
			}
			this.enfileirar(aux.desenfileirar().getValor());
			cont++;
		}

		return valorRetorno;
	}

	// ================================================Método 3.5================
	
	public void concatenar(Fila f) {
		
		Elemento clone = f.clonar();// retorna primeiro Elemento da fila do parâmnetro

		Fila auxFila = new Fila();// cria uma nova fila auxFila

		while (clone != null) { //Percorre o clone e enfileira na fila auxFila
			auxFila.enfileirar(clone.getValor());
			clone = clone.getProximo();
		}
		
		while (auxFila.primeiro != null) {
			this.enfileirar(auxFila.desenfileirar().getValor()); // Desenfileira e enfileira da fila auxFila para a fila original.
		}
	}

	// ================================================Método 3.6================
	
	public void inserirAposPosicao(int v, int p) {
		Fila f = new Fila();

		// Desenfileira e enfileira os Elementos da Fila original para a Fila f
		while (this.primeiro != null) {
			f.enfileirar(this.desenfileirar().getValor());
		}

		// Verifica se a posição é maior que totalDeElementos
		if (p > f.totalDeElementos - 1) {
			System.out.println("A posição " + p + " não existe nesta fila!\n");
		}

		int cont = 0;
		// Desenfileira e enfileira da Fila f para a Fila original
		while (f.primeiro != null) {

			// coloca o valor v na posição p
			if (cont == p) {
				this.enfileirar(f.desenfileirar().getValor());
				this.enfileirar(v);
			} else if (cont != p) {
				this.enfileirar(f.desenfileirar().getValor());

			} else {
				this.enfileirar(v);
			}
			cont++;
		}
	}

	// ================================================Método 3.7================

	public void inverter() {
		if (this.totalDeElementos == 0 || this.totalDeElementos == 1) { // Não inverte caso totalDeElementos seja igual a 0 ou 1.
			System.out.println("Impossível inverter pois não existe elementos ou existe apenas 1 elemento na fila!");
		}

		else { // Investe a fila caso tenha mais de 1 Elemento.

			Fila f = new Fila(this.desenfileirar().getValor()); // Cria uma fila f com o primeiro valor da fila original.
			Elemento aux = this.primeiro;

			while (aux != null) {
				f.preppend(this.desenfileirar()); // Inseri os Elementos da fila original na cabeça da fila f
				aux = this.primeiro;
			}

			aux = f.primeiro;
			while (aux != null) {
				this.enfileirar(f.desenfileirar().getValor()); //Inseri os Elementos da fila f na calda da fila original.
				aux = f.primeiro;
			}
		}
	}

	// ================================================Método 3.9================

	public void remover(int p) {

		if (p < 0 || p > this.totalDeElementos - 1 || this.totalDeElementos == 0) {
			System.out.println("A posição " + p + " não existe nesta fila ou a fila está vazia!");
		}
		else {
			Fila f = new Fila();

			if (p == 0) { // Verifica se é o primeiro da fila.
				this.desenfileirar();

				Elemento aux = this.primeiro;
				while (aux != null) {   //percorre 
					f.enfileirar(this.desenfileirar().getValor());
					aux = this.primeiro;
				}

				aux = f.primeiro;
				while (aux != null) {
					this.enfileirar(f.desenfileirar().getValor());
					aux = f.primeiro;
				}
			}

			else if (p == this.getTamanho() - 1) { // Verifica se é o último da fila.

				Elemento aux2 = this.primeiro;
				while (aux2 != null) {

					if (aux2.getProximo() == this.ultimo) {
						this.ultimo = aux2;
						aux2.setProximo(null);
						totalDeElementos--;
					}

					f.enfileirar(this.desenfileirar().getValor());
					aux2 = this.primeiro;
				}

				aux2 = f.primeiro;
				while (aux2 != null) {
					this.enfileirar(f.desenfileirar().getValor());
					aux2 = f.primeiro;
				}
			}

			else { // Verifica se é um elemeneto entre o primeiro e ultimo.
				Elemento aux3 = this.primeiro;

				int contador = 0; // 1
				while (aux3 != null) {
					
					if (contador == p) {
						this.desenfileirar();
					}

					f.enfileirar(this.desenfileirar().getValor());
					aux3 = this.primeiro;

					contador++;
				}

				aux3 = f.primeiro;
				while (aux3 != null) {
					this.enfileirar(f.desenfileirar().getValor());
					aux3 = f.primeiro;
				}
			}
		}

	}

	// ================================================Método 3.11================

	public Elemento clonar() {

		Fila f1 = new Fila(); // Usada para desenfileira e enfileirar na fila original.
		Fila f2 = new Fila(); // Usada para retornar o 1º Elemento.

		Elemento transferidor = null; // Usado p receber o Elemento desenfileirado da fila original.
		Elemento aux = this.primeiro;
		
		while (aux != null) { // Percorre a fila original
			transferidor = this.desenfileirar(); // transferidor guarda o primeiro Elemento desenfileirado.

			f1.enfileirar(transferidor.getValor()); //Enfileira em f1 o Elemento do transferidor.
			f2.enfileirar(transferidor.getValor()); //Enfileira em f2 o Elemento do transferidor.

			aux = this.primeiro;
		}

		aux = f1.primeiro;
		while (aux != null) { // Percorre a fila f1.
			this.enfileirar(f1.desenfileirar().getValor()); //Enfileira na fila original o 1º Elemento da fila f1.
			aux = f1.primeiro;
		}

		return f2.primeiro; // retorna o 1º Elemento da fila f2.
	}
	
	// ================================================Método 3.12================

	public int indice(int v) {
		int posicao = -1;
		boolean encontrol = false;

		if (this.totalDeElementos == 0) {
			System.out.println("Não existe Elementos nesta fila!");
		} else {
			Fila f = new Fila();
			Elemento aux = this.primeiro;

			int contador = 0;
			while (aux != null) {

				if (aux.getValor() == v && encontrol == false) {
					posicao = contador;
					encontrol = true;
				}

				f.enfileirar(this.desenfileirar().getValor());
				aux = this.primeiro;

				contador++;
			}

			aux = f.primeiro;
			while (aux != null) {
				this.enfileirar(f.desenfileirar().getValor());
				aux = f.primeiro;
			}
		}

		if (encontrol == false) {
			System.out.println("O valor " + 60 + " não existe nesta fila.");
		}

		return posicao;
	}

	// ================================================Método 3.14================

	public int[] array() {
		Elemento aux = this.primeiro;

		int v[] = new int[this.totalDeElementos];

		if (this.totalDeElementos == 0) {
			System.out.println("Esta fila não possui Elementos!");
		}

		else {
			int contador = 0;

			while (aux != null) { // Percorre a fila original.
				v[contador] = this.desenfileirar().getValor(); // Desenfileira da fila original e gera o vetor.

				contador++;

				aux = this.primeiro;
			}

			for (int i = 0; i < v.length; i++) { // Percorre o vetor
				this.enfileirar(v[i]); // Enfileira os valores do vetor na fila original.
			}
		}

		return v;
	}

	// ================================================Método 3.15================

	public boolean pertence(int v) {

		boolean pertence = false;// true

		if (this.totalDeElementos == 0) {
			System.out.println("Não existe Elementos nesta fila!");
		} else {
			Fila f = new Fila();
			
			Elemento aux = this.primeiro;

			while (aux != null) {

				if (aux.getValor() == v && pertence == false) {
					pertence = true;
				}

				f.enfileirar(this.desenfileirar().getValor());
				aux = this.primeiro;
			}

			aux = f.primeiro;
			while (aux != null) {
				this.enfileirar(f.desenfileirar().getValor());
				aux = f.primeiro;
			}
		}
		return pertence;
	}

	// ================================================Método 3.16================

	public void appendArray(int[] v) {

		int contador = 0;

		for (int i = 0; i < v.length; i++) {
			this.enfileirar(v[contador]);

			contador++;
		}
	}

	// ================================================Método 3.17================

	public void prependArray(int[] v) {

		for (int i = v.length - 1; i >= 0; i--) {// percorro o array
			this.preppend(new Elemento(v[i]));
		}
	}

	// ================================================Método 3.18================

	public void inserirFilaPosicao(Fila fila, int p) {
		if (p < 0 || p > this.getTamanho() - 1) {
			System.out.println("A posição " + p + " não existe nesta fila!\n");
		} else {

			Fila auxFP1 = new Fila(); // Fila que será desenfileirada para a fila do parametro.
			Fila auxFP2 = new Fila(); // Fila que será enfileirada na fila interna.

			Elemento transferi = null;

			Elemento aux = fila.primeiro;
			while (aux != null) { // Desenfileira da fila do paramentro para as filas auxFP1 e auxFP2.
				transferi = fila.desenfileirar(); // Desenfileira da fila do parametro p transferi
				auxFP1.enfileirar(transferi.getValor()); // Enfileira transferi na fila auxFP1.
				auxFP2.enfileirar(transferi.getValor()); // Enfileira transferi na fila auxFP1.
				aux = fila.primeiro;
			}

			aux = auxFP1.primeiro;
			while (aux != null) { // Desenfileira da fila auxFP1 para a fila do parametro.
				fila.enfileirar(auxFP1.desenfileirar().getValor()); // Desenfileira da fila auxFP1 para a fila do
																	// paramnetro.
				aux = auxFP1.primeiro;
			}

			Fila auxFI = new Fila(); // Fila que será desenfileirada para a fila interna.
			aux = this.primeiro;
			while (aux != null) { // Desenfileira da fila auxFP1 para a fila do parametro.
				auxFI.enfileirar(this.desenfileirar().getValor()); // Desenfileira da fila auxFP1 para a fila do
																	// paramnetro.
				aux = this.primeiro;
			}

			aux = auxFI.primeiro;
			int contador = 0;
			while (aux != null) {
				if (contador == p) {
					this.enfileirar(auxFI.desenfileirar().getValor());

					Elemento auxInserir = auxFP2.primeiro;
					while (auxInserir != null) {
						this.enfileirar(auxFP2.desenfileirar().getValor());
						auxInserir = auxFP2.primeiro;
					}
				}

				this.enfileirar(auxFI.desenfileirar().getValor());

				aux = auxFI.primeiro;
				contador++;
			}
		}
	}

	// ================================================Método 3.19================

	public void inserirArrayPosicao(int[] v, int p) {
		if (p < 0 || p > this.getTamanho() - 1) {
			System.out.println("\nA posição " + p + " não existe nesta fila!\n");
		} else {

			Fila f = new Fila();

			Elemento aux = this.primeiro;

			while (aux != null) {
				f.enfileirar(this.desenfileirar().getValor());
				aux = this.primeiro;
			}

			int contador = 0;
			aux = f.primeiro;
			while (aux != null) {

				if (contador == p) { // p = 3
					this.enfileirar(f.desenfileirar().getValor());

					int contador2 = 0;
					while (contador2 < v.length) {
						this.enfileirar(v[contador2]);
						contador2++;
					}
				}

				if (f.primeiro != null) {
					this.enfileirar(f.desenfileirar().getValor());
				}

				aux = f.primeiro;
				contador++;
			}
		}
	}

	// ================================================Método 3.20================

	public int contar(int v) {
		Elemento aux = this.primeiro;
		Fila f = new Fila();

		int contador = 0;
		while (aux != null) {
			if (aux.getValor() == v) {
				contador++;
			}
			f.enfileirar(this.desenfileirar().getValor());
			aux = this.primeiro;
		}

		aux = f.primeiro;
		while (aux != null) {
			this.enfileirar(f.desenfileirar().getValor());
			aux = f.primeiro;
		}
		return contador;
	}

	// ================================================Método 3.10================
	public void esvaziar() {
		if (this.totalDeElementos == 0) {
			System.out.println("A fila já está vazia!");
		} else {

			this.primeiro = null;
			this.ultimo = null;
			this.totalDeElementos = 0;
		}
	}

	// ================================================Métodos
	// auxiliares================
	public void preppend(Elemento e) {
		Elemento aux = e;
		aux.setProximo(primeiro);
		this.primeiro = aux;
		totalDeElementos++;
	}

	public void imprime() {
		Elemento aux = this.primeiro;
		while (aux != null) {
			aux.imprime();
			aux = aux.getProximo();
		}
		System.out.println("-Total de Elementos: " + getTamanho());
		System.out.println("==========================================\n");
	}

}
