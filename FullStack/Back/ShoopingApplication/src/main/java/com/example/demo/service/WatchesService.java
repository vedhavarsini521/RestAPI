package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.models.Watches;
import com.example.demo.repository.WatchesRepo;

@Service
public class WatchesService {

	@Autowired
	WatchesRepo repository;
	
	public String addWatches(Watches watches)
	{
		repository.save(watches);
		return "Record added";
	}
	
	public List<Watches>getWatches(){
		return repository.findAll();
	}
	
//	public Optional<Watches>getWatchesById(int id){
//		return repository.findById(id);
//	}

	public List<Watches>getWatchesSorted(String field){
		return repository.findAll(Sort.by(Sort.Direction.ASC,field));
	}
	
	public List<Watches>getWatchesWithPagination(int offset,int pagesize){
		Page<Watches>page=repository.findAll(PageRequest.of(offset, pagesize));
		return page.getContent();
	}
	
	public List<Watches> getWatchesWithPaginationField(int offset, int pagesize, String field) {
		Page<Watches>page=repository.findAll(PageRequest.of(offset, pagesize,Sort.by(field)));
		return page.getContent();
	}
	public Watches udpdateWatches(Watches watches) {
		repository.save(watches);
		return watches;
	}
	
	public String deleteWatches(int id) {
		repository.deleteById(id);
		return "Record deleted";
		}
}
