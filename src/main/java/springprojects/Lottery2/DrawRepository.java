package springprojects.Lottery2;

import org.springframework.data.jpa.repository.JpaRepository;

import springprojects.Lottery2.model.Draw;

public interface DrawRepository extends JpaRepository<Draw, Long> {

}