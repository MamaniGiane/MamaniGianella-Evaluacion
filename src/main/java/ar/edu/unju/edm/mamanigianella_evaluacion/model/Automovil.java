package ar.edu.unju.edm.mamanigianella_evaluacion.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Component
public class Automovil {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String patente;
  private String marca;
  private String modelo;
  private String color;
  private String duenio;
  private Boolean estado;
}
