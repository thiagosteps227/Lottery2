package com.lottery2.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "draw")
public class Draw {
	
	@Column(name = "drawNumber")
	private int drawNumber;
	
	@Column(name = "numbers")
	@ElementCollection(targetClass=String.class)
	private List<String> numbers;
	
	@Id 
	@GeneratedValue (strategy = GenerationType.AUTO)
	private  Long id;
	
	public Draw() {
		
	}
	
	public Draw(Long id, int drawNumber, List<String> numbers) {
		this.id = id;
		this.drawNumber = drawNumber;
		this.numbers = numbers;
	}

	public int getDrawNumber() {
		return drawNumber;
	}

	public void setDrawNumber(int drawNumber) {
		this.drawNumber = drawNumber;
	}

	public List<String> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<String> numbers) {
		this.numbers = numbers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}