package com.chiku.dist.dmsrest.screens;

import com.chiku.dist.dmsrest.document.Document;
import com.chiku.dist.dmsrest.document.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScreenService {
	private final ScreenRepository screenRepository;

	@Autowired
	public ScreenService(ScreenRepository screenRepository) {
		this.screenRepository = screenRepository;
	}

	public List<Screen> getScreenList() {
		return screenRepository.findAll();
	}
}
