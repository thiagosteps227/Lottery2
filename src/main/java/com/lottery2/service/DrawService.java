package com.lottery2.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lottery2.model.Draw;
import com.lottery2.repository.DrawRepository;

@Service
public class DrawService{

	@Autowired
	DrawRepository repository;

	public List<Draw> findAll() throws RuntimeException{
		return repository.findAll();
	}

	public Optional<Draw> findById(Long id) {
		return repository.findById(id);
	}

	public List<Draw> findByDrawNumber(int drawNumber){
		return repository.findByDrawNumber(drawNumber);
	}

	public Draw saveNewDraw(Draw draw) {
		return repository.save(draw);
	}

	public boolean remove(Long id) {
		boolean drawRemoved = true;
		repository.deleteById(id);
		return drawRemoved;
	}

	public boolean replace(Long id, Draw draw) {
		boolean drawReplaced = true;
		repository.deleteById(id);
		repository.save(draw);
		return drawReplaced;
	}
	
	private List<Integer> StringNumbersToInt(Draw draw){
		
		List<String> list = draw.getNumbers();
		List<Integer> ints = new ArrayList<Integer>();
		
		for(int i=0;i<list.size();i++) {
			ints.add(Integer.parseInt(list.get(i)));
		}
		
		return ints;
	}
	
	public List<Integer> allNumbersStored(){
		
		List<Draw> allDraws = findAll();
		List<Integer> allNumbers = new ArrayList<Integer>();
		List<Integer> numbersPerDraw;
		
		for(int i=0;i<allDraws.size();i++) {
			
			numbersPerDraw = StringNumbersToInt(allDraws.get(i));
			for(int j=0; j<numbersPerDraw.size();j++) {
				allNumbers.add(j, numbersPerDraw.get(j));
			}
			
		}
		//System.out.println(allNumbers + "allNumbers");
		return allNumbers;
		
	}
	
	public List<Integer> frequency() {
		List<Integer> list = allNumbersStored();
		List<Integer> frequency = new ArrayList<Integer>();
		//System.out.println(list);
		Collections.sort(list);
		// find the max frequency using linear
        // traversal
		int rating[] = {1,2,3,4,5,6,7,8,9,10,
		11,12,13,14,15,16,17,18,19,20,
		21,22,23,24,25,26,27,28,29,30,
		31,32,33,34,35,36,37,38,39,40,
		41,42,43,44,45,46,47,48,49,50,
		51,52,53,54,55,56,57,58,59,60};
		
		int repeat[] = new int[60];
		
		for(int i=0; i<rating.length;i++){ 
			for(int j=0;j<list.size();j++){
				if(rating[i]==list.get(j)) {
					repeat[i]++;
				}
			}
		}
		
		for(int i=0;i<repeat.length;i++){
			frequency.add(i, repeat[i]);
		}
		
		return frequency;
		
	}

}
