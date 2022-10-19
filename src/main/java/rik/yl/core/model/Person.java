package rik.yl.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Person {
    public static final String person_id = "ID";

    @Id
    @SequenceGenerator(
            name = "person_sequence",
            sequenceName = "person_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "person_sequence"
    )
    @Column(name = person_id)
    private Long id;
    private Integer personalCode;
    private String personName;
    private String personSurname;
    private Boolean payment;
    private String personInfo;
    //many-to-one FK
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

}
