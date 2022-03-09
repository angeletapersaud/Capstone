package com.example.demo.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.Model.Ghibli;
@Repository
public interface GhibliRepository extends JpaRepository<Ghibli,Integer> {

	//List<Ghibli> findByName(String name);

}
