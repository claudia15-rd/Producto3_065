package com.Prod3.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ClienteController {
    @Autowired
    private ClienteServicio servicio;

    @GetMapping("/clientes")
    public String mostrarClientesListado(Model model) {
        List<Cliente> listaClientes = servicio.listAllClientes();
        model.addAttribute("listAllClientes", listaClientes);

        return "clientes";

    }

    @GetMapping("/clientes/NewCliente")
    public String mostrarFormularioAñadirCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        model.addAttribute("pageTitle","Añadir nuevo Cliente");
        return "cliente_AddUsuario";

    }

    @PostMapping("/clientes/grabarCliente")
    public String grabarCliente(Cliente cliente, RedirectAttributes ra) {
        servicio.save(cliente);
        ra.addFlashAttribute("message", "Se ha guardado el Cliente.");
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/EditarUsuario/{id}")
    public String EditarCliente(@PathVariable("id") Integer id, Model model, RedirectAttributes ra) {
        try {
            Cliente cliente = servicio.get(id);
            model.addAttribute("cliente", cliente);
            model.addAttribute("pageTitle","Editar Cliente ID: " + id );
            return "cliente_AddUsuario";
        } catch (ClienteNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
            return "redirect:/clientes";

        }
    }

    @GetMapping("/clientes/EliminarUsuario/{id}")
    public String borraCliente(@PathVariable("id") Integer id, RedirectAttributes ra) {
        try {
           servicio.borrarCliente(id);
            ra.addFlashAttribute("message", "El Cliente ID: " + id + " se ha borrado correctamente.");
        } catch (ClienteNotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/clientes";
    }


}

