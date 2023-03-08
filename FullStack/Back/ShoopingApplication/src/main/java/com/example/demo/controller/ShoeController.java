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

import com.example.demo.models.Shoe;
import com.example.demo.service.ShoeService;

@RestController
public class ShoeController {
	@Autowired
	ShoeService service;
	
	@PostMapping("/shoe")
	public String addShoe(@RequestBody Shoe shoe) {
		return service.addShoe(shoe);
	}


	@GetMapping("/shoe")
	public List<Shoe> read(){
		return service.getShoe();
	}


//	@GetMapping("/shoe/{id}")
//	public Optional<Shoe> readById(@PathVariable int id){
//		return service.getShoeById(id);
//	}


	@GetMapping("/shoe/{field}")
	public List<Shoe> ShoeWithSort(@PathVariable String field){
		return service.getShoeSorted(field);
	}


	@GetMapping("/shoe/{offset}/{pagesize}")
	public List<Shoe> ShoeWithPagination(@PathVariable int offset,@PathVariable int pagesize){
		return service.getShoeWithPagination(offset,pagesize);
	}


	@GetMapping("/shoe/{offset}/{pagesize}/{field}")
	public List<Shoe> ShoeWithPaginationField(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field){
		return service.getShoeWithPaginationField(offset,pagesize,field);
	}


	@PutMapping("/shoe")
	public Shoe update(@RequestBody Shoe shoe) {
		return service.update(shoe);
	}


	@DeleteMapping("/shoe")
	public String delete(@RequestParam int id) {
		return service.deleteShoe(id);
	}

}
