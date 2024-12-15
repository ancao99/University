package com.example.SpringOne.service;

import com.example.SpringOne.pojo.University;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class UniversityService {

    private static final String API_BASE_URL = "http://universities.hipolabs.com/search";

    @Autowired
    private RestTemplate restTemplate;

    // Fetch universities by a single country
    public List<University> getUniversitiesByCountry(String country) {
        String url = API_BASE_URL + "?country=" + country;
        try {
            University[] response = restTemplate.getForObject(url, University[].class);
            return response != null ? List.of(response) : new ArrayList<>();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch data for country: " + country, e);
        }
    }

    // Fetch universities for multiple countries using multithreading
    public List<University> getUniversitiesForMultipleCountries(List<String> countries) {
        List<CompletableFuture<List<University>>> futures = new ArrayList<>();

        for (String country : countries) {
           futures.add(CompletableFuture.supplyAsync(() -> getUniversitiesByCountry(country)));
        }

        List<University> allResults = new ArrayList<>();
        for (CompletableFuture<List<University>> future : futures) {
            try {
                allResults.addAll(future.get());
            } catch (Exception e) {
                throw new RuntimeException("Error while fetching data for one or more countries", e);
            }
        }
        return allResults;
    }
}
