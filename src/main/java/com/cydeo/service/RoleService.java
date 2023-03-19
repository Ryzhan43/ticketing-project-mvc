package com.cydeo.service;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;

public interface RoleService {

    UserDTO save(RoleDTO roleDTO);
    UserDTO findByID(Long id);

}
