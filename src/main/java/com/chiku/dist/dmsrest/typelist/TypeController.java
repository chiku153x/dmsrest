package com.chiku.dist.dmsrest.typelist;

import com.chiku.dist.dmsrest.screens.Screen;
import com.chiku.dist.dmsrest.screens.ScreenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(path = "api/v1/type")
public class TypeController {

    private final TypeService typeService;

    @Autowired
    public TypeController(TypeService typeService) {
        this.typeService = typeService;
    }

    @PostMapping(path = "/add")
    public void createType(@RequestBody Type type) {
        typeService.addNewType(type);
    }

    @GetMapping(path = "/get")
    public List<Type> getTypeList() {
        return typeService.getTypeList();
    }

//    @GetMapping(path = "/get/{number}")
//    public Type getTypeByNumber(@PathVariable("number") String number) {
//        final List<Type> typeList = typeService.getTypeList();
//        final List<Type> collectTypes = typeList.stream().filter(f -> f.ge().toString().equals(number)).toList();
//        if (collectTypes.size() == 0) {
//            throw new IllegalStateException("No Type associated with number : " + number);
//        }
//        return collectTypes.get(0);
//    }
}
