package com.manage_vaccine.manage_vaccine.controller;
import java.util.List;

import com.manage_vaccine.manage_vaccine.model.vaccine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.manage_vaccine.manage_vaccine.services.vaccineService;


@CrossOrigin
@RestController
@RequestMapping("/vaccine")
public class vaccineController {
    @Autowired
    private vaccineService vaccineService ;

    @GetMapping("/getvaccines")
    public List<vaccine> getAllvaccines() {
        return vaccineService.getAllvaccines();
    }

    @GetMapping("/{id}/findVaccine")
    public vaccine findVaccine(@PathVariable Integer id)
    {
        return vaccineService.findById(id);
    }

    @PostMapping("/addnewVaccine")
    public vaccine addnewVaccine(@RequestBody vaccine vaccine)
    {
        return vaccineService.addVaccine(vaccine);
    }

    @DeleteMapping("/{id}/deletevaccine")
    public String deleteVaccine(@PathVariable Integer id)
    {
        return vaccineService.deleteVaccinebyID(id);
    }

    @PutMapping("/{id}/updatevaccine")
    public vaccine updateCenterById(@PathVariable Integer id, @RequestBody vaccine vaccine) {
        return vaccineService.updateVaccinebyID(id, vaccine);
    }

}
