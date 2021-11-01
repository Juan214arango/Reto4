package co.usa.ciclo3.ciclo3.service;

import co.usa.ciclo3.ciclo3.model.Category;
import co.usa.ciclo3.ciclo3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category y){
        if(y.getId()==null){
            return categoryRepository.save(y);
        }else{
            Optional<Category> paux=categoryRepository.getCategory(y.getId());
            if(paux.isEmpty()){
                return categoryRepository.save(y);
            }else{
                return y;
            }
        }
    }
    
    public Category update(Category c){
        if(c.getId()!=null){
            Optional<Category>g=categoryRepository.getCategory(c.getId());
            if(!g.isEmpty()){
                if(c.getDescription()!=null){
                    g.get().setDescription(c.getDescription());
                }
                if(c.getName()!=null){
                    g.get().setName(c.getName());
                }
                return categoryRepository.save(g.get());
            }
        }
        return c;
    }
    public boolean deleteCategoria(int categoriaId){
        Boolean d=getCategory(categoriaId).map(categoria -> {
            categoryRepository.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }

}