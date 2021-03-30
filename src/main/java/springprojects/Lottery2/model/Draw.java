package springprojects.Lottery2.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Draw {
	
	private int drawNumber;
	private int numberOne;
	private int numberTwo;
	private int numberThree;
	private int numberFour;
	private int numberFive;
	private int numberSix;
	private @Id @GeneratedValue Long id;
	
	public Draw() {
		
	}
	
	public Draw(int drawNumber, int numberOne, int numberTwo, int numberThree, int numberFour,
			int numberFive, int numberSix) {
		this.drawNumber = drawNumber;
		this.numberOne = numberOne;
		this.numberTwo = numberTwo;
		this.numberThree = numberThree;
		this.numberFour = numberFour;
		this.numberFive = numberFive;
		this.numberSix = numberSix;
	}
	
	public int getDrawNumber() {
		return drawNumber;
	}
	
	public void setDrawNumber(int drawNumber) {
		this.drawNumber = drawNumber;
	}
	
	public int getNumberOne() {
		return numberOne;
	}

	public void setNumberOne(int numberOne) {
		this.numberOne = numberOne;
	}

	public int getNumberTwo() {
		return numberTwo;
	}

	public void setNumberTwo(int numberTwo) {
		this.numberTwo = numberTwo;
	}

	public int getNumberThree() {
		return numberThree;
	}

	public void setNumberThree(int numberThree) {
		this.numberThree = numberThree;
	}

	public int getNumberFour() {
		return numberFour;
	}

	public void setNumberFour(int numberFour) {
		this.numberFour = numberFour;
	}

	public int getNumberFive() {
		return numberFive;
	}

	public void setNumberFive(int numberFive) {
		this.numberFive = numberFive;
	}

	public int getNumberSix() {
		return numberSix;
	}

	public void setNumberSix(int numberSix) {
		this.numberSix = numberSix;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}