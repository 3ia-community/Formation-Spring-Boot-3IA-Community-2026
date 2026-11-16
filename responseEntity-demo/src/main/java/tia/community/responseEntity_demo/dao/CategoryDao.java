package tia.community.responseEntity_demo.dao;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tia.community.responseEntity_demo.entity.Category;

import java.util.List;

@Repository
public interface CategoryDao extends JpaRepository<Category, String> {
    Category findByRef(String refCategory);
}


