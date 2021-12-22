package com.Unthinkable.Manager.Repository;
import com.Unthinkable.Manager.Entity.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends
        JpaRepository<Manager,Long> {
}
