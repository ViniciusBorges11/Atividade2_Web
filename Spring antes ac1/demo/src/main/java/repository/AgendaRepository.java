package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Agenda;


public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    
}
