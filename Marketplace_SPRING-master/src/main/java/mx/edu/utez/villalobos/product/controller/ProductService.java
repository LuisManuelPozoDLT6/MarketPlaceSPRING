package mx.edu.utez.villalobos.product.controller;

import mx.edu.utez.villalobos.product.model.Product;
import mx.edu.utez.villalobos.product.model.ProductImage;
import mx.edu.utez.villalobos.product.model.ProductRepository;
import mx.edu.utez.villalobos.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service//logica de negocio
@Transactional
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findAll(){
        return new ResponseEntity<>(new Message("ok", false, productRepository.findAll()),
                HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<Message> findById(long id){
        if (productRepository.existsById(id))
            return new ResponseEntity<>(new Message("ok", false, productRepository.findById(id)),
                    HttpStatus.OK);
        return new ResponseEntity<>(new Message("El producto no existe", true, null),
                HttpStatus.BAD_REQUEST);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> save(Product product){
        Optional<Product> exists = productRepository.findByName(product.getName());
        if (exists.isPresent())
            return  new ResponseEntity<>(new Message("Este producto ya existe", true, null),
                    HttpStatus.BAD_REQUEST);
        List<ProductImage> images = product.getImages();
        Product idProduct = productRepository.saveAndFlush(product);
        images.forEach(image -> image.setProduct(idProduct));

        idProduct.setImages(images);
        Product savedProduct = productRepository.saveAndFlush(idProduct);
        return new ResponseEntity<>(new Message("ok", false, productRepository.saveAndFlush(savedProduct)),
        HttpStatus.OK);
    }

    @Transactional(rollbackFor = {SQLException.class})
    public ResponseEntity<Message> update(Product product){
        if (productRepository.existsById(product.getId()))
            return new ResponseEntity<>(new Message("ok", false, productRepository.saveAndFlush(product)),
                    HttpStatus.OK);
        return new ResponseEntity<>(new Message("El producto no existe", true, null),
                HttpStatus.BAD_REQUEST);
    }
}
