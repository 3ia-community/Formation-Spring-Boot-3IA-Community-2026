package tia.community.oneToOne_demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tia.community.oneToOne_demo.entity.Command;

@Repository
public interface CommandDao extends JpaRepository<Command, String> {
}
