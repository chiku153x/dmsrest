package com.chiku.dist.dmsrest.screens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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


    public void addNewScreen(Screen screen) {

        List<Screen> screens = screenRepository.findAll().stream().filter(f -> f.getScreenNumber().longValue() == screen.getScreenNumber().longValue()).toList();
        if (!screens.isEmpty()) {
            screen.setId(screens.get(0).getId());
        }
        screenRepository.save(screen);
    }
}
