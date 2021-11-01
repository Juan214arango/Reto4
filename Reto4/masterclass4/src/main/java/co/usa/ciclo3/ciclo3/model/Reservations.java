package co.usa.ciclo3.ciclo3.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="reservations")
public class Reservations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;
    private String startDate;
    private String devolutionDate;


    @ManyToOne
    @JoinColumn(name="farmId")
    @JsonIgnoreProperties("reservations")
    private Farm farm;

    @ManyToOne
    @JoinColumn(name="clientId")
    @JsonIgnoreProperties("reservations")
    private Client client;


    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }
    public String getDevolutionDate() {
        return devolutionDate;
    }
    public void setDevolutionDate(String devolutionDate) {
        this.devolutionDate = devolutionDate;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public Farm getFarm() {
        return farm;
    }
    public void setFarm(Farm farm) {
        this.farm = farm;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    } 
}
