package rik.yl.core.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Event {
    public static final String e_id = "id";

    @Id
    @SequenceGenerator(
            name = "event_sequence",
            sequenceName = "event_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "event_sequence"
    )
    @Column(name = e_id)
    private Long id;
    private String eventName;
    private Timestamp time;
    private String place;
    private String info;

    @OneToMany(mappedBy = e_id)
    private Set<Person> persons;

    @OneToMany(mappedBy = e_id)
    private Set<Company> companies;
}
