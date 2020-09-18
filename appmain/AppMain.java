package appmain;

import java.util.Random;

import elemento.Elemento;
import fila.Fila;

public class AppMain {

	public static int gerarNumero() {
		Random rand = new Random();
		int limite = 100;
		int int_random = rand.nextInt(limite);
		return int_random;
	}

	public static void main(String[] args) {
		// =============================================================================================

		System.out.println("2.1 Fila(int v) \n");

		Fila fila1 = new Fila(gerarNumero());

		for (int i = 0; i < 2; i++) {
			fila1.enfileirar(gerarNumero());
		}
		System.out.println("fila1:");
		fila1.imprime();
		// =============================================================================================

		System.out.println("2.2 Fila(Fila fila) \n");
		Fila fila2 = new Fila(fila1);

		System.out.println("fila1 (fila passada como parâmetro): ");
		fila1.imprime();

		System.out.println("fila2 (criada a partir da fila1):");
		fila2.imprime();

		// =============================================================================================

		System.out.println("2.3 Fila(int[] v)  \n");
		int vetor[] = new int[5];

		System.out.println("vetor[] (vetor que será passado como parâmetro):");

		for (int i = 0; i < vetor.length; i++) {
			vetor[i] = gerarNumero();
			System.out.println("vetor[" + i + "]: " + vetor[i]);
		}

		Fila vetorFila = new Fila(vetor);
		System.out.println("\nvetorFila (fila criada a partir do vetor vetor[]):");
		vetorFila.imprime();
		// =============================================================================================

		System.out.println("3.1 enfileirar(int v) \n");

		int enf = gerarNumero();

		System.out.println("valor enfileirado: " + enf);

		fila2.enfileirar(enf);
		System.out.println("\nfila2:");
		fila2.imprime();
		// =============================================================================================

		System.out.println("3.2 desenfileirar() \n");
		Elemento valor = fila2.desenfileirar();
		System.out.println("Elemento desenfileirado com valor: " + valor.getValor() + "\n");
		System.out.println("fila2:");
		fila2.imprime();
		// =============================================================================================

		System.out.println("3.3 inserirPosicao(int v, int p) \n");
		fila2.inserirPosicao(10, -1);
		System.out.println("fila2:");
		fila2.imprime();

		// =============================================================================================

		System.out.println("3.4 valorPosicao(int p) \n");
		int p = 3;
		int valorPosicao = fila2.valorPosicao(p);
		System.out.println("Posição Consultada: " + p + "\nValor da Posição consultada: " + valorPosicao + "\n");
		System.out.println("fila2:");
		fila2.imprime();

		// =============================================================================================

		System.out.println("3.5 concatenar(Fila fila) \n");

		fila2.concatenar(vetorFila);

		System.out.println("vetorFila (fila passada como parâmetro):");
		vetorFila.imprime();

		System.out.println("fila2:");
		fila2.imprime();

		// =============================================================================================

		System.out.println("3.6 inserirAposposicao(int v, int p) \n");
		
		int val = 99;
		int po = 7;
		
		System.out.println("Inserir valor " + val + " na posição " + po + ".\n");
		
		fila2.inserirAposPosicao(val, po);
		System.out.println("fila2:");
		fila2.imprime();

		// =============================================================================================

		System.out.println("3.7 inverter() \n");
		fila2.inverter();
		System.out.println("fila2:");
		fila2.imprime();

		// =============================================================================================

		System.out.println("3.9 remover(int p) \n");
		int posic = 7;

		System.out.println("\nPosição removida: " + posic);
		fila2.remover(posic);

		System.out.println("\nfila2:");
		fila2.imprime();

		// =============================================================================================

		System.out.println("3.11 clonar() \n");
		Elemento clone = fila2.clonar();

		System.out.println("Impressão do clone da fila2:");
		clone.imprime();

		System.out.println("\nfila2:");
		fila2.imprime();

		// =============================================================================================

		System.out.println("3.12 indice(int v) \n");
		int num = 60;

		System.out.println("Valor consultado: " + num + "\n");

		int indice = fila2.indice(num);

		if (indice == -1) {
			System.out.println("\nÍndice não existe!" + "\n");
		} else {
			System.out.println("\nÍndice: " + indice + "\n");
		}

		System.out.println("\nfila2:");
		fila2.imprime();

		// =============================================================================================

		System.out.println("3.14 array() \n");

		/*
		 * Fila teste = new Fila(10); teste.enfileirar(20); teste.enfileirar(30);
		 * teste.imprime();
		 */

		int[] vet = fila2.array();
		
		System.out.println("\nfila2:");
		fila2.imprime();

		System.out.println("array da fila2:");
		for (int i = 0; i < vet.length; i++) {
			System.out.println("vet[" + i + "]: " + vet[i]);
		}
		System.out.println("-Tamanho do vetor: " + vet.length);
		System.out.println("==========================================\n");

		

		// =============================================================================================

		System.out.println("3.15 pertence(int v) \n");
		
		int valorPertence = 25;
		
		boolean result = fila2.pertence(valorPertence);

		System.out.println("O valor "+valorPertence + " Pertence a fila? " + result);

		System.out.println("\nfila2:");
		fila2.imprime();

		// =============================================================================================

		System.out.println("3.16 appendArray(int[] v) \n");

		int arrayAppend[] = new int[3];

		for (int i = 0; i < arrayAppend.length; i++) {
			arrayAppend[i] = gerarNumero();
		}

		System.out.println("\narrayAppend (array passado como parâmetro):");
		for (int i = 0; i < arrayAppend.length; i++) {
			System.out.println("v[" + i + "]: " + arrayAppend[i]);
		}

		fila2.appendArray(arrayAppend);

		System.out.println("\nfila2:");
		fila2.imprime();

		// =============================================================================================

		System.out.println("3.17 prependArray(int[] v) \n");

		int arrayPrepend[] = new int[3];

		for (int i = 0; i < arrayPrepend.length; i++) {
			arrayPrepend[i] = gerarNumero();
		}

		System.out.println("\narrayAppend (array passado como parâmetro):");
		for (int i = 0; i < arrayPrepend.length; i++) {
			System.out.println("v[" + i + "]: " + arrayPrepend[i]);
		}

		fila2.prependArray(arrayPrepend);

		System.out.println("\nfila2:");
		fila2.imprime();

		// =============================================================================================

		System.out.println("3.18 inserirFilaPosição(Fila fila, int p) \n");

		Fila fila3 = new Fila(gerarNumero());

		for (int i = 0; i < 2; i++) {
			fila3.enfileirar(gerarNumero());
		}

		System.out.println("fila3:");
		fila3.imprime();

		System.out.println("\nfila2 (fila passada como parâmetro):");
		fila2.imprime();

		int posi = 17;
		System.out.println("Inserir na posição: " + posi + "\n");

		fila3.inserirFilaPosicao(fila2, posi);

		System.out.println("fila3 atualizada:");
		fila3.imprime();

		// =============================================================================================

		System.out.println("3.19 inserirArrayPosição(int[] v, int p) \n");

		int vetorAposPosicao[] = new int[3];

		int pos = 15;
		System.out.println("Inserir na posição: " + pos + "\n");
		
		System.out.println("vetores criados:");
		for (int i = 0; i < vetorAposPosicao.length; i++) {
			vetorAposPosicao[i] = gerarNumero();
			System.out.println("vetorAposPosicao[" + i + "]: " + vetorAposPosicao[i]);
		}

		fila3.inserirArrayPosicao(vetorAposPosicao, pos);

		System.out.println("\nfila3:");
		fila3.imprime();

		// =============================================================================================

		System.out.println("3.20 contar() \n");
		int v = 10;
		System.out.println("O valor " + v + " aparece " + fila2.contar(v) + " vez(es) na fila.\n");
		System.out.println("fila2:");
		fila2.imprime();

		// =============================================================================================
		System.out.println("3.10 esvaziar() \n");
		fila1.esvaziar();
		System.out.println("\nfila1:");
		fila1.imprime();
	}
}
