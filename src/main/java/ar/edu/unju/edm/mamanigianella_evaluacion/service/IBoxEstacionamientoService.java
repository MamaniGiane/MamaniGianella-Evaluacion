package ar.edu.unju.edm.mamanigianella_evaluacion.service;

import java.util.List;

import ar.edu.unju.edm.mamanigianella_evaluacion.model.BoxEstacionamiento;

public interface IBoxEstacionamientoService {
  public void guardarBoxEstacionamiento(BoxEstacionamiento boxEstacionamiento);

  public void eliminarBoxEstacionamiento();

  public BoxEstacionamiento obtenerBoxPorId(Long id);

  public void modificarBoxEstacionamiento(BoxEstacionamiento boxEstacionamiento);

  public List<BoxEstacionamiento> obtenerBoxesDisponibles();

  public void mostrarBoxEstacionamiento();
}
