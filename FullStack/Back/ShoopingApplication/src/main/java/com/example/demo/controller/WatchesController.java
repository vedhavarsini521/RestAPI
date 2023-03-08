package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Watches;
import com.example.demo.service.WatchesService;

@RestController
public class WatchesController {
	@Autowired
	WatchesService service;
	
	@PostMapping("/watches")
	public String addWatches(@RequestBody Watches watches) {
		return service.addWatches(watches);
	}


	@GetMapping("/watches")
	public List<Watches> read(){
		return service.getWatches();
	}


//	@GetMapping("/watches/{id}")
//	public Optional<Watches> readById(@PathVariable int id){
//		return service.getWatchesById(id);
//	}


	@GetMapping("/watches/{field}")
	public List<Watches> ShoeWithSort(@PathVariable String field){
		return service.getWatchesSorted(field);
	}


	@GetMapping("/watches/{offset}/{pagesize}")
	public List<Watches> ShoeWithPagination(@PathVariable int offset,@PathVariable int pagesize){
		return service.getWatchesWithPagination(offset,pagesize);
	}


	@GetMapping("/watches/{offset}/{pagesize}/{field}")
	public List<Watches> ShoeWithPaginationField(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field){
		return service.getWatchesWithPaginationField(offset,pagesize,field);
	}


	@PutMapping("/watches")
	public Watches update(@RequestBody Watches watches) {
		return service.udpdateWatches(watches);
	}


	@DeleteMapping("/watches")
	public String delete(@RequestParam int id) {
		return service.deleteWatches(id);
	}

}
