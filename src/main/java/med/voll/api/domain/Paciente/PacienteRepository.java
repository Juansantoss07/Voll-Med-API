package med.voll.api.domain.Paciente;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Page<Paciente> findByAtivoTrue(Pageable pageable);

    @Query("""
            select p.ativo
            from Paciente p
            where
            p.id = :id
        """)
    Boolean findAtivoById(Long id);
}

