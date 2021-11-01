package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Farm;
import co.usa.ciclo3.ciclo3.repository.FarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FarmService {

    @Autowired
    private FarmRepository farmRepository;

    public List<Farm> getAll(){
        return farmRepository.getAll();
    }

    public Optional<Farm> getFarm(int id){
        return farmRepository.getFarm(id);
    }

    public Farm save(Farm f){
        if(f.getId()==null){
            return farmRepository.save(f);
        }else{
            Optional<Farm> paux=farmRepository.getFarm(f.getId());
            if(paux.isEmpty()){
                return farmRepository.save(f);
            }else{
                return f;
            }
        }
    }
    
    public Farm update(Farm farm) {
        if (farm.getId() != null) {
            Optional<Farm> e = farmRepository.getFarm(farm.getId());
            if (!e.isEmpty()) {
                if (farm.getName() != null) {
                    e.get().setName(farm.getName());
                }
                if (farm.getAddress() != null) {
                    e.get().setAddress(farm.getAddress());
                }
                if (farm.getExtension() != null) {
                    e.get().setExtension(farm.getExtension());
                }
                if (farm.getDescription() != null) {
                    e.get().setDescription(farm.getDescription());
                }

                farmRepository.save(e.get());
                return e.get();
            } else {
                return farm;
            }
        } else {
            return farm;
        }
    }

    public boolean deletefarm(int farmId) {
        Boolean aBoolean = getFarm(farmId).map(farm -> {
            farmRepository.delete(farm);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
