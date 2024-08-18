package com.heartdisease.service;

import com.heartdisease.model.Patient;
import com.heartdisease.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import ai.djl.Application;
import ai.djl.Model;
import ai.djl.ModelException;
import ai.djl.inference.Predictor;
import ai.djl.ndarray.NDManager;
import ai.djl.ndarray.types.Shape;
import ai.djl.repository.zoo.Criteria;
import ai.djl.repository.zoo.ModelZoo;
import ai.djl.translate.TranslateException;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class HeartDiseaseService {
    private Model model;
    private SavedModelBundle model;

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
    public HeartDiseaseService() {
        try {
            loadModel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void loadModel() throws ModelException, IOException {
        Path modelPath = Paths.get("path/to/your/model");
        model = Model.newInstance("heart-disease-model");
        model.load(modelPath);
    }
    public String predictHeartDisease(float[] inputFeatures) {
        try (NDManager manager = NDManager.newBaseManager()) {
            float[][] data = new float[][]{inputFeatures};
            try (Predictor<float[], String> predictor = model.newPredictor()) {
                return predictor.predict(data);
            }
        } catch (ModelException | TranslateException e) {
            e.printStackTrace();
            return "Prediction Failed";
        }
    }

    public Patient addPatient(Patient patient) {
        return patientRepository.save(patient);
    }


    // Add prediction logic here using your ML model
    public String predictHeartDisease(Patient patient) {
        // Placeholder for ML model prediction logic
        // Replace this with your actual prediction code
        return "No Disease";
    }
}
