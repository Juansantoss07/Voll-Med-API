package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

import java.time.Duration;
import java.time.LocalDateTime;

public class ValidadorHorarioAntecedencia {

    public void validar(DadosAgendamentoConsulta dados){

        var dataConsulta = dados.data();
        var tempoConsulta = Duration.between(LocalDateTime.now(), dataConsulta).toMinutes();

        if (tempoConsulta < 30) {
            throw new ValidacaoException("A consulta deve ser agendada ao menos 30 minutos após o horário informado");
        }
    }
}
