package model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@AllArgsConstructor
@Data
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    private Date datainicio;
    @Column()
    private Date datafim;
    @Column(length = 200, nullable = false)
    private int horarioinicio;
    @Column(length = 200, nullable = false)
    private int horariofim;
    @Column(length = 200, nullable = false)
    private String cidade;
    @Column(length = 200, nullable = false)
    private String estado;
    @Column(length = 200, nullable = false)
    private String cep;

    @OneToMany(mappedBy = "agenda")
    private List<Professor> professores;
    
    @OneToMany(mappedBy = "agenda")
    private List<Curso> cursos;
}
