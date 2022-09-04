package com.example.carros.domain.dto;

import com.example.carros.domain.Carro;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

@Data
@Getter
@Setter
public class CarroDTO {
    private Long id;
    private String nome;
    private String tipo;

    public static CarroDTO create(Carro c) {
        ModelMapper modelMapper = new ModelMapper();
        return  modelMapper.map(c, CarroDTO.class);
    }
}
