package com.example.carros.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarrosService {

    @Autowired
    private CarroRepository rep;

    public Iterable<Carro> getCarros(){
        return  rep.findAll();
    }
    public List<Carro>getCarroFake(){
        List<Carro> carros = new ArrayList<>();

        carros.add(new Carro(1l,"Fusca", "Fiat"));
        carros.add(new Carro(2l,"Gol","fiat" ));
        carros.add(new Carro(3l,"Corola", "fiat"));

        return carros;
    }

    public Optional<Carro> getCarroById(Long id) {
        return rep.findById(id);
    }

    public Iterable<Carro> getCarroByTipo(String tipo) {
        return rep.findByTipo( tipo);
    }

    public Carro save(Carro carro) {
       return rep.save(carro);
    }

    public Carro update(Carro carro, Long id) {
        return rep.save(carro);
    }

    public void delete(Long id) {
        Optional<Carro>carro = getCarroById(id);
        if (carro.isPresent()){
            rep.deleteById(id);
        }
    }
}
