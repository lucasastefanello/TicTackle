package model;

public class VerificaVencedor {
	
	char[][] matriz; // The puzzle representation.
	String combinacao; // The words to find.
	
	VerificaVencedor(char[][] puzzle,  String toFind) {
		this.matriz = puzzle;
		this.combinacao = toFind;
	}

	// Passes each word to find.
	public boolean solve() { 
		return procurar(combinacao);
	}
	
	// Searches for first letter until match is found or array is exhausted.
	public boolean procurar(String padrao) { 
		boolean achadoPadrao = false;
		int tamanho = matriz[0].length; // Puzzle dimensions.
		for (int linha = 0; linha < tamanho; linha++) {
			for (int coluna = 0; coluna < tamanho; coluna++) {
				if (achadoPadrao == false && matriz[linha][coluna] == padrao.charAt(0)) { // Assumes the puzzle only contains the match once.
					achadoPadrao = confirmar(padrao, linha, coluna);
				}
			}
		}
		if (achadoPadrao == false){
			System.out.println(padrao + " not found");
			return false;
		}else{
			System.out.println(padrao + " found");
			return true;
		}
	}
	
	// Searches all eight directions from a first letter match passed by Find().
	// Algorithm is efficient, but lots of repeated code. Consider a recursive solution.
	public boolean confirmar(String padrao, int linha, int coluna) { 
		boolean descoberto = false;
		int tamanho = padrao.length(); // We will only search in directions that have at least this much space. 
		
		if ((coluna - tamanho) >= -1) { // The word can exist to the left.
			int posicao = 0;
			for (int i = coluna; i >= (coluna - tamanho) + 1; i--) {
				if (padrao.charAt(posicao) != matriz[linha][i]) {
					break;
				}
				if (i == (coluna - tamanho) + 1) { // A match was found
					descoberto = true;
					printMatch(padrao, linha, coluna, linha, i);
				}
				posicao++;
			}
		}
		
		if ((coluna + tamanho) <= matriz[0].length) { // The word can exist to the right
			int posicao = 0;
			for (int i = coluna; i <= (coluna + tamanho) - 1; i++) {
				if (padrao.charAt(posicao) != matriz[linha][i]) {
					break;
				}
				if (i == (coluna + tamanho) - 1) { // A match was found
					descoberto = true;
					printMatch(padrao, linha, coluna, linha, i);
				}
				posicao++;
			}
		}
		
		if ((linha - tamanho) >= -1) { // The word can exist above
			int posicao = 0;
			for (int i = linha; i >= (linha - tamanho) + 1; i--) {
				if (padrao.charAt(posicao) != matriz[i][coluna]) {
					break;
				}
				if (i == (linha - tamanho) + 1) { // A match was found
					descoberto = true;
					printMatch(padrao, linha, coluna, i, coluna);
				}
				posicao++;
			}
		}

		if ((linha + tamanho) <= matriz[0].length) { // The word can exist below
			int posicao = 0;
			for (int i = linha; i <= (linha + tamanho) - 1; i++) {
				if (padrao.charAt(posicao) != matriz[i][coluna]) {
					break;
				}
				if (i == (linha + tamanho) - 1) { // A match was found
					descoberto = true;
					printMatch(padrao, linha, coluna, i, coluna);
				}
				posicao++;
			}
		}
		
		if ((linha - tamanho) >= -1 && (coluna - tamanho) >= -1) { // The word can exist up and to the left
			int posicao = 0;
			int j = coluna;
			for (int i = linha; i >= (linha - tamanho) + 1; i--) {
				if (padrao.charAt(posicao) != matriz[i][j]) {
					break;
				}
				if (i == (linha - tamanho) + 1) { // A match was found
					descoberto = true;
					printMatch(padrao, linha, coluna, i, j);
				}
				posicao++;
				j--;
			}
		}
		
		if ((linha - tamanho) >= -1 && (coluna + tamanho) <= matriz[0].length) { // The word can exist up and to the right
			int posicao = 0;
			int j = coluna;
			for (int i = linha; i >= (linha - tamanho) + 1; i--) {
				if (padrao.charAt(posicao) != matriz[i][j]) {
					break;
				}
				if (i == (linha - tamanho) + 1) { // A match was found
					descoberto = true;
					printMatch(padrao, linha, coluna, i, j);
				}
				posicao++;
				j++;
			}
		}
		
		if ((linha + tamanho) <= matriz[0].length && (coluna - tamanho) >= -1) { // The word can exist down and to the left
			int posicao = 0;
			int j = coluna;
			for (int i = linha; i <= (linha + tamanho) - 1; i++) {
				if (padrao.charAt(posicao) != matriz[i][j]) {
					break;
				}
				if (i == (linha + tamanho) - 1) { // A match was found
					descoberto = true;
					printMatch(padrao, linha, coluna, i, j);
				}
				posicao++;
				j--;
			}
		}
		
		if ((linha + tamanho) <= matriz[0].length && (coluna + tamanho) <= matriz[0].length) { // The word can exist down and to the right
			int posicao = 0;
			int j = coluna;
			for (int i = linha; i <= (linha + tamanho) - 1; i++) {
				if (padrao.charAt(posicao) != matriz[i][j]) {
					break;
				}
				if (i == (linha + tamanho) - 1) { // A match was found
					descoberto = true;
					printMatch(padrao, linha, coluna, i, j);
				}
				posicao++;
				j++;
			}
		}
		
		return descoberto;
	}
	
	public void printMatch(String word, int startRow, int startColumn, int endRow, int endColumn) {
		System.out.println(word + " found at start: " + startRow + ", " + startColumn + " end: " + endRow + ", " + endColumn);
	}
}