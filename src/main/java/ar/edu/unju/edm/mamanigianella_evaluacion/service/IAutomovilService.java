package ar.edu.unju.edm.mamanigianella_evaluacion.service;

import java.util.List;

import ar.edu.unju.edm.mamanigianella_evaluacion.model.Automovil;

public interface IAutomovilService {
  public void guardarAutomovil(Automovil automovil);

  public String obtenerPatente();

  public void eliminarAutomovil();

  public void modificarAutomovil(String patente);

  public List<Automovil> mostrarAutomoviles();
}
