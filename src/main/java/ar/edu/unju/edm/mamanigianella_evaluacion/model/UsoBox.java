package ar.edu.unju.edm.mamanigianella_evaluacion.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UsoBox {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @ManyToOne
  private Automovil automovil;
  @ManyToOne
  private BoxEstacionamiento box;
  private int cantidadHoras;
  private double costoPagado;
}
