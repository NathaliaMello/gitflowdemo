package com.nathaliamello.gitflowdemo.user.service;

import com.nathaliamello.gitflowdemo.common.response.ApiResponse;
import com.nathaliamello.gitflowdemo.common.response.Link;
import com.nathaliamello.gitflowdemo.common.util.LinkUtils;
import com.nathaliamello.gitflowdemo.user.dto.CreateUserDTO;
import com.nathaliamello.gitflowdemo.user.dto.UserOutputDTO;
import com.nathaliamello.gitflowdemo.user.exception.ResourceNotFoundException;
import com.nathaliamello.gitflowdemo.user.model.UserModel;
import com.nathaliamello.gitflowdemo.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ApiResponse<UserOutputDTO> getUserById(Long id) {
        UserModel userModel = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " was not found on the database"));

        UserOutputDTO userOutputDTO = convertToDTO(userModel);

        List<Link> links = LinkUtils.createLinksForResource(userOutputDTO.getId(), "/api/users");

        return new ApiResponse<>(
                userOutputDTO,
                "Usuário encontrado com sucesso",
                HttpStatus.OK.value(),
                null,
                null,
                links
        );
    }

    @Transactional
    public ApiResponse<UserOutputDTO> createUser(CreateUserDTO createUserDTO) {
        // Converter UserInputDTO para UserModel
        UserModel userModel = convertToEntity(createUserDTO);

        // Salvar o usuário no banco de dados
        UserModel savedUser = userRepository.save(userModel);

        // Converter o UserModel salvo para UserOutputDTO
        UserOutputDTO userOutputDTO = convertToDTO(savedUser);

        List<Link> links = LinkUtils.createLinksForResource(userOutputDTO.getId(), "/api/users");
        // Retornar a resposta encapsulada em ApiResponse
        return new ApiResponse<>(
                userOutputDTO,
                "Usuário criado com sucesso",
                HttpStatus.CREATED.value(),
                null,
                null,
                links
        );
    }

    private UserOutputDTO convertToDTO(UserModel userModel) {
        UserOutputDTO dto = new UserOutputDTO();
        dto.setId(userModel.getId());
        dto.setName(userModel.getName());
        dto.setEmail(userModel.getEmail());
        dto.setDateOfBirth(userModel.getBirthDate());
        return dto;
    }

    private UserModel convertToEntity(CreateUserDTO createUserDTO) {
        UserModel userModel = new UserModel();
        userModel.setName(createUserDTO.getName());
        userModel.setEmail(createUserDTO.getEmail());
        userModel.setCpf(createUserDTO.getCpf());
        userModel.setBirthDate(createUserDTO.getBirthdate());
        return userModel;
    }

}
