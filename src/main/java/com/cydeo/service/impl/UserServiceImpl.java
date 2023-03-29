package com.cydeo.service.impl;

import com.cydeo.dto.RoleDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends AbstractMapService<UserDTO, String> implements UserService {
    @Override
    public UserDTO save(UserDTO userDTO) {return super.save(userDTO.getUserName(), userDTO);}

    @Override
    public List<UserDTO> FindAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String email) {
        super.deleteById(email);
    }

    @Override
    public void update(String id, UserDTO userDTO) {
        super.update(id, userDTO);
    }

    @Override
    public UserDTO findById(String email) {
        return super.findById(email);
    }

    public List<UserDTO> findByPosition(String role)
    {
        return super.findAll()
                .stream()
                .filter(a->a.getRoleDTO().getDescription().equalsIgnoreCase(role))
                .collect(Collectors.toList());
    }

}
