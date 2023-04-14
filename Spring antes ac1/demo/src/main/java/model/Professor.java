package model;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.data.jpa.repository.Temporal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Professor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 200, nullable = false)
    private String nome;
    @Column(length = 200, nullable = false)
    private String rg;
    @Column(length = 200, nullable = false)
    private String cpf;
    @Column(length = 200, nullable = false)
    private String endereco;
    @Column(length = 200, nullable = false)
    private String agenda_id;
    @ManyToOne()
    private Agenda agenda;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "especializacao",
    joinColumns = @JoinColumn(name = "professor_id"),
    inverseJoinColumns = @JoinColumn(name = "curso_id"))
    private java.util.List<Curso> cursos;

    
       
}
