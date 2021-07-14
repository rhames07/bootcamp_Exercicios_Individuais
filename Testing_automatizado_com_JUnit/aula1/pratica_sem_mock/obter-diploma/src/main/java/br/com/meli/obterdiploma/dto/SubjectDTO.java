package br.com.meli.obterdiploma.dto;

import javax.validation.Valid;

public class SubjectDTO {
    private @Valid StudentDTO student;
    private double average;
    private String message;

    public SubjectDTO(StudentDTO student, double average, String message) {
        this.message = message;
        this.average = average;
        this.student = student;

    }

    public SubjectDTO() {
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO studentDTO) {
        this.student = studentDTO;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SubjectDTO{" +
                "student=" + student +
                ", average=" + average +
                ", message='" + message + '\'' +
                '}';
    }
}
