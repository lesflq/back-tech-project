package ua.sevastianov.backtechproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.sevastianov.backtechproject.domain.category.Category;
import ua.sevastianov.backtechproject.domain.category.CategoryType;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Отримати всі глобальні категорії
    List<Category> findByType(CategoryType type);

    // Отримати всі приватні категорії для конкретного користувача
    List<Category> findByTypeAndOwner_Id(CategoryType type, Long ownerId);

    // Отримати всі видимі категорії для користувача
    @Query("SELECT c FROM Category c WHERE c.type = 'GLOBAL' OR c.owner.id = :ownerId")
    List<Category> findVisibleCategoriesForUser(@Param("ownerId") Long ownerId);
}

