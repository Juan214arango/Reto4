package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Reservations;
import co.usa.ciclo3.ciclo3.repository.ReservationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationsService {

    @Autowired
    private ReservationsRepository reservationsRepository;

    public List<Reservations> getAll(){
        return reservationsRepository.getAll();
    }

    public Optional<Reservations> getReservations(int idReservations){
        return reservationsRepository.getReservations(idReservations);
    }

    public Reservations save(Reservations r){
        if(r.getIdReservation()==null){
            return reservationsRepository.save(r);
        }else{
            Optional<Reservations> paux=reservationsRepository.getReservations(r.getIdReservation());
            if(paux.isEmpty()){
                return reservationsRepository.save(r);
            }else{
                return r;
            }
        }
    }

    public Reservations update(Reservations reservacion){
        if(reservacion.getIdReservation()!=null){
            Optional<Reservations> e= reservationsRepository.getReservations(reservacion.getIdReservation());
            if(!e.isEmpty()){

                if(reservacion.getStartDate()!=null){
                    e.get().setStartDate(reservacion.getStartDate());
                }
                if(reservacion.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservacion.getDevolutionDate());
                }
                if(reservacion.getStartDate()!=null){
                    e.get().setStartDate(reservacion.getStartDate());
                }
                reservationsRepository.save(e.get());
                return e.get();
            }else{
                return reservacion;
            }
        }else{
            return reservacion;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservations(reservationId).map(reservation -> {
            reservationsRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}