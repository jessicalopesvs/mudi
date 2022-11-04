package br.com.alura.mvc.mudi.controller;

import br.com.alura.mvc.mudi.model.Pedido;
import br.com.alura.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PedidoRepository repository;


    //criar método para retornar a view
    @GetMapping("/home")
    public String Home (Model model){

        //add na lista
        List<Pedido> pedidos = repository.recuperaTodosOsPedidos();
        model.addAttribute("pedidos", pedidos);
        return "home";
    }

}
