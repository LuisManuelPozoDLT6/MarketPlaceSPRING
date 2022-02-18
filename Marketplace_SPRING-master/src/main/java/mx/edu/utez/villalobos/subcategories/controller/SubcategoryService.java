package mx.edu.utez.villalobos.subcategories.controller;

import mx.edu.utez.villalobos.categories.model.Category;
import mx.edu.utez.villalobos.subcategories.model.Subcategory;
import mx.edu.utez.villalobos.subcategories.model.SubcategoryRepository;
import mx.edu.utez.villalobos.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.Optional;

@Service
@Transactional
public class SubcategoryService {
    @Autowired
    SubcategoryRepository subcategoryRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("ok", false, subcategoryRepository.findAll() ), HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(Long id){
        if (subcategoryRepository.existsById(id)){
            return new ResponseEntity<>(new Message("ok", false, subcategoryRepository.findById(id) ), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("la subcategoría no existe", true, null ), HttpStatus.BAD_REQUEST);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findByCategory(long id){
        if (subcategoryRepository.existsSubcategoryByCategory_Id(id)){
            return new ResponseEntity<>(new Message("ok", false, subcategoryRepository.findAllByCategory_Id(id)), HttpStatus.OK);
        }
        return new ResponseEntity<>(new Message("la categoría no existe", true, null ), HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> insert(Subcategory subcategory){
        Optional<Subcategory> existSubcategory = subcategoryRepository.findByDescription(subcategory.getDescription());

        if (existSubcategory.isPresent()) {
            return new ResponseEntity<>(new Message("la subcategoría ya existe", true, null ), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Message("subcategoría registrada correctamente", false, subcategoryRepository.saveAndFlush(subcategory) ), HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(Subcategory subcategory){
        if (subcategoryRepository.existsById(subcategory.getId())) {
            return new ResponseEntity<>(new Message("la subcategoría ya existe", true, null ), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new Message("subcategoría actualizada correctamente", false, subcategoryRepository.saveAndFlush(subcategory) ), HttpStatus.OK);
    }


}
