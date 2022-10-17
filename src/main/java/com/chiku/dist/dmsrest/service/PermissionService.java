package com.chiku.dist.dmsrest.service;


import com.chiku.dist.dmsrest.model.Permission;
import com.chiku.dist.dmsrest.repository.PermissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermissionService {

    private final PermissionRepository permissionRepository;

    public PermissionService(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public void addNewPermission(List<Permission> permission) {
        List<Permission> allPermissions = getPermissionsByUserName(permission.get(0).getUserName());
        permissionRepository.deleteAll(allPermissions);
        permissionRepository.saveAll(permission);
    }

    public List<Permission> getPermissionsByUserName(String userName) {

        return permissionRepository.findAll().stream().filter(f -> f.getUserName().equals(userName))
                .collect(Collectors.toList());
    }

    public List<Permission> getPermissionsByUserNameAndScreenNo(String userName, String screenNumber) {
        return permissionRepository.findAll().stream().filter(f -> f.getUserName().equals(userName)
                        && f.getScreen().equals(screenNumber))
                .collect(Collectors.toList());
    }


    public void deleteSinglePermission(Permission permission) {
        permissionRepository.deleteById(permission.getId());
    }
}
