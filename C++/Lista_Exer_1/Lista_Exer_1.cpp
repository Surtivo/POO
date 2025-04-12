// Lista_Exer_1.cpp : Este arquivo contém a função 'main'. A execução do programa começa e termina ali;

#define MAX 3

#include <iostream>
#include <cstdlib>
#include <ctime>
#include <random>

void exer_1() {
	
	int lado1, lado2, lado3;

	std::cout << "Digite o valor do lado 1: ";
	std::cin >> lado1;
	std::cout << "Digite o valor do lado 2: ";
	std::cin >> lado2;
	std::cout << "Digite o valor do lado 3: ";
	std::cin >> lado3;
	
	int soma = lado1 + lado2 + lado3;

	if (lado1 < soma && lado2 < soma && lado3 < soma) {
		std::cout << "Os valores formam um triangulo\n";
		if (lado1 == lado2 && lado2 == lado3) {
			std::cout << "Triangulo Equilatero";
		}
		else if (lado1 == lado2 || lado2 == lado3 || lado1 == lado3) {
			std::cout << "Triangulo Isosceles\n";
		}
		else {
			std::cout << "Triangulo Escaleno\n";
		}
	}
	else {
		std::cout << "Os valores nao formam um triangulo\n";
		return;
	}

}

void exer_2() {
	int notas[MAX];
	std::string alunos[MAX];
	int soma = 0;

	for (int i = 0; i < MAX; i++) {
		std::cout << "Digite o nome do aluno: ";
		std::cin >> alunos[i];
		std::cout << "Digite a nota do aluno: ";
		std::cin >> notas[i];
		soma += notas[i];
	}
	
	float media = soma / MAX;
	std::cout << "A media da turma e: " << media << "\n";
	
	for (int i = 0; i < MAX; i++) {
		if (notas[i] >= 7) {
			std::cout << "O aluno " << alunos[i] << " foi aprovado\n";
		}
		else {
			std::cout << "O aluno " << alunos[i] << " foi reprovado\n";
		}
	}
}

// Função para verificar se há um vencedor
bool verificaVencedor(char tabuleiro[3][3], char jogador) {
	// Verifica linhas e colunas
	for (int i = 0; i < 3; i++) {
		if ((tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) || // Linha
			(tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador)) { // Coluna
			return true;
		}
	}

	// Verifica diagonais
	if ((tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[0][0] == tabuleiro[2][2] && tabuleiro[2][2] == jogador) || // Diagonal principal
		(tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[0][2] == tabuleiro[2][0] && tabuleiro[0][2] == jogador)) { // Diagonal secundária
		return true;
	}

	return false;
}
bool verificaVelha(char tabuleiro[3][3]) {
	int num = 0;
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			if (tabuleiro[i][j] != '-')
				num++;
		}
	}
	if (num == 9)
		return true;
	else return false;
}
void exer_3(){
	srand(time(0));
	char tabuleiro[3][3];
	
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			tabuleiro [i][j] = '-';
		}
	}

	int linha, coluna, inicio;

	inicio = rand() % 1;

	while (true) {

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				std::cout << tabuleiro[i][j] << "  ";
			}
			std::cout << "\n";
		}
		std::cout << "\n";

		if (verificaVencedor(tabuleiro, 'X') == true) {
			std::cout << "Jogador vence!\n\n";
			break;
		}
		else if (verificaVencedor(tabuleiro, 'O') == true) {
			std::cout << "Computador vence!\n\n";
			break;
		}
		else if (verificaVelha(tabuleiro) == true) {
			std::cout << "Deu velha!\n\n";
			break;
		}

		if (inicio == 1) {
			while (true) {
				inicio = 0;
				std::cout << "Digite a linha: ";
				std::cin >> linha;
				std::cout << "Digite a coluna: ";
				std::cin >> coluna;

				if (tabuleiro[linha][coluna] == '-') {
					tabuleiro[linha][coluna] = 'X';
					break;
				}
				else {
					std::cout << "Posicao ja ocupada\n\n";
				}
			}
		}
		else {
			while (true) {
				inicio = 1;
				linha = rand() % 3;
				coluna = rand() % 3;
				if (tabuleiro[linha][coluna] == '-') {
					tabuleiro[linha][coluna] = 'O';
					break;
				}
			}
		}
	}
}

void exer_4() {
	std::srand(time(0));
	int dado1, dado2;
	int soma1 = 0;
	int soma2 = 0;
	int matriz[6][6] = { 0 };

	std::cout << "------- Primeita matriz --------\n\n";

	for (int i = 0; i < 36000; i++) {
		dado1 = rand() % 6;
		dado2 = rand() % 6;

		matriz[dado1][dado2]++;
	}

	for (int i = 0; i < 6; i++) {
		for (int j = 0; j < 6; j++) {
			soma1 += matriz[i][j];
			std::cout << matriz[i][j] << "\t";
			matriz[i][j] = 0;	// Zerando a matriz para a proxima iteração;
		}
		std::cout << "\n";
	}

	std::cout << "\n\n------- Segunda matriz --------\n\n";

	std::random_device rd;  // Gera uma semente aleatória com base em hardware;
	std::mt19937 gen(rd());  // Inicializa o motor de números aleatórios (Mersenne Twister) com a semente gerada;
	std::uniform_int_distribution<int> dist(0, 5);  // Define a distribuição uniforme entre 0 e 6;


	for (int i = 0; i < 36000; i++) {
		dado1 = dist(gen);
		dado2 = dist(gen);

		matriz[dado1][dado2]++;
	}

	for (int i = 0; i < 6; i++) {
		for (int j = 0; j < 6; j++) {
			soma2 += matriz[i][j];
			std::cout << matriz[i][j] << "\t";
		}
		std::cout << "\n";
	}

	std::cout << "\n\nA soma da primeira matriz e: " << soma1 << "\nA soma da segunda matriz e: " << soma2 << "\n\n";
}


int main()
{
	//exer_1();
	//exer_2();
	exer_3();
	//exer_4();
}
