package com.chiku.dist.dmsrest.screens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "api/v1/screen")
public class ScreenController {

	private final ScreenService screenService;

	@Autowired
	public ScreenController(ScreenService screenService) {
		this.screenService = screenService;
	}

	@GetMapping(path = "/get")
	public List<Screen> getScreenList() {
		return screenService.getScreenList();
	}

	@GetMapping(path = "/get/{number}")
	public Screen getScreenByNumber(@PathVariable("number") String number) {
		final List<Screen> screenList = screenService.getScreenList();
		final List<Screen> collectScreens = screenList.stream().filter(f -> f.getScreenNumber().toString().equals(number)).toList();
		if (collectScreens.size() == 0) {
			throw new IllegalStateException("No screen associated with number : " + number);
		}
		return collectScreens.get(0);
	}
}