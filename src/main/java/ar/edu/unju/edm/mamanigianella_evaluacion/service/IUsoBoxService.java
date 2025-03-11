package ar.edu.unju.edm.mamanigianella_evaluacion.service;

public interface IUsoBoxService {
  public void ocuparBox(Long boxId, Long autoId, int horas);

  public double calcularCosto(int zona, int horas);
}
