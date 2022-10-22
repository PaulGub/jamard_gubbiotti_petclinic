package org.springframework.samples.petclinic.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Table(name = "operations")
public class Operation extends BaseEntity {

    /**
     * Holds value of property date.
     */
    @Column(name = "operations_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate date;

    /**
     * Holds value of property description.
     */
    @NotEmpty
    @Column(name = "description")
    private String description;

    /**
     * Holds value of property pet.
     */
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    /**
     * Holds value of property vet.
     */
    @ManyToOne
    @JoinColumn(name = "vet_id")
    private Vet vet;

    /**
     * Creates a new instance of an Operation for the current date
     */
    public Operation() {
        this.date = LocalDate.now();
    }


    /**
     * Getter for property date.
     *
     * @return Value of property date.
     */
    public LocalDate getDate() {
        return this.date;
    }

    /**
     * Setter for property date.
     *
     * @param date New value of property date.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Getter for property description.
     *
     * @return Value of property description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter for property description.
     *
     * @param description New value of property description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for property pet.
     *
     * @return Value of property pet.
     */
    public Pet getPet() {
        return this.pet;
    }

    /**
     * Setter for property pet.
     *
     * @param pet New value of property pet.
     */
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    /**
     * Getter for property vet.
     *
     * @return Value of property vet.
     */
    public Vet getVet() {
        return this.vet;
    }

    /**
     * Setter for property vet.
     *
     * @param vet New value of property vet.
     */
    public void setVet(Vet vet) {
        this.vet = vet;
    }
}
