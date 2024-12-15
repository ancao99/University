package com.example.SpringOne.controller;

import com.example.SpringOne.pojo.University;
import com.example.SpringOne.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("universities")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    // Fetch universities by a single country
    @GetMapping("/search")
    public ResponseEntity<List<University>> getUniversitiesByCountry(@RequestParam String country) {
        List<University> universities = universityService.getUniversitiesByCountry(country);
        return new ResponseEntity<>(universities, HttpStatus.OK);
    }

    // Fetch universities for multiple countries
    @PostMapping("/search")
    public ResponseEntity<List<University>> getUniversitiesForMultipleCountries(@RequestBody List<String> countries) {
        List<University> universities = universityService.getUniversitiesForMultipleCountries(countries);
        return new ResponseEntity<>(universities, HttpStatus.OK);
    }
}
