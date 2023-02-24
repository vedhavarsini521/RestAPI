package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Children;
import com.example.demo.service.ChildService;

@RestController
public class ChildController {
	@Autowired
	ChildService service;
	
	@PostMapping("/children")
	public Boolean add(@RequestBody Children children){
		return service.addChild(children);
	}
	
	@GetMapping("/children")
	public List<Children> read(){
		return service.readChild();
	}
	
//	@GetMapping("/children/{id}")
//	public Optional<Children> readById(@PathVariable int id){
//		return service.readChildById(id);
//	}
	
	@GetMapping("/children/{field}")
	public List<Children> childrenSorted(@PathVariable String field){
		return service.readchildrenSorted(field);
	}
	
	@GetMapping("/children/{offset}/{pageSize}")
	public List<Children> childrenPaginated(@PathVariable int offset,@PathVariable int pageSize){
		return service.readchildrenPaginated(offset,pageSize);
	}
	
	@GetMapping("/children/{offset}/{pageSize}/{field}")
	public List<Children> childrenWithPaaginatedField(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field){
		return service.readChildrenPaginatedField(offset,pageSize,field);
	}
}
