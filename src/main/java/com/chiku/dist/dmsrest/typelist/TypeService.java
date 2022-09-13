package com.chiku.dist.dmsrest.typelist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeService {

    private final TypeRepository typeRepository;

    @Autowired
    public TypeService(TypeRepository typeRepository) {
        this.typeRepository = typeRepository;
    }

    public List<Type> getTypeList() {
        return typeRepository.findAll();
    }

    public void addNewType(Type type) {
        List<Type> allTypes = typeRepository.findAll().stream().filter(f->f.getScreenNo().equals(type.getScreenNo()) &&
                f.getItemNo().equals(type.getItemNo())).toList();
        if(allTypes.isEmpty()){
            typeRepository.save(type);
        }else{
            throw new IllegalStateException("Type  already exist");
        }

    }

}
