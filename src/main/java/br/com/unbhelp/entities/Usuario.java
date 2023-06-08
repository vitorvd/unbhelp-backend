package br.com.unbhelp.entities;

import br.com.unbhelp.domains.Curso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_usuarios")
public class Usuario {

    @Id
    @Column(nullable = false)
    private String matricula;

    @Column(nullable = false)
    private String nomeCompleto;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column
    private String apelido;

    @Column
    @Enumerated(EnumType.STRING)
    private Curso curso;

}
