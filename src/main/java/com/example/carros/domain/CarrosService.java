package com.example.carros.domain;

import com.example.carros.domain.dto.CarroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarrosService {

    @Autowired
    private CarroRepository rep;

    public List<CarroDTO> getCarros(){
        return rep.findAll().stream().map(CarroDTO::create).collect(Collectors.toList());
    }


    public Optional<CarroDTO> getCarroById(Long id) {
        return rep.findById(id).map(CarroDTO::create);
    }

    public List<CarroDTO> getCarroByTipo(String tipo) {
        return rep.findByTipo( tipo).stream().map(CarroDTO::create).collect(Collectors.toList());
    }

    public Carro save(Carro carro) {
       return rep.save(carro);
    }

    public Carro update(Carro carro, Long id) {
        return rep.save(carro);
    }

    public void delete(Long id) {
        Optional<CarroDTO>carro = getCarroById(id);
        if (getCarroById(id).isPresent()){
            rep.deleteById(id);
        }
    }
}
