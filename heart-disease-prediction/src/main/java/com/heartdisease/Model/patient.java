package com.heartdisease.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int age;
    private int sex;
    private int cp; // chest pain type
    private int trestbps; // resting blood pressure
    private int chol; // serum cholesterol
    private int fbs; // fasting blood sugar
    private int restecg; // resting ECG results
    private int thalach; // maximum heart rate achieved
    private int exang; // exercise induced angina
    private int oldpeak; // ST depression induced by exercise relative to rest
    private int slope; // slope of the peak exercise ST segment
    private int ca; // number of major vessels colored by fluoroscopy
    private int thal; // thalassemia (3 = normal; 6 = fixed defect; 7 = reversable defect)
}
