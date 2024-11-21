package PicPaySimplificado.controllers;

import PicPaySimplificado.domain.Request;
import PicPaySimplificado.useCases.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/picpay")
public class Controller {

    private final UseCase useCase;

    @PostMapping
    public String transferencia(@RequestBody Request request){
        return useCase.transfer(request);
    }

}
