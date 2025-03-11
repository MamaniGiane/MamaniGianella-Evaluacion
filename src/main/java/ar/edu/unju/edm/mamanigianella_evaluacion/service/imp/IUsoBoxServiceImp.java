package ar.edu.unju.edm.mamanigianella_evaluacion.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.mamanigianella_evaluacion.model.Automovil;
import ar.edu.unju.edm.mamanigianella_evaluacion.model.BoxEstacionamiento;
import ar.edu.unju.edm.mamanigianella_evaluacion.model.UsoBox;
import ar.edu.unju.edm.mamanigianella_evaluacion.repository.AutomovilRepository;
import ar.edu.unju.edm.mamanigianella_evaluacion.repository.BoxEstacionamientoRepository;
import ar.edu.unju.edm.mamanigianella_evaluacion.repository.UsoBoxRepository;
import ar.edu.unju.edm.mamanigianella_evaluacion.service.IUsoBoxService;

@Service
public class IUsoBoxServiceImp implements IUsoBoxService {
  @Autowired
  AutomovilRepository automovilRepo;
  @Autowired
  BoxEstacionamientoRepository boxRepo;
  @Autowired
  UsoBoxRepository usoBoxRepo;

  @Override
  public void ocuparBox(Long boxId, Long autoId, int horas) {
    Automovil auto = automovilRepo.findById(autoId).orElseThrow();
    BoxEstacionamiento box = boxRepo.findById(boxId).orElseThrow();
    box.setDisponibilidad(false);

    double costo = calcularCosto(box.getZona(), horas);
    UsoBox uso = new UsoBox();
    uso.setAutomovil(auto);
    uso.setBox(box);
    uso.setCantidadHoras(horas);
    uso.setCostoPagado(costo);
    usoBoxRepo.save(uso);
    boxRepo.save(box);
  }

  @Override
  public double calcularCosto(int zona, int horas) {
    return zona == 1 ? horas * 500 : horas * 300;
  }

}
