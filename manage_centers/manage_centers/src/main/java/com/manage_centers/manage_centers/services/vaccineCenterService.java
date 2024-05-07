package com.manage_centers.manage_centers.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.manage_centers.manage_centers.Dto.VaccineCenterDTO;
import com.manage_centers.manage_centers.model.vaccine_center;
import com.manage_centers.manage_centers.repository.centerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class vaccineCenterService {

    @Autowired
    private centerRepository centerRepo;

    public List<vaccine_center> getAllvaccineCenters() {
        return centerRepo.findAll();
    }

    public vaccine_center findById(Integer id)
    {
        Optional<vaccine_center> optional = centerRepo.findById(id);
        vaccine_center center = null;
        if(optional.isPresent())
        {
            center=optional.get();
        }
        else
        {
            throw new RuntimeException("no found");
        }
        return center;

    }

    public  vaccine_center addCenter(vaccine_center center)
    {
        return centerRepo.save(center);
    }


    public String deletecenterbyID(Integer id)
    {
        Optional <vaccine_center> optional = centerRepo.findById(id);
        if(optional.isPresent())
        {
            centerRepo.deleteById(id);
            return "deleted successfully";
        }
        else
        {
            return " id not found";
        }
    }


    public vaccine_center updateCenterbyID(Integer id,vaccine_center center)
    {
        Optional<vaccine_center> optional = centerRepo.findById(id);
        if (optional.isPresent()) {
            vaccine_center updatedCenter = optional.get();
            updatedCenter.setCenterName(center.getCenterName());
            updatedCenter.setVaccineType(center.getVaccineType());
            updatedCenter.setAddress(center.getAddress());
            updatedCenter.setContactInfo(center.getContactInfo());
            return centerRepo.save(updatedCenter);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Center not found");
        }
    }


    public List<VaccineCenterDTO> getAllVaccineCenters() {
        List<vaccine_center> vaccineCenters = centerRepo.findAll();
        return vaccineCenters.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private VaccineCenterDTO convertToDTO(vaccine_center vaccineCenter) {
        VaccineCenterDTO dto = new VaccineCenterDTO();
        dto.setCenterName(vaccineCenter.getCenterName());
        dto.setVaccineType(vaccineCenter.getVaccineType());
        dto.setAddress(vaccineCenter.getAddress());
        return dto;
    }

}
