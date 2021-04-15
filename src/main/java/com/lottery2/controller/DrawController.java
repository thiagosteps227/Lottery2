package com.lottery2.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lottery2.DrawNotFoundException;
import com.lottery2.model.Draw;
import com.lottery2.repository.DrawRepository;

@RestController
@RequestMapping("/loteria")
public class DrawController {

	@Autowired
	DrawRepository repository;

  DrawController(DrawRepository repository) {
    this.repository = repository;
  }


  @GetMapping("/sorteios")
  public List<Draw> findAll() {
	  return repository.findAll();
  }
 
  @GetMapping("/sorteios/{id}")
  Draw one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new DrawNotFoundException(id));
  }
  
  /**@GetMapping("/sorteios/{drawNumber}")
  Draw one(@PathVariable int drawNumber) {
    
    return repository.findByDrawNumber(drawNumber)
      .orElseThrow(() -> new DrawNotFoundException(drawNumber));
  }*/
  
  @PostMapping("/sorteios")
  public Draw newDraw(@RequestBody Draw newDraw) {
    return repository.save(newDraw);
  }


}