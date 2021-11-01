package co.usa.ciclo3.ciclo3.web;


import co.usa.ciclo3.ciclo3.model.Farm;
import co.usa.ciclo3.ciclo3.service.FarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Farm")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class FarmController {

    @Autowired
    private FarmService farmService;

    @GetMapping("/all")
    public List<Farm> getFarm(){
        return farmService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Farm> getFarm(@PathVariable("id") int id){
        return farmService.getFarm(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Farm save(@RequestBody Farm f){
        return farmService.save(f);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Farm update(@RequestBody Farm farm) {
        return farmService.update(farm);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int farmId) {
        return farmService.deletefarm(farmId);
    }
}
