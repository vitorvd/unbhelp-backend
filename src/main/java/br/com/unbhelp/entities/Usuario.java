package br.com.unbhelp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    private String nome;
    private String email;
    private String senha;
    private String matricula;
    private String curso;
    private double ira;

}
