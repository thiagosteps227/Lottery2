package com.lottery2.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lottery2.model.Draw;
import com.lottery2.repository.DrawRepository;
import com.lottery2.service.DrawService;

@RestController
@RequestMapping("/loteria")
public class DrawController {
	
	@Autowired
	DrawService service;

	@GetMapping("/sorteios")
	public ResponseEntity<List<Draw>>findAll() {
		List<Draw> list = service.findAll();
		return ResponseEntity.status(200).body(list);
	}

	@GetMapping("/sorteios/{id}")
	public ResponseEntity<Optional<Draw>> one(@PathVariable Long id){
		Optional<Draw> draw = service.findById(id);
		return ResponseEntity.status(200).body(draw); 
	}

	@GetMapping("/sorteios/numero/{drawNumber}")
	public ResponseEntity<List<Draw>> list(@PathVariable int drawNumber) {
		List<Draw> list = service.findByDrawNumber(drawNumber);
		return ResponseEntity.status(200).body(list);
	}
	
	@GetMapping("/sorteios/frequencia")
	public ResponseEntity<List<Integer>> frequency() {
		List<Integer> list = service.frequency();
		return ResponseEntity.status(200).body(list);
	}
	
	@PostMapping("/sorteios")
	public ResponseEntity<Draw> newDraw(@RequestBody Draw newDraw) {
		service.saveNewDraw(newDraw);
		return ResponseEntity.status(201).body(newDraw);

	}

	@DeleteMapping("/sorteios/{id}")
	public ResponseEntity<Draw> delete(@PathVariable Long id){
		service.remove(id);
		return ResponseEntity.noContent().build(); 
	}
	
	@PutMapping("/sorteios/{id}")
	public ResponseEntity<Draw> replace(@RequestBody Draw draw, @PathVariable Long id){
		service.replace(id, draw);
		return ResponseEntity.status(201).body(draw);
	}
}
