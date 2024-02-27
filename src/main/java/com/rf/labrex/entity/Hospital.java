package com.rf.labrex.entity;

import com.rf.labrex.config.UniqueIdGenerator;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hospital {
    @Id
    private String hospitalId= UniqueIdGenerator.generateUniqueId();
    private String name;
    @OneToMany(mappedBy = "hospital",cascade = CascadeType.REMOVE)
    List<LaboratoryWorker> workers;


}
