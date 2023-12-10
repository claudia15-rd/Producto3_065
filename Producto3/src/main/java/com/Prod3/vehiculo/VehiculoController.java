package com.Prod3.vehiculo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class VehiculoController {
    @Autowired
    private VehiculoServicio servicio;

    @GetMapping("/vehiculos")
    public String mostrarVehidulosListado(Model model) {
        List<Vehiculo> listaVehiculos = servicio.listAllVehiculos();
        model.addAttribute("listAllVehiculos", listaVehiculos);

        return "vehiculos";

    }

    @GetMapping("/vehiculos/NewVehiculo")
    public String mostrarFormularioAñadirVehiculo(Model model) {
        model.addAttribute("vehiculo", new Vehiculo());
        model.addAttribute("pageTitle","Añadir nuevo Vehiculo");
        return "vehiculo_AddVehiculo";

    }

    @PostMapping("/vehiculos/grabarVehiculo")
    public String grabarVehiculo(Vehiculo vehiculo, RedirectAttributes ra) {
        servicio.save(vehiculo);
        ra.addFlashAttribute("message", "Se ha guardado el Vehiculo.");
        return "redirect:/vehiculos";
    }

    @GetMapping("/vehiculos/EditarVehiculo/{id}")
    public String EditarVehiculo(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Vehiculo vehiculo = servicio.get(id);
            model.addAttribute("vehiculo", vehiculo);
            model.addAttribute("pageTitle","Editar Vehículo ID: " + id );
            return "vehiculo_AddVehiculo";
        } catch (VehiculoNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/vehiculos";

        }
    }

    @GetMapping("/vehiculos/EliminarVehiculo/{id}")
    public String borraVehiculo(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
            servicio.borrarVehiculo(id);
            ra.addFlashAttribute("message", "El Vehiculo ID: " + id + " se ha borrado correctamente.");
        } catch (VehiculoNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/vehiculos";
    }



}
