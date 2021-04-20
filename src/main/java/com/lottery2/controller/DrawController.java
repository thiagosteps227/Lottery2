package com.lottery2.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
	public ResponseEntity<List<Draw>>findAll() {
		List<Draw> list = repository.findAll();
		return ResponseEntity.status(200).body(list);
	}

	@GetMapping("/sorteios/{id}")
	public ResponseEntity<Optional<Draw>> one(@PathVariable Long id){
		Optional<Draw> draw = repository.findById(id);
		return ResponseEntity.status(200).body(draw); 
	}

	@GetMapping("/sorteios/numero/{drawNumber}")
	public ResponseEntity<List<Draw>> list(@PathVariable int drawNumber) {
		List<Draw> list = repository.findByDrawNumber(drawNumber);
		return ResponseEntity.status(200).body(list);
	}

	@PostMapping("/sorteios")
	public ResponseEntity<Draw> newDraw(@RequestBody Draw newDraw) {
		repository.save(newDraw);
		return ResponseEntity.status(201).body(newDraw);

	}


}
