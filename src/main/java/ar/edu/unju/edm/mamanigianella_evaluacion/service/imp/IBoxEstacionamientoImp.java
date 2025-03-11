package ar.edu.unju.edm.mamanigianella_evaluacion.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.mamanigianella_evaluacion.model.BoxEstacionamiento;
import ar.edu.unju.edm.mamanigianella_evaluacion.repository.BoxEstacionamientoRepository;
import ar.edu.unju.edm.mamanigianella_evaluacion.service.IBoxEstacionamientoService;

@Service
public class IBoxEstacionamientoImp implements IBoxEstacionamientoService {
  @Autowired
  BoxEstacionamientoRepository boxEstacionamientoRepository;

  @Override
  public void guardarBoxEstacionamiento(BoxEstacionamiento boxEstacionamiento) {
    boxEstacionamiento.setDisponibilidad(true);
    boxEstacionamientoRepository.save(boxEstacionamiento);
  }

  @Override
  public void ocuparBoxEstacionamiento(Long id) {
    BoxEstacionamiento box = boxEstacionamientoRepository.findById(id).orElseThrow();
    box.setDisponibilidad(false);
    boxEstacionamientoRepository.save(box);
  }

  @Override
  public void modificarBoxEstacionamiento(BoxEstacionamiento boxEstacionamiento) {
    boxEstacionamientoRepository.save(boxEstacionamiento);
  }

  @Override
  public List<BoxEstacionamiento> obtenerBoxesDisponibles() {
    List<BoxEstacionamiento> boxes = boxEstacionamientoRepository.findAll();
    List<BoxEstacionamiento> boxesDisponibles = new ArrayList<>();
    for (BoxEstacionamiento box : boxes) {
      if (box.getDisponibilidad() == true) {
        boxesDisponibles.add(box);
      }
    }
    return boxesDisponibles;
  }

  @Override
  public List<BoxEstacionamiento> mostrarBoxEstacionamiento() {
    return boxEstacionamientoRepository.findAll();
  }

  @Override
  public BoxEstacionamiento obtenerBoxPorId(Long id) {
    return boxEstacionamientoRepository.findById(id).orElseThrow();
  }

  @Override
  public void desocuparBoxEstacionamiento(Long id) {
    BoxEstacionamiento box = boxEstacionamientoRepository.findById(id).orElseThrow();
    box.setDisponibilidad(true);
    boxEstacionamientoRepository.save(box);
  }

}
