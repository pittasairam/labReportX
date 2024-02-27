package com.rf.labrex.dto.converter;

import com.rf.labrex.dto.HospitalDto;
import com.rf.labrex.entity.Hospital;
import org.springframework.stereotype.Component;

@Component
public class DtoConverter {
    public HospitalDto convertHospital(Hospital hospital){HospitalDto hospitalDto=HospitalDto.builder().id(hospital.getId()).image(hospital.getImage()).name(hospital.getName()).build();
    return hospitalDto;
    }
}
