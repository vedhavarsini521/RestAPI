package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Children;
import com.example.demo.repository.ChildRepository;

@Service
public class ChildService {
	@Autowired
	ChildRepository repository;
	
	public Boolean addChild(Children children) {
		repository.save(children);
		return true;
	}

	public List<Children> readChild() {
		return repository.findAll();
	}

	public Optional<Children> readChildById(int id) {
		return repository.findById(id);
	}

	public List<Children> readchildrenSorted(String field) {
		return repository.findAll(Sort.by(Sort.Direction.ASC,field));
	}

	public List<Children> readchildrenPaginated(int offset, int pageSize) {
		Page<Children> page=repository.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}

	public List<Children> readChildrenPaginatedField(int offset, int pageSize, String field) {
		Page<Children> page=repository.findAll(PageRequest.of(offset, pageSize,Sort.by(field)));
		return page.getContent();
	}

	
}
