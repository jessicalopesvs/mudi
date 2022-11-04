package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.model.StatusPedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    private final PedidoRepository repository;

    public HomeController(PedidoRepository repository) {
        this.repository = repository;
    }


    //criar método para retornar a view
    @GetMapping
    public String Home (Model model){

        //add na lista
        List<Pedido> pedidos = repository.findAll();
        model.addAttribute("pedidos", pedidos);
        return "home";
    }

    //filtro
    @GetMapping("/{status}")
    public String statusFilter (@PathVariable ("status") String status, Model model){


        //add na lista
        List<Pedido> pedidos = repository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status", status);
        return "home";
    }

    @ExceptionHandler (IllegalArgumentException.class)
    public String onError(){
        return "redirect:/home";
    }

}
