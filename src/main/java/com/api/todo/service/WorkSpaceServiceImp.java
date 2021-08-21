package com.api.todo.service;

import java.util.ArrayList;
import java.util.List;

import com.api.todo.DTO.TransferDTO;
import com.api.todo.DTO.WorkSpaceDTO;
import com.api.todo.entity.User;
import com.api.todo.entity.WorkSpace;
import com.api.todo.exception.NotFoundException;
import com.api.todo.repository.WorkSpaceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkSpaceServiceImp implements WorkSpaceService {

    @Autowired
    private WorkSpaceRepository workSpaceRepository;

    // @Autowired
    // private UserRepository userRepository;

    @Autowired
    private TransferDTO transferDTO;

    @Override
    public List<WorkSpaceDTO> getWorkSpaces(String username) {
        List<WorkSpace> workSpaces = workSpaceRepository.findAllWorkSpacesByUsername(username);
        List<WorkSpaceDTO> workSpaceDTOs = new ArrayList<>();

        for(WorkSpace workSpace : workSpaces) {
            workSpaceDTOs.add(transferDTO.workSpaceTransferDTO(workSpace));
        }

        return workSpaceDTOs;
    }

    @Override
    public WorkSpaceDTO getWorkSpace(long id) {
        WorkSpace workSpace = workSpaceRepository.findById(id).get(); 
        return transferDTO.workSpaceTransferDTO(workSpace);
    }

    @Override
    public WorkSpaceDTO addWorkSpace(WorkSpace workSpace, User user) {
        workSpace.setUser(user);
        workSpaceRepository.save(workSpace);
        return transferDTO.workSpaceTransferDTO(workSpace);
    }

    @Override
    public WorkSpaceDTO updateWorkSpace(long id, WorkSpace workSpace) {
        boolean checkWorkSpaceExists = workSpaceRepository.findById(id).isPresent();

        if(!checkWorkSpaceExists) {
            throw new NotFoundException("Không tìm thấy work space với id: " + id);
        } else {
            WorkSpace workSpaceCurrent = workSpaceRepository.findById(id).get();
            System.out.println(workSpaceCurrent);
            workSpaceCurrent.setName(workSpace.getName());
            workSpaceRepository.save(workSpaceCurrent);
            return transferDTO.workSpaceTransferDTO(workSpaceCurrent);
        }
    }

    // @Override
    // public WorkSpaceDTO updateWorkSpaceAddUser(long workSpaceId, long userId) {
    //     WorkSpace workSpace = workSpaceRepository.findById(workSpaceId).get();
    //     User user = userRepository.findById(userId).get();

    //     workSpace.setUser(user);
    //     workSpaceRepository.save(workSpace);
        
    //     return transferDTO.workSpaceTransferDTO(workSpace);
    // }

    @Override
    public void deleteWorkSpace(long id) {
        workSpaceRepository.deleteById(id);
    }
    
}
