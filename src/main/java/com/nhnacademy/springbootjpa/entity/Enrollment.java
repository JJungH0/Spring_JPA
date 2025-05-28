package com.nhnacademy.springbootjpa.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

// TODO #3: `enrollment` 테이블과 매핑될 `Enrollment` Entity 클래스
//           Entity 매핑과 연관관계 매핑을 하세요.
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
public class Enrollment {
    @Id
    private Long id;


    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    private ZonedDateTime enrolledAt;

    public Enrollment(Student student, Course course, ZonedDateTime enrolledAt) {
        this.student = student;
        this.course = course;
        this.enrolledAt = enrolledAt;
    }

//    @EmbeddedId
//    private EnrollmentId id;
//
//    @ManyToOne
//    @MapsId("studentId")
//    @JoinColumn(name = "studnet_id")
//    private Student student;
//
//    @ManyToOne
//    @MapsId("courseId")
//    @JoinColumn(name = "course_id")
//    private Course course;
//
//
//    @Column(name = "enrolled_at")
//    private ZonedDateTime enrolledAt;
//
//    public Enrollment(Student student, Course course, ZonedDateTime zonedDateTime) {
//        this.student = student;
//        this.course = course;
//        this.enrolledAt = zonedDateTime;
//    }

}
