package com.cpe.wongnai_server.Repository;
import com.cpe.wongnai_server.entity.Period;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface PeriodRepository extends JpaRepository<Period,Long>{
    
}