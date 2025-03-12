package ar.edu.unju.edm.mamanigianella_evaluacion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.edu.unju.edm.mamanigianella_evaluacion.model.Automovil;
import ar.edu.unju.edm.mamanigianella_evaluacion.model.BoxEstacionamiento;
import ar.edu.unju.edm.mamanigianella_evaluacion.service.IAutomovilService;
import ar.edu.unju.edm.mamanigianella_evaluacion.service.IBoxEstacionamientoService;
import ar.edu.unju.edm.mamanigianella_evaluacion.service.IUsoBoxService;

@Controller
public class EstacionamientoController {
  @Autowired
  private IAutomovilService automovilService;
  @Autowired
  private IBoxEstacionamientoService boxestacionamientoService;
  @Autowired
  private IUsoBoxService usoBoxService;

  @GetMapping("/")
  public String mostrarBoxes(Model model) {
    model.addAttribute("boxes", boxestacionamientoService.obtenerBoxesDisponibles());
    return "index";
  }

  @GetMapping("/seleccionar-box/{id}")
  public String seleccionarBox(Model model, @PathVariable(name = "id") Long id) {
    model.addAttribute("box", id);
    model.addAttribute("autos", automovilService.obtenerAutomoviles());
    return "seleccionar-box";
  }

  @PostMapping("/ocupar-box")
  public String ocuparBox(@RequestParam Long boxId, @RequestParam Long autoId, @RequestParam int horas,
      Model model) {
    usoBoxService.ocuparBox(boxId, autoId, horas);
    BoxEstacionamiento box = boxestacionamientoService.obtenerBoxPorId(boxId);
    double costo = usoBoxService.calcularCosto(box.getZona(), horas);
    model.addAttribute("costo", costo);
    return "resumen";
  }

  @GetMapping("/nuevo-auto")
  public String nuevoAutomovil(Model model) {
    model.addAttribute("automovil", new Automovil());
    model.addAttribute("marcas", Automovil.Marca.values());
    model.addAttribute("colores", Automovil.Color.values());
    model.addAttribute("modelos", Automovil.Modelo.values());
    return "nuevo-auto";
  }

  @PostMapping("/guardar-auto")
  public String guardarAutomovil(@ModelAttribute Automovil automovil) {
    automovilService.guardarAutomovil(automovil);
    return "redirect:/";
  }

  @GetMapping("/nuevo-box")
  public String nuevoBox(Model model) {
    model.addAttribute("box", new BoxEstacionamiento());
    return "nuevo-box";
  }

  @GetMapping("/editar-auto/{id}")
  public String editarBox(Model model, @PathVariable(name = "id") Long id) {
    model.addAttribute("automovil", automovilService.obtenerAutomovilPorId(id));
    model.addAttribute("marcas", Automovil.Marca.values());
    model.addAttribute("colores", Automovil.Color.values());
    model.addAttribute("modelos", Automovil.Modelo.values());
    return "nuevo-auto";
  }

  @GetMapping("/eliminar-auto/{id}")
  public String eliminarAuto(Model model, @PathVariable(name = "id") Long id) {
    automovilService.eliminarAutomovil(id);
    return "redirect:/listar-autos";
  }

  @PostMapping("/guardar-box")
  public String guardarBox(@ModelAttribute BoxEstacionamiento box) {
    boxestacionamientoService.guardarBoxEstacionamiento(box);
    return "redirect:/";
  }

  @GetMapping("/listar-autos")
  public String listarAutos(Model model) {
    model.addAttribute("autos", automovilService.obtenerAutomoviles());
    return "listar-autos";
  }
}
