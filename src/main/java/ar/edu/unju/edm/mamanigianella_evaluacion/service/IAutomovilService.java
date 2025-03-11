package ar.edu.unju.edm.mamanigianella_evaluacion.service;

import java.util.List;

import ar.edu.unju.edm.mamanigianella_evaluacion.model.Automovil;

public interface IAutomovilService {
  public void guardarAutomovil(Automovil automovil);

  public void eliminarAutomovil(Long id);

  public void modificarAutomovil(Long id, Automovil automovil);

  public List<Automovil> mostrarAutomoviles();

  public List<Automovil> obtenerAutomoviles();

  public Automovil obtenerAutomovilPorId(Long id);
}
