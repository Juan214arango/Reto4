package co.usa.ciclo3.ciclo3.web;


import co.usa.ciclo3.ciclo3.model.Reservations;
import co.usa.ciclo3.ciclo3.service.ReservationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservations")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationsController {

    @Autowired
    private ReservationsService reservationsService;

    @GetMapping("/all")
    public List<Reservations> getReservations(){
        return reservationsService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Reservations> getReservations(@PathVariable("id") int id){
        return reservationsService.getReservations(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservations save(@RequestBody Reservations r){
        return reservationsService.save(r);
    }
    @PostMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservations update(@RequestBody Reservations r){
        return reservationsService.update(r);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return reservationsService.deleteReservation(reservationId);
    }
}
