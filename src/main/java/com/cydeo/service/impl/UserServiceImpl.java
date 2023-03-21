package com.cydeo.service.impl;

import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl extends AbstractMapService<UserDTO, String> implements UserService {
    @Override
    public UserDTO save(UserDTO userDTO) {
        return super.save(userDTO.getUserName(), userDTO);
    }

    @Override
    public List<UserDTO> FindAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String email) {
        super.deleteById(email);
    }

    @Override
    public UserDTO findById(String email) {
        return super.findById(email);
    }
}
