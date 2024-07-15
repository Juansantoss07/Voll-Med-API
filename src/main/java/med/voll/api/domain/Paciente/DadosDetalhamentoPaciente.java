package med.voll.api.domain.Paciente;

import med.voll.api.domain.Endereco.Endereco;

public record DadosDetalhamentoPaciente(
        String nome,
        String email,
        String cpf,
        String telefone,
        Endereco endereco
) {
    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone(), paciente.getEndereco());
    }
}
