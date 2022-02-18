package mx.edu.utez.villalobos.subcategories.model;

import mx.edu.utez.villalobos.categories.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    Optional<Subcategory> findByDescription(String description);
    List<Subcategory> findSubcategoriesByCategory_Id(long id);
    boolean existsById(long id);
    boolean existsSubcategoryByCategory_Id(long id);
    List<Subcategory> findAllByCategory_Id(long id);
}
