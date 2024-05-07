package com.manage_vaccine.manage_vaccine.services;

import java.util.List;
import java.util.Optional;

import com.manage_vaccine.manage_vaccine.model.vaccine;
import com.manage_vaccine.manage_vaccine.repository.vaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class vaccineService {

    @Autowired
    private vaccineRepository vaccineRepo;

    public List<vaccine> getAllvaccines() {
        return vaccineRepo.findAll();
    }

    public vaccine findById(Integer id)
    {
        Optional <vaccine> optional = vaccineRepo.findById(id);
        vaccine vaccine = null;
        if(optional.isPresent())
        {
            vaccine=optional.get();
        }
        else
        {
            throw new RuntimeException("no found");
        }
        return vaccine;

    }

    public vaccine addVaccine(vaccine vaccine)
    {
        return vaccineRepo.save(vaccine);
    }

    public String deleteVaccinebyID(Integer id)
    {
        Optional <vaccine> optional = vaccineRepo.findById(id);
        if(optional.isPresent())
        {
            vaccineRepo.deleteById(id);
            return "deleted successfully";
        }
        else
        {
            return " id not found";
        }
    }
    
    public vaccine updateVaccinebyID(Integer id, vaccine vaccine) {
        Optional<vaccine> optional = vaccineRepo.findById(id);
        if (optional.isPresent()) {
            vaccine existingVaccine = optional.get();
            existingVaccine.setVaccineName(vaccine.getVaccineName());
            existingVaccine.setPrecautions(vaccine.getPrecautions());
            existingVaccine.setCenterName(vaccine.getCenterName());
            existingVaccine.setdoesNumber(vaccine.getdoesNumber());
            existingVaccine.setTime(vaccine.getTime());
            return vaccineRepo.save(existingVaccine);
        } else {
            return null; // or throw an exception
        }
    }
    
}
