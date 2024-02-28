package com.rf.labrex.service;

import com.rf.labrex.dto.SaveReportRequest;
import com.rf.labrex.dto.UpdateReportRequest;
import com.rf.labrex.entity.LaboratoryWorker;
import com.rf.labrex.entity.Patient;
import com.rf.labrex.entity.Report;
import com.rf.labrex.errorManagement.ApiResponse;
import com.rf.labrex.exception.NotFoundException;
import com.rf.labrex.repository.ReportRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReportService {
    private final ReportRepository reportRepository;
    private final WorkerService workerService;
    private final PatientService patientService;

    public ApiResponse save(SaveReportRequest request, String workerId, String patientId, HttpServletRequest url) {
        ApiResponse apiResponse = new ApiResponse();
        LaboratoryWorker worker = workerService.findById(workerId);
        Patient patient = patientService.findById(patientId);
        Report report=Report.builder().title(request.getTitle()).details(request.getDetails()).worker(worker).patient(patient).dateTime(LocalDateTime.now()).build();
        reportRepository.save(report);
        apiResponse=ApiResponse.builder().status(200).path(url.getRequestURI()).message("Rapor Oluşturuldu").dateTime(apiResponse.getDateTime()).build();
        return apiResponse;
    }

    public ApiResponse update(UpdateReportRequest request, String id, HttpServletRequest path) {
        ApiResponse apiResponse=new ApiResponse();
        Report report=findById(id);
        report.setDateTime(request.getDateTime());
        report.setTitle(request.getTitle());
        report.setDetails(request.getDetails());
        reportRepository.save(report);
        apiResponse=ApiResponse.builder().status(200).path(path.getRequestURI()).message("Rapor Güncellendi").dateTime(apiResponse.getDateTime()).build();
        return apiResponse;
    }
    public ApiResponse delete(String id,HttpServletRequest path) {
        Report report=findById(id);
        reportRepository.delete(report);
        return ApiResponse.builder().status(200).path(path.getRequestURI()).message("Rapor Silindi").dateTime(LocalDateTime.now()).build();
    }
    protected Report findById(String id){
        return reportRepository.findById(id).orElseThrow(()->new NotFoundException("Rapor"));
    }

}
