package io.github.josuhinrichs.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //gerenciado pelo container de injeção de dependências do spring
@RequestMapping( "/api/clientes" )  //URL cujas requisições dizem respeito a este controller
public class ClienteController {

    @RequestMapping(value = "/hello/{nome}", method = RequestMethod.GET)
    @ResponseBody
    public String helloCliente(@PathVariable("nome") String nomeCliente){   //vai receber variável no path
        return String.format("Hello %s ", nomeCliente);
    }

}
