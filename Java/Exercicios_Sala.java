import java.util.Scanner;
import java.util.Random;

public class Exercicios_Sala {
	
	public static final int CONST = 3;
	
	public static void exer_1 () {
		System.out.println("Digite tres valores:");
		Scanner input = new Scanner(System.in);
		System.out.print("Valor 1: ");
		int face1 = input.nextInt();
		input.nextLine();	// Limpa buffer
		System.out.print("Valor 2: ");
		int face2 = input.nextInt();
		input.nextLine();	// Limpa buffer
		System.out.print("Valor 3: ");
		int face3 = input.nextInt();
		input.nextLine();	// Limpa buffer
		
		if (face1 == face2 && face1 == face3)
			System.out.println("O trinagulo e equilatero");
		else if(face1 == face2 || face2 == face3 || face3 == face1)
			System.out.println("O triangulo e isosceles!");
		else if (face1 != face2 && face1 != face3 && face2 != face3)
			System.out.println("O trinagulo e escaleno");
		
		input.close();
	}
	
	public static void exer_2 () {
		int [] notas = new int [CONST];
		String [] alunos = new String [CONST];
		
		Scanner input = new Scanner(System.in);
		System.out.println("De o nome de um aluno e diga sua nota:");
		
		int aux = 0;
		
		while (aux < CONST) {
			String nome = input.nextLine();
			int nota = input.nextInt();
			input.nextLine();	// Limpa buffer
			
			alunos[aux] = nome;
			notas[aux] = nota;
			aux++;
			
		}
		
		aux = 0;
		int max = 0;
		while (aux != CONST) {
			max = max + notas[aux];
			aux++;
		}
		System.out.println("Media das notas = " + max/CONST);
		
		aux = 0;
		while (aux < CONST) {
			if(notas[aux] >= 7)
				System.out.println("Aluno " + alunos[aux] + " aprovado!");
			else
				System.out.println("Aluno " + alunos[aux] + " reprovado!");
			aux++;
		}
		
		input.close();
	}

// Função para verificar se há um vencedor
public static boolean verificaVencedor(char[][] tabuleiro, char jogador) {
    // Verifica linhas e colunas
    for (int i = 0; i < 3; i++) {
        if ((tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) || // Linha
            (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador)) { // Coluna
            return true;
        }
    }

    // Verifica diagonais
    if ((tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) || // Diagonal principal
        (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador)) { // Diagonal secundária
        return true;
    }
    
    return false;
}

	public static void exer_3 () {
		Scanner input = new Scanner(System.in);
		
		char tabuleiro [][] = new char [3][3];
		Random generator = new Random();
		int x, y, x_maq, y_maq;

		int iniciar = generator.nextInt(1);
		for(int i = 0; i<3; i++){
			for(int j = 0; j<3; j++){
				tabuleiro[i][j] = '-';
			}
		}

		while(true){

			if(iniciar == 0){
				
				while(true){
					System.out.println("Digite a posição que deseja usar (digite a linha e depois):");
					x = input.nextInt();
					input.nextLine();	// Limpa buffer
					y = input.nextInt();
					input.nextLine();	// Limpa buffer
	
					if(tabuleiro [x][y] == 'x' || tabuleiro [x][y] == 'o')
						System.out.println("Espaço ocupado. Digite outra posição!");
					else break;
				}

				tabuleiro[x][y] = 'x';
				for(int i = 0; i<3; i++){
					for(int j = 0; j<3; j++){
						System.out.print(tabuleiro[i][j]);
					}
					System.out.print("\n");
				}
				System.out.print("\n");

				while(true){
					x_maq = generator.nextInt(3);
					y_maq = generator.nextInt(3);
	
					if(tabuleiro [x_maq][y_maq] == 'x' || tabuleiro [x_maq][y_maq] == 'o');
					else break;
				}

				tabuleiro[x_maq][y_maq] = 'o';
				for(int i = 0; i<3; i++){
					for(int j = 0; j<3; j++){
						System.out.print(tabuleiro[i][j]);
					}
					System.out.print("\n");
				}
				System.out.print("\n");

			}else {
				while(true){
					x_maq = generator.nextInt(3);
					y_maq = generator.nextInt(3);
	
					if(tabuleiro [x_maq][y_maq] == 'x' || tabuleiro [x_maq][y_maq] == 'o');
					else break;
				}

				tabuleiro[x_maq][y_maq] = 'o';
				for(int i = 0; i<3; i++){
					for(int j = 0; j<3; j++){
						System.out.print(tabuleiro[i][j]);
					}
					System.out.print("\n");
				}
				System.out.print("\n");

				while(true){
					System.out.println("Digite a posição que deseja usar (digite a linha e depois):");
					x = input.nextInt();
					input.nextLine();	// Limpa buffer
					y = input.nextInt();
					input.nextLine();	// Limpa buffer
	
					if(tabuleiro [x][y] == 'x' || tabuleiro [x][y] == 'o')
						System.out.println("Espaço ocupado. Digite outra posição!");
					else break;
				}

				tabuleiro[x][y] = 'x';
				for(int i = 0; i<3; i++){
					for(int j = 0; j<3; j++){
						System.out.print(tabuleiro[i][j]);
					}
					System.out.print("\n");
				}
				System.out.print("\n");
			}

		if (verificaVencedor(tabuleiro, 'x')) {
			System.out.println("Jogador ganhou!");
			break;
		} else if (verificaVencedor(tabuleiro, 'o')) {
			System.out.println("Computador ganhou!");
			break;
		}
				
		}

		input.close();
	}


	public static void exer_4(){
		int tabuleiro [][] = new int [6][6];
		for(int i = 0; i<6; i++){
			for(int j = 0; j<6; j++){
				tabuleiro[i][j] = 0;
			}
		}

		Random generator = new Random();
		int dado1, dado2;

		for(int i = 0; i<36000; i++){
			dado1 = generator.nextInt(6);
			dado2 = generator.nextInt(6);
			tabuleiro[dado1][dado2]++;
		}

		for(int i = 0; i<6; i++){
			for(int j = 0; j<6; j++){
				System.out.print(tabuleiro[i][j] + "\t");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args) {
		exer_4();
	}

}