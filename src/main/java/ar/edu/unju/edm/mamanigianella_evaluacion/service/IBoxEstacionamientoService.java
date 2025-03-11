package ar.edu.unju.edm.mamanigianella_evaluacion.service;

import java.util.List;

import ar.edu.unju.edm.mamanigianella_evaluacion.model.BoxEstacionamiento;

public interface IBoxEstacionamientoService {
  public void guardarBoxEstacionamiento(BoxEstacionamiento boxEstacionamiento);

  public void ocuparBoxEstacionamiento(Long id);

  public void desocuparBoxEstacionamiento(Long id);

  public BoxEstacionamiento obtenerBoxPorId(Long id);

  public void modificarBoxEstacionamiento(BoxEstacionamiento boxEstacionamiento);

  public List<BoxEstacionamiento> obtenerBoxesDisponibles();

  public List<BoxEstacionamiento> mostrarBoxEstacionamiento();
}
