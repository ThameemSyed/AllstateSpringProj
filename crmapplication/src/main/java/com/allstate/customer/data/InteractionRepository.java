package com.allstate.customer.data;

import com.allstate.customer.domain.Interaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InteractionRepository extends JpaRepository<Interaction, Integer> {

    public List<Interaction> findAllByCustD_CustomerId(Integer id);

    public void deleteAllByCustD_CustomerId(Integer id);
}
