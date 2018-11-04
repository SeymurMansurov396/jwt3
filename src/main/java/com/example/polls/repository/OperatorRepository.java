package com.example.polls.repository;

import com.example.polls.model.Operator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */
@Repository
public interface OperatorRepository extends JpaRepository<Operator, Long> {
   
	public Operator findByUsername(String username);
}
