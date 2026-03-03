package com.universityMVP.api.model;

@Entity
@Table(name = "activities")
public class Activities 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_class")
    private Class class;

    private String description;
    private Date activity_due_date;
    private float max_value;
}
