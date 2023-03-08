package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.models.Shoe;
import com.example.demo.repository.ShoeRepo;

@Service

public class ShoeService {
	
	@Autowired
	ShoeRepo repository;
	
	public String addShoe(Shoe shoe)
	{
		repository.save(shoe);
		return "Record added";
	}
	
	public List<Shoe>getShoe(){
		return repository.findAll();
	}
	
//	public Optional<Shoe>getShoeById(int id){
//		return repository.findById(id);
//	}

	public List<Shoe>getShoeSorted(String field){
		return repository.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	
	public List<Shoe>getShoeWithPagination(int offset,int pagesize){
		Page<Shoe>page=repository.findAll(PageRequest.of(offset, pagesize));
		return page.getContent();
	}
	
	public List<Shoe> getShoeWithPaginationField(int offset, int pagesize, String field) {
		Page<Shoe>page=repository.findAll(PageRequest.of(offset, pagesize,Sort.by(field)));
		return page.getContent();
	}
	public Shoe update(Shoe shoe) {
		repository.save(shoe);
		return shoe;
	}
	
	public String deleteShoe(int id) {
		repository.deleteById(id);
		return "Record deleted";
		}
}
