package com.universityMVP.api.model;

@Entity
@Table(name = "register")
public class Register
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_class")
    private Class class;

    @ManyToOne
    @JoinColumn(name = "id_course")
    private Course course;

    private float grade1;
    private float grade2;

    private int faults;

    private float average;
    private String status;

    // Getters and Setters   
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Class getClassEntity() { return classEntity; }
    public void setClassEntity(Class classEntity) { this.classEntity = classEntity; }
    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
    public float getGrade1() { return grade1; }
    public void setGrade1(float grade1) { this.grade1 = grade1; }
    public float getGrade2() { return grade2; }
    public void setGrade2(float grade2) { this.grade2 = grade2; }
    public int getFaults() { return faults; }
    public void setFaults(int faults) { this.faults = faults; }
    public float getAverage() { return average; }
    public void setAverage(float average) { this.average = average; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
