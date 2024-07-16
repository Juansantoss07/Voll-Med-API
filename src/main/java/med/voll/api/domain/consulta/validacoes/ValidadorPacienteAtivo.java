package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidadorPacienteAtivo {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dados){
        var pacienteAtivo = consultaRepository.findAtivoById(dados.idPaciente());
        if (!pacienteAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com paciente inativo");
        }
    }
}
