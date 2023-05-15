package com.creditboost.repo;

import com.creditboost.model.Credits;
import com.creditboost.model.enums.Goals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditsRepo extends JpaRepository<Credits, Long> {
    List<Credits> findAllByGoal(Goals goal);
}
