package net.javatest.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RestController;

import net.javatest.springboot.exception.ResourceNotFoundException;
import net.javatest.springboot.model.Registry;
import net.javatest.springboot.repository.RegistryRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class RegistryController {

	@Autowired
	private RegistryRepository registryRepository;
	
	// get all etRegistry
	@GetMapping("/etRegistry")
	public List<Registry> getAlletRegistry(){
		return registryRepository.findAll();
	}		
	
	// create registry rest api
	@PostMapping("/etRegistry")
	public Registry createRegistry(@RequestBody Registry registry) {
		return registryRepository.save(registry);
	}
	
	// get registry by id rest api
	@GetMapping("/etRegistry/{id}")
	public ResponseEntity<Registry> getRegistryById(@PathVariable Long id) {
		Registry registry = registryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ET not exist with id :" + id));
		return ResponseEntity.ok(registry);
	}
	
	// update registry rest api
	
	@PutMapping("/etRegistry/{id}")
	public ResponseEntity<Registry> updateRegistry(@PathVariable Long id, @RequestBody Registry registryDetails){
		Registry registry = registryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ET not exist with id :" + id));
		
		registry.setEmergingTechnology(registryDetails.getEmergingTechnology());
		registry.setActivityType(registryDetails.getActivityType());
		registry.setEmailId(registryDetails.getEmailId());
		
		Registry updatedRegistry = registryRepository.save(registry);
		return ResponseEntity.ok(updatedRegistry);
	}
	
	// delete registry rest api
	@DeleteMapping("/etRegistry/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteRegistry(@PathVariable Long id){
		Registry registry = registryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ET not exist with id :" + id));
		
		registryRepository.delete(registry);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}