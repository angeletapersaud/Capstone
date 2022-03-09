package com.example.demo.Controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Model.Ghibli;
import com.example.demo.Model.Login;
import com.example.demo.Repository.GhibliRepository;
import com.example.demo.Exception.ResourceNotFoundException;
import java.util.stream.Collectors;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api")
public class GhibliController{

	@Autowired
	private GhibliRepository ghibliRepo;
	
	//get all ghibli
	@GetMapping("/allghibli")
	public List<Ghibli> getAllGhibli()
	{
		return ghibliRepo.findAll();
	}
	
	@PostMapping("/addghibli")
    public Ghibli newGhibli(@RequestBody Ghibli gb)
    {
		return ghibliRepo.save(gb);
    }
	
	@GetMapping("/ghibli/{id}")
	public ResponseEntity<Ghibli> getGhibliById(@PathVariable int id)
	{
		Ghibli g= ghibliRepo.findById(id).orElseThrow(() ->  new ResourceNotFoundException("Ghibli Film not found"));
		return ResponseEntity.ok(g);                 
	}
	
	public List<Ghibli> findByName(String title)
	{
		List<Ghibli> allghibliFilmInfo = ghibliRepo.findAll();
		List <Ghibli> ghiblis = allghibliFilmInfo.stream().filter(gl -> title.toUpperCase().contains(gl.getTitle().toUpperCase()) || gl.getTitle().toUpperCase().contains(title.toUpperCase())).collect(Collectors.toList());
		if(ghiblis.isEmpty())
		{
			System.out.println(new ResourceNotFoundException("Ghibli Films(s) with the title "+ title +" not found"));
		}
		
		return ghiblis;
	}
	
	@GetMapping("/ghibli/title:{title}")
	public List<Ghibli> getGhibliByName(@PathVariable String title)
	{	
		return findByName(title);
	}
	
	@PutMapping("/ghibli/{id}")
	public ResponseEntity<Ghibli> updateGhibli(@PathVariable int id, @RequestBody Ghibli ghibli)
	{
		Ghibli g= ghibliRepo.findById(id).orElseThrow(() ->  new ResourceNotFoundException("Ghibli Film not found"));
	    g.setDescription(ghibli.getDescription());
	    g.setTitle(ghibli.getTitle());
	    g.setMoviePoster(ghibli.getMoviePoster());
	    g.setDirector(ghibli.getDirector());
	    g.setReleaseDate(ghibli.getReleaseDate());
	    g.setMovieBanner(ghibli.getMovieBanner());
	    //g.setMoviePosterAlt(ghibli.getMoviePosterAlt());
	    Ghibli updatedGhibli=ghibliRepo.save(g);
	    return ResponseEntity.ok(updatedGhibli);
	}
	
	@DeleteMapping("/ghibli/{id}")
	public String deleteGhibli(@PathVariable int id)
	{
		ghibliRepo.findById(id).orElseThrow(() ->  new ResourceNotFoundException("Ghibli Film not found"));
		ghibliRepo.deleteById(id);
	    return "The Ghibli Film with id: "+ id +" is removed from the database.";
	}
	

}
