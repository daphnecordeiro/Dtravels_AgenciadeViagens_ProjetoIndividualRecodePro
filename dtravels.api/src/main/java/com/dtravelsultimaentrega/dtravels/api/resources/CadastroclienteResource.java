package com.dtravelsultimaentrega.dtravels.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtravelsultimaentrega.dtravels.api.entities.Cadastrocliente;
import com.dtravelsultimaentrega.dtravels.api.services.CadastroclienteService;
@RestController
@RequestMapping("/cadastrocliente")
@CrossOrigin (origins="*")


public class CadastroclienteResource {
	
@Autowired
public CadastroclienteService service;
	
@GetMapping
public List <Cadastrocliente> findAll(){
return service.findAll();
}
		
@PostMapping (value="/")
public ResponseEntity <Cadastrocliente> save(@RequestBody Cadastrocliente cadastrocliente){
service.save(cadastrocliente);
return ResponseEntity.ok().body(cadastrocliente);
}


@DeleteMapping(value="/{id_cliente}")
public ResponseEntity<Cadastrocliente> delete(@PathVariable Long id_cliente){
service.delete(id_cliente);
Cadastrocliente cadastrocliente = service.getById(id_cliente);
return ResponseEntity.ok().body(cadastrocliente);
}

@PutMapping(value = "/")
public ResponseEntity<Cadastrocliente> update(@RequestBody Cadastrocliente cadastrocliente){
service.save(cadastrocliente);
return ResponseEntity.ok().body(cadastrocliente);
}	
		
}

