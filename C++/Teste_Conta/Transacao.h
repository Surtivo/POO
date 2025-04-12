#ifndef TRANSACAO_H
#define TRANSACAO_H

#include <string>
#include <ctime>

enum class TipoOperacao {
    DEPOSITO,
    SAQUE,
    TRANSFERENCIA
    // Adicione outras operações se quiser
};

class Transacao {
private:
    TipoOperacao operacao;
    std::time_t data;
    double valor;

public:
    Transacao(TipoOperacao operacao, std::time_t data, double valor);

    TipoOperacao getTipoOperacao() const;
    std::time_t getData() const;
    double getValor() const;
};

#endif
