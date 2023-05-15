package com.creditboost.repo;

import com.creditboost.model.UserDescriptions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDescriptionsRepo extends JpaRepository<UserDescriptions, Long> {

}
