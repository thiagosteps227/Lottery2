package springprojects.Lottery2.controller;

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

import springprojects.Lottery2.DrawNotFoundException;
import springprojects.Lottery2.DrawRepository;
import springprojects.Lottery2.model.Draw;

@RestController
@RequestMapping("/api")
public class DrawController {

	@Autowired
	DrawRepository repository;

  DrawController(DrawRepository repository) {
    this.repository = repository;
  }


  @GetMapping("/draws")
  public List<Draw> findAll() {
	  return repository.findAll();
  }
 
  @GetMapping("/draw/{id}")
  Draw one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new DrawNotFoundException(id));
  }
  
  @PostMapping("/draws")
  public Draw newDraw(@RequestBody Draw newDraw) {
    return repository.save(newDraw);
  }


}