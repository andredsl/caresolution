package br.com.caresolution.caresolution.controller;

import br.com.caresolution.caresolution.service.HashService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hash")
public class HashController {

    @Autowired
    HashService hashService;

    // Endpoint para listar todos os produtos
    @GetMapping("/calculate")
    public ResponseEntity<String> calcularHash(@RequestBody String xml) {

        String valoresTags = hashService.extrairValoresDoXML(xml);
        String hash = hashService.calcularHashMD5(valoresTags);
        return new ResponseEntity<>(hash, HttpStatus.OK);
    }
}
