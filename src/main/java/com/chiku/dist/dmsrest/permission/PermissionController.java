package com.chiku.dist.dmsrest.permission;


import com.chiku.dist.dmsrest.user.User;
import com.chiku.dist.dmsrest.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/permission")
public class PermissionController {
    private final PermissionService permissionService;

    @Autowired
    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @PostMapping(path = "/add")
    public void createPermission(@RequestBody List<Permission> permission) {
        permissionService.addNewPermission(permission);
    }

    @PostMapping(path = "/delete")
    public void deletePermission(@RequestBody Permission permission) {
        permissionService.deleteSinglePermission(permission);
    }

    @GetMapping(path = "/get/{instance}/{user_name}")
    public List<Permission> getPermissionListByUserName(@PathVariable("user_name") String userName,@PathVariable("instance") String instance) {
        return permissionService.getPermissionsByUserName(userName,instance);
    }
}
