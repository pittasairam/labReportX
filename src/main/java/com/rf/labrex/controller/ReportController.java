package com.rf.labrex.controller;

import com.rf.labrex.dto.SaveReportRequest;
import com.rf.labrex.dto.UpdateReportRequest;
import com.rf.labrex.service.ReportService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api/v1/report")
public class ReportController {
    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }


    /*----BURADAKİ İŞLEMLERİ SADECE LABORANT YAPABİLİR----*/
    // rapor oluştur
    @PostMapping("/save/{workerId}/{patientId}")
    public ResponseEntity<?> save(@Valid @RequestBody SaveReportRequest request, @PathVariable String workerId, @PathVariable String patientId, HttpServletRequest url) {
        return ResponseEntity.ok(reportService.save(request,workerId,patientId,url));
    }

    // rapor güncelle
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody UpdateReportRequest request, @PathVariable String id, HttpServletRequest path) {
        return ResponseEntity.ok(reportService.update(request,id,path));
    }

    // rapor sil
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable String id,HttpServletRequest path) {
        return ResponseEntity.ok(reportService.delete(id,path));
    }

    // laboranta ait raporlar
    public ResponseEntity<?> reportsForWorker(@PathVariable String workerId) {
        return null;
    }
    /*------------------------------------------------------*/

    /*BURADAKİ İŞLEMİ HASTA VE LABORANT YAPABİLİR*/
    // hastaya ait raporları görüntüleme
    public ResponseEntity<?> reportsForPatients() {
        return null;
    }

    // herhangi bir raporu görüntüleme
    public ResponseEntity<?> get() {
        return null;
    }

    // Hasta Adı Soyadı kimlik numarasi ,Laboran Adi Soyadı ile Arama
    public ResponseEntity<?> search() {
        return null;
    }

    // Rapor tarihi ile sıralama
    public ResponseEntity<?> searchByDate() {
        return null;
    }
    /*---------------------------------------------*/

}
