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

import com.example.demo.models.Gadgets;
import com.example.demo.service.GadgetsService;

@RestController
public class GadgesController {
	
	@Autowired
	GadgetsService service;
	
	@PostMapping("/gadgets")
	public String addgadgets(@RequestBody Gadgets gadgets) {
		return service.addGadgets(gadgets);
	}


	@GetMapping("/gadgets")
	public List<Gadgets> read(){
		return service.getGadgets();
	}


//	@GetMapping("/gadgets/{id}")
//	public Optional<Gadgets> readById(@PathVariable int id){
//		return service.getGadgetsById(id);
//	}


	@GetMapping("/gadgets/{field}")
	public List<Gadgets> ShoeWithSort(@PathVariable String field){
		return service.getGadgetsSorted(field);
	}


	@GetMapping("/gadgets/{offset}/{pagesize}")
	public List<Gadgets> ShoeWithPagination(@PathVariable int offset,@PathVariable int pagesize){
		return service.getGadgetsWithPagination(offset,pagesize);
	}


	@GetMapping("/gadgets/{offset}/{pagesize}/{field}")
	public List<Gadgets> ShoeWithPaginationField(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field){
		return service.getGadgetsWithPaginationField(offset,pagesize,field);
	}


	@PutMapping("/gadgets")
	public Gadgets update(@RequestBody Gadgets gadgets) {
		return service.udpdateGadgets(gadgets);
	}


	@DeleteMapping("/gadgets")
	public String delete(@RequestParam int id) {
		return service.deleteGadgets(id);
	}


}
