package br.com.tutu.tutu.ws.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Table(name = "animal")
public class Animal {

    private static final String T_DEFAULT_ANIMAL_SUBKIND = "SRD";

    public enum AnimalKind{
        DOG,
        CAT,
        BIRD,
        OTHER
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull
    private String name;

    @Enumerated(EnumType.STRING)
    private AnimalKind kind;

    @NotNull
    private String subKind;

    private Character sex;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    private double weight;

    public Animal(){}

    public Animal(String name, AnimalKind kind, String subKind) {
        this.setName(name);
        this.setKind(kind);
        this.setSubKind(subKind);
    }

    public Animal(String name) {
        this.setName(name);
        this.setKind(AnimalKind.DOG);
        this.setSubKind(T_DEFAULT_ANIMAL_SUBKIND);
    }

    @Override
    public String toString() {
        return String.format("Animal[id=%d, name='%s', kind='%s', subKind='%s']",
                this.getId(), this.getName(), this.getKind(), this.getSubKind());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AnimalKind getKind() {
        return kind;
    }

    public void setKind(AnimalKind kind) {
        this.kind = kind;
    }

    public String getSubKind() {
        return subKind;
    }

    public void setSubKind(String subKind) {
        this.subKind = subKind;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
