package com.lottery2;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import com.lottery2.model.Draw;
import com.lottery2.repository.DrawRepository;

@SpringBootTest
class Lottery2ApplicationTests {
	
	 @Autowired private DataSource dataSource;
	 @Autowired private JdbcTemplate jdbcTemplate;
	 @Autowired private EntityManager entityManager;
	 @Autowired private DrawRepository drawRepository;
	

	  @Test
	  void injectedComponentsAreNotNull(){
		  
	    assertThat(dataSource).isNotNull();
	    assertThat(jdbcTemplate).isNotNull();
	    assertThat(entityManager).isNotNull();
	    assertThat(drawRepository).isNotNull();
	    
	  }
	  
	  
	  @Test
	  void findById() {
		  List<String> list = new ArrayList<String>();
		  list.add(0, "30");
		  list.add(1, "40");
		  drawRepository.save(new Draw(2L,30,list));
		  assertThat(drawRepository.findById(2L)).isNotNull();
		  
	  }
	

}
