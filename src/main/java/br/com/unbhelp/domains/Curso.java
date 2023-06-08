package br.com.unbhelp.domains;

import lombok.Getter;

public enum Curso {

    COMPUTACAO("Computação"), CIENCIAS_COMPUTACAO("Ciências da Computação");

    @Getter
    private String label;
    Curso(String label) {
        this.label = label;
    }
}
