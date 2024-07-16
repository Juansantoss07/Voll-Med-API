package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.Medico.MedicoRepository;
import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidadorMedicoAtivo {

    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(DadosAgendamentoConsulta dados){

        if (dados.idMedico() == null){
            return;
        }

        var medicoEstaAtivo = medicoRepository.findAtivoById(dados.idMedico());
        if (!medicoEstaAtivo){
            throw new ValidacaoException("Consulta não pode ser agendada com médico inativo");
        }
    }
}
