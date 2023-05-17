package com.denishranpariya.jpalearning.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseMaterial {
    @Id
    @SequenceGenerator(name = "course_material_sequence", sequenceName = "course_material_sequence", allocationSize = 1)
    @GeneratedValue(generator = "course_material_sequence", strategy = GenerationType.SEQUENCE)
    private Long courseMaterialId;
    private String url;

    //one to one relation ship
    @OneToOne
    @JoinColumn(name = "course_id", referencedColumnName = "courseId")
    private Course course;
}
