#include <iostream>
#include <vector>
#include <iomanip>
#include <ctime>
#include <string>
#include <stdexcept>
#include <sstream>

// Corrigir nome do enum para bater com o resto do código
enum class tipoTransacao {
    CREDITO,
    DEBITO
};

class Transacao {
private:
    const tipoTransacao operacao;
    const std::time_t data;
    double valor;

public:
    Transacao(tipoTransacao operacao, std::time_t data, double valor)
        : operacao(operacao), data(data), valor(valor) {
    }

    tipoTransacao getTipoOperacao() const {
        return operacao;
    }

    std::time_t getData() const {
        return data;
    }

    double getValor() const {
        return valor;
    }
};

class Cliente {
private:
    const std::string cpf;
    std::string nome;
    std::string tel;

public:
    Cliente(const std::string& cpf, const std::string& nome)
        : cpf(cpf), nome(nome) {
    }

    std::string getNome() const {
        return nome;
    }

    void setNome(const std::string& nome) {
        this->nome = nome;
    }

    std::string getCpf() const {
        return cpf;
    }

    std::string getTel() const {
        return tel;
    }

    void setTel(const std::string& tel) {
        this->tel = tel;
    }
};

class Conta {
private:
    const int numero;
    const Cliente titular;
    std::vector<Transacao> transacoes;

public:
    Conta(int numero, const Cliente& titular)
        : numero(numero), titular(titular) {
    }

    int getNumero() const {
        return numero;
    }

    std::string getTitular() const {
        return "CPF: " + titular.getCpf() + " - Nome: " + titular.getNome();
    }

    double getSaldo() const {
        double saldo = 0.0;
        for (const Transacao& transacao : transacoes) {
            if (transacao.getTipoOperacao() == tipoTransacao::CREDITO) {
                saldo += transacao.getValor();
            }
            else if (transacao.getTipoOperacao() == tipoTransacao::DEBITO) {
                saldo -= transacao.getValor();
            }
        }
        return saldo;
    }

    void Depositar(double valor) {
        Transacao entrouTransacao(tipoTransacao::CREDITO, std::time(nullptr), valor);
        transacoes.push_back(entrouTransacao);
    }

    void Sacar(double valor) {
        Transacao saiuTransacao(tipoTransacao::DEBITO, std::time(nullptr), valor);
        transacoes.push_back(saiuTransacao);
    }

    std::string listarextrato() {
        std::ostringstream oss;
        oss << "\nExtrato da conta " << getNumero() << "\n\n";

        if (transacoes.empty())
            oss << "Nenhuma transação registrada\n";
        else {
            for (const Transacao& transacao : transacoes) {
                time_t data = transacao.getData();
                tm tm_data;
                localtime_s(&tm_data, &data);  // Versão segura
                oss << "Data: " << std::put_time(&tm_data, "%d/%m/%Y %H:%M:%S | ");
                oss << "Tipo: " << (transacao.getTipoOperacao() == tipoTransacao::CREDITO ? "CREDITO" : "DEBITO") << " | ";     //C++ não compila enum como um string (igual ao java), 
                oss << "Valor: R$" << transacao.getValor() << "\n\n";                                                          //então deve ser feito um operador ternário para                                                                                                                                                            
			}																												    //converter o enum em string                                            
            oss << "Saldo do dia: " << getSaldo() << "\n\n";
        }
        return oss.str();
    }
        
};

class Agencia {
private:
    int codigo;
    std::vector<Transacao> transacoes;
    std::vector<Conta> contas;

public:
    int getCodigo() const {
        return codigo;
    }

    void addConta(const int numero, const Cliente& titular) {
        Conta novaConta(numero, titular);
        contas.push_back(novaConta);
    }

    double getSaldo() const {
        double saldo = 0.0;
        for (const Transacao& transacao : transacoes) {
            if (transacao.getTipoOperacao() == tipoTransacao::CREDITO) {
                saldo += transacao.getValor();
            }
            else if (transacao.getTipoOperacao() == tipoTransacao::DEBITO) {
                saldo -= transacao.getValor();
            }
        }
        return saldo;
    }
};

int main() {
    Conta c1(12345, Cliente("12345678900", "João da Silva"));

    c1.getTitular();
    c1.Depositar(1000.0);
    c1.Sacar(200.0);

    std::cout << c1.listarextrato();

    return 0;
}

