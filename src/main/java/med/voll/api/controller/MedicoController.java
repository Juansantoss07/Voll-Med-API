package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.Medico.DadosCadastroMedico;
import med.voll.api.Medico.DadosListagemMedico;
import med.voll.api.Medico.Medico;
import med.voll.api.Medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listarMedicos(@PageableDefault(sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemMedico::new);
    }
}
