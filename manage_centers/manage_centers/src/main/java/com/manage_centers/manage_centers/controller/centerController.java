package com.manage_centers.manage_centers.controller;
import java.util.List;

import com.manage_centers.manage_centers.Dto.VaccineCenterDTO;
import com.manage_centers.manage_centers.model.vaccine_center;
import com.manage_centers.manage_centers.services.vaccineCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/center")
public class centerController {
    @Autowired
    private vaccineCenterService centerService ;

    @GetMapping("/getcanters")
    public List<vaccine_center> getAllCenters() {
        return centerService.getAllvaccineCenters();
    }

    @GetMapping("/{id}/findbyid")
    public vaccine_center findCenter(@PathVariable Integer id)
    {
        return centerService.findById(id);
    }

    @PostMapping("/addcenter")
    public vaccine_center addnewCenter(@RequestBody vaccine_center center)
    {
        return centerService.addCenter(center);

    }


    @DeleteMapping("/{id}/deletecenter")
    public String deletecenter(@PathVariable Integer id)
    {
        return centerService.deletecenterbyID(id);
    }

    @PutMapping("/{id}/updatecenter")
    public ResponseEntity<vaccine_center> updateCenterById(@PathVariable Integer id, @RequestBody vaccine_center center) {
        vaccine_center updatedCenter = centerService.updateCenterbyID(id, center);
        return new ResponseEntity<>(updatedCenter, HttpStatus.OK);
    }


    @GetMapping("/vaccine-centers")
    public ResponseEntity<List<VaccineCenterDTO>> getAllVaccineCenters() {
        List<VaccineCenterDTO> centers = centerService.getAllVaccineCenters();
        return ResponseEntity.ok(centers);
    }
}
