package myboot.app2.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Counter {

    @Id
    private String name;

    @Basic
    private Integer value;

}