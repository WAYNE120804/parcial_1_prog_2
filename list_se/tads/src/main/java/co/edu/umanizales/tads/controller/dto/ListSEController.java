package co.edu.umanizales.tads.controller.dto;

import co.edu.umanizales.tads.model.Kid;
import co.edu.umanizales.tads.service.ListSEService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/listse")
public class ListSEController {
    @Autowired
    private ListSEService listSEService;

    @GetMapping
    public ResponseEntity<ResponseDTO> getKids() {
        return new ResponseEntity<>(new ResponseDTO(
                200, listSEService.getKids(), null), HttpStatus.OK);
    }

    @GetMapping(path = "/addkid")
    public ResponseEntity<ResponseDTO> addKid() {
        return new ResponseEntity<>(new ResponseDTO(
                200, listSEService.getKids(), null), HttpStatus.OK);
    }
@GetMapping(path = "/createkid")
    public ResponseEntity<ResponseDTO> createKid(@RequestBody Kid kid) {
        listSEService.createKid(kid);
        return new ResponseEntity<>(new ResponseDTO(
                200, listSEService.getKids(), null
        ), HttpStatus.OK);

    }



}
