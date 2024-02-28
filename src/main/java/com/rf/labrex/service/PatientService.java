package com.rf.labrex.service;

import com.rf.labrex.dto.SavePatientRequest;
import com.rf.labrex.entity.Patient;
import com.rf.labrex.errorManagement.ApiResponse;
import com.rf.labrex.exception.NotFoundException;
import com.rf.labrex.repository.PatientRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final PasswordEncoder encoder;
    public ApiResponse save(SavePatientRequest request, HttpServletRequest url) {
        ApiResponse apiResponse=new ApiResponse();
        Patient patient=request.toPatient(request);
        patient.setPassword(encoder.encode(request.getPassword()));
        patientRepository.save(patient);
        apiResponse= ApiResponse.builder().status(200).path(url.getRequestURI()).dateTime(apiResponse.getDateTime()).message("Hasta Kayıt oldu").build();
        return apiResponse;
    }

    public ApiResponse delete(String id, HttpServletRequest url) {
        ApiResponse apiResponse=new ApiResponse();
        Patient patient=findById(id);
        patientRepository.delete(patient);
        apiResponse=ApiResponse.builder().status(200).message("Hasta Silindi").dateTime(apiResponse.getDateTime()).path(url.getRequestURI()).build();
        return apiResponse;
    }

    protected Patient findById(String patientId) {
        return patientRepository.findById(patientId).orElseThrow(()->new NotFoundException("Hasta"));
    }
}
