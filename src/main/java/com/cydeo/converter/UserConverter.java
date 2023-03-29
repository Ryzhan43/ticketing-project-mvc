package com.cydeo.converter;


import com.cydeo.dto.UserDTO;
import com.cydeo.service.UserService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class UserConverter implements Converter<String, UserDTO> {

    UserService userService;

    public UserConverter(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDTO convert(String s) {
        return userService.findById(s);
    }
}
