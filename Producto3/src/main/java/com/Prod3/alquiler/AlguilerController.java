package com.Prod3.alquiler;

import com.Prod3.cliente.Cliente;
import com.Prod3.cliente.ClienteServicio;
import com.Prod3.vehiculo.Vehiculo;
import com.Prod3.vehiculo.VehiculoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AlguilerController {
    @Autowired
    private AlquilerServicio servicio;

    @Autowired
    private ClienteServicio servicioCliente;

    @Autowired
    private VehiculoServicio servicioVehiculo;

@GetMapping("/alquiler")
public String mostrarAlguileresListado(Model model)
{
    List<Alquiler> listaAlguileres=servicio.listAllAlquileres();
    model.addAttribute("listAllAlquileres" , listaAlguileres);
    return "alquileres";

}

@GetMapping("/alquileres/NewAlquiler")
public String mostrarFormularioAñadirAlquiler(Model model)
{
    List<Cliente> listaClientes = servicioCliente.listAllClientes();
    List<Vehiculo> listaVehiculos=servicioVehiculo.listAllVehiculos();

    model.addAttribute("alquiler",new Alquiler());
    model.addAttribute("listAllClientes",listaClientes);
    model.addAttribute("listAllVehiculos",listaVehiculos);

    model.addAttribute("pageTitle","Añadir nuevo Alquiler");
    return "alquiler_AddAlquiler";
}

@PostMapping("/alquileres/grabarAlquiler")
public String grabarAlquiler(Alquiler alquiler, RedirectAttributes ra)
{
    servicio.save(alquiler);
    return "redirect:/alquiler";
}

@GetMapping("/alquileres/EditarAlquiler/{id}")
public String EditarAlquileres(@PathVariable("id") Integer id, Model model, RedirectAttributes ra)
{
 try
 {
     Alquiler alquiler =servicio.get(id);
     List<Cliente> listaClientes = servicioCliente.listAllClientes();
     List<Vehiculo> listaVehiculos=servicioVehiculo.listAllVehiculos();

     model.addAttribute("listAllClientes",listaClientes);
     model.addAttribute("listAllVehiculos",listaVehiculos);
     model.addAttribute("alquiler", alquiler);

     model.addAttribute("pageTitle","Editar Alquiler ID: " + id );
     return "alquiler_AddAlquiler";


 } catch (AlquilerNotFoundException e) {
     ra.addFlashAttribute("message", e.getMessage());
     return "redirect:/alquiler";
 }
}

@GetMapping("/alquileres/EliminarAlquiler/{id}")
public String BorraAlquiler(@PathVariable("id") Integer id, RedirectAttributes ra) {
try
    {
        servicio.borrarAlquiler(id);
        ra.addFlashAttribute("message", "El Contrato Alquiler con ID: " + id + " se ha borrado correctamente.");
    } catch (AlquilerNotFoundException e) {
         ra.addFlashAttribute("message", e.getMessage());
    }
    return "redirect:/alquiler";


}




}
