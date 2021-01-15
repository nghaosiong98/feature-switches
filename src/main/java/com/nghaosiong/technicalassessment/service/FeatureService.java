package com.nghaosiong.technicalassessment.service;

import com.nghaosiong.technicalassessment.model.entity.Feature;
import com.nghaosiong.technicalassessment.model.exception.FeatureNotFoundException;
import com.nghaosiong.technicalassessment.repository.FeatureRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeatureService {
    @Autowired
    FeatureRepository featureRepository;

    public List<Feature> getAllFeature() {
        ArrayList<Feature> features = new ArrayList<>();
        featureRepository.findAll().forEach(feature -> features.add(feature));
        return features;
    }

    public Feature getFeatureById(int id) {
        return featureRepository.findById(id).get();
    }

    public void saveOrUpdate(Feature feature) {
        featureRepository.save(feature);
    }

    public void delete(int id) {
        featureRepository.deleteById(id);
    }

    public Feature getFeatureByName(String name) {
        return featureRepository.findFeatureByName(name).orElseThrow(() ->
                new FeatureNotFoundException(name));
    }
}
