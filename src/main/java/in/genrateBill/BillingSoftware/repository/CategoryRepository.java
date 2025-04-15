package in.genrateBill.BillingSoftware.repository;

import in.genrateBill.BillingSoftware.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long > {
}
