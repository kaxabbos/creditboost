package com.creditboost.repo;

import com.creditboost.model.Apps;
import com.creditboost.model.enums.AppsStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppsRepo extends JpaRepository<Apps, Long> {

    List<Apps> findAllByStatus(AppsStatus appsStatus);
}
