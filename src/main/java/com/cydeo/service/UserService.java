package com.cydeo.service;

import com.cydeo.dto.UserDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
public interface UserService extends CrudService<UserDTO, String> {
    List<UserDTO> findByPosition(String role);
}
