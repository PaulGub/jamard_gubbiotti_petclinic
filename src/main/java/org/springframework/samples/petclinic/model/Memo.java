package org.springframework.samples.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * Simple JavaBean domain object representing a memo. * * @author Helena Berger
 */
@Entity
@Table(name = "memos")
public class Memo extends BaseEntity {
    /**
     * Holds value of property date.
     */
    @Column(name = "memo_date")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate date;
    /**
     * Holds value of property description.
     */
    @NotEmpty
    @Column(name = "description")
    private String description;
    /**
     * Holds value of property vet.
     */
    @ManyToOne
    @JoinColumn(name = "vet_id")
    private Vet vet;

    /**
     * Creates a new instance of Memo for the current date
     */
    public Memo() {
        this.date = LocalDate.now();
    }

    /**
     * Getter for property date. *
     * 7
     *
     * @return Value of property date.
     */
    public LocalDate getDate() {
        return this.date;
    }

    /**
     * Setter for property date. * * @param date New value of property date.
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

    /**
     * Getter for property description. * * @return Value of property description.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Setter for property description. * * @param description New value of property description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for property vet. * * @return Value of property vet.
     */
    public Vet getVet() {
        return this.vet;
    }

    /**
     * Setter for property vet. * * @param vet New value of property vet.
     */
    public void setVet(Vet vet) {
        this.vet = vet;
    }
}
