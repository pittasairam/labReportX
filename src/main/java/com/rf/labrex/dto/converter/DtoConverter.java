package com.rf.labrex.dto.converter;

import com.rf.labrex.dto.HospitalDto;
import com.rf.labrex.dto.PatientDto;
import com.rf.labrex.dto.ReportDto;
import com.rf.labrex.dto.WorkerDto;
import com.rf.labrex.entity.Hospital;
import com.rf.labrex.entity.LaboratoryWorker;
import com.rf.labrex.entity.Patient;
import com.rf.labrex.entity.Report;
import org.springframework.stereotype.Component;

@Component
public class DtoConverter {
    public HospitalDto convertHospital(Hospital hospital){HospitalDto hospitalDto=HospitalDto.builder().id(hospital.getId()).image(hospital.getImage()).name(hospital.getName()).build();
    return hospitalDto;
    }
    public WorkerDto convertWorker(LaboratoryWorker worker){
        WorkerDto workerDto= WorkerDto.builder().id(worker.getId()).name(worker.getName()).lastName(worker.getLastName()).
        identificationNumber(worker.getIdentificationNumber()).role(worker.getRole()).hospital(convertHospital(worker.getHospital()))
                .build();
        return workerDto;
    }
    public PatientDto convertPatient(Patient patient){
        PatientDto dto=PatientDto.builder().
                name(patient.getName()).lastName(patient.getLastName()).id(patient.getId()).identificationNumber(patient.getIdentificationNumber())
                        .role(patient.getRole()).
                build();
        return dto;
    }
    public ReportDto convertReport(Report report){
        ReportDto reportDto=ReportDto.builder()
                .title(report.getTitle())
                .details(report.getDetails())
                .dateTime(report.getDateTime())
                .patient(convertPatient(report.getPatient()))
                .worker(convertWorker(report.getWorker()))
                .id(report.getId())
                .image(report.getImage())
                .build();
        return reportDto;
    }
}
