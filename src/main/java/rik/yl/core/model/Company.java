package rik.yl.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Company {
    public static final String company_id = "ID";

    @Id
    @SequenceGenerator(
            name = "company_sequence",
            sequenceName = "company_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_sequence"
    )
    @Column(name = company_id)
    private Long id;
    private Integer registerCode;
    private String companyName;
    private Integer companyParticipants;
    private Boolean payment;
    private String companyInfo;
    //many-to-one FK
    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

}

