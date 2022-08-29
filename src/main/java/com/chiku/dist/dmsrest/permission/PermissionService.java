package com.chiku.dist.dmsrest.permission;

import com.chiku.dist.dmsrest.user.UserRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermissionService {

    private final PermissionRepository permissionRepository;

    @Autowired
    public PermissionService(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public void addNewPermission(List<Permission> permission) {
        List<Permission> allPermissions = getPermissionsByUserName(permission.get(0).getUserName(), permission.get(0).getInstance());
        permissionRepository.deleteAll(allPermissions);
        permissionRepository.saveAll(permission);
    }

    public List<Permission> getPermissionsByUserName(String userName, String instance) {
        return permissionRepository.findAll().stream().filter(f -> f.getUserName().equals(userName)
                        && f.getInstance().equals(instance))
                .collect(Collectors.toList());
    }

    public List<Permission> getPermissionsByUserNameAndScreenNo(String userName, String screenNumber, String instance) {
        return permissionRepository.findAll().stream().filter(f -> f.getUserName().equals(userName)
                        && f.getInstance().equals(instance)
                        && f.getScreen().equals(screenNumber))
                .collect(Collectors.toList());
    }


    void deleteSinglePermission(Permission permission) {
        permissionRepository.deleteById(permission.getId());
    }
}
