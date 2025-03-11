package ar.edu.unju.edm.mamanigianella_evaluacion.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.mamanigianella_evaluacion.model.Automovil;
import ar.edu.unju.edm.mamanigianella_evaluacion.repository.AutomovilRepository;
import ar.edu.unju.edm.mamanigianella_evaluacion.service.IAutomovilService;

@Service
public class IAutomovilServiceImp implements IAutomovilService {
  @Autowired
  AutomovilRepository automovilRepository;

  @Override
  public void guardarAutomovil(Automovil automovil) {
    automovil.setEstado(true);
    automovilRepository.save(automovil);
  }

  @Override
  public void eliminarAutomovil(Long id) {
    Automovil automovil = automovilRepository.findById(id).orElseThrow();
    automovil.setEstado(false);
    automovilRepository.save(automovil);
  }

  @Override
  public void modificarAutomovil(Long id, Automovil automovil) {
    Automovil automovilactual = automovilRepository.findById(id).orElseThrow();
    automovilactual = automovil;
    automovilRepository.save(automovilactual);
  }

  @Override
  public List<Automovil> mostrarAutomoviles() {
    return automovilRepository.findAll();
  }

  @Override
  public List<Automovil> obtenerAutomoviles() {
    List<Automovil> automoviles = automovilRepository.findAll();
    List<Automovil> automovilesActivos = new ArrayList<>();
    for (Automovil automovil : automoviles) {
      if (automovil.getEstado() == true) {
        automovilesActivos.add(automovil);
      }
    }
    return automovilesActivos;
  }

  @Override
  public Automovil obtenerAutomovilPorId(Long id) {
    return automovilRepository.findById(id).orElseThrow();
  }
}
