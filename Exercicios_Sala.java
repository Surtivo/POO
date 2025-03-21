import java.util.Scanner;

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
		int [] notas = new int [10];
		String [] alunos = new String [10];
		
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
	
	public static void main(String[] args) {
		exer_2();
	}

}
