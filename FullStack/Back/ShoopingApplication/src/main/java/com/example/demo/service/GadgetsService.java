package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.models.Gadgets;
import com.example.demo.repository.GadgetsRepo;

@Service
public class GadgetsService {
	@Autowired
	GadgetsRepo repository;
	
	public String addGadgets(Gadgets gadgets)
	{
		repository.save(gadgets);
		return "Record added";
	}
	
	public List<Gadgets>getGadgets(){
		return repository.findAll();
	}
	
//	public Optional<Gadgets>getGadgetsById(int id){
//		return repository.findById(id);
//	}

	public List<Gadgets>getGadgetsSorted(String field){
		return repository.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	
	public List<Gadgets>getGadgetsWithPagination(int offset,int pagesize){
		Page<Gadgets>page=repository.findAll(PageRequest.of(offset, pagesize));
		return page.getContent();
	}
	
	public List<Gadgets> getGadgetsWithPaginationField(int offset, int pagesize, String field) {
		Page<Gadgets>page=repository.findAll(PageRequest.of(offset, pagesize,Sort.by(field)));
		return page.getContent();
	}
	public Gadgets udpdateGadgets(Gadgets gadgets) {
		repository.save(gadgets);
		return gadgets;
	}
	
	public String deleteGadgets(int id) {
		repository.deleteById(id);
		return "Record deleted";
		}
}
