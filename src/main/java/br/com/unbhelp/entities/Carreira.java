package br.com.unbhelp.entities;

import br.com.unbhelp.dtos.CarreiraDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tb_carreira")
public class Carreira {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    public static Carreira fromDTO(CarreiraDTO dto){
        Carreira carreira= new Carreira().builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .build();
        return carreira;
    }
}
