package repository;

import org.hibernate.mapping.Collection;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    
@Query("select c from Curso where c.professor = :professor_id ")
    Curso findCategoriaCursoFetchCursos(@Param("professor_id") Long id);

}
