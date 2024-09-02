package com.nathaliamello.gitflowdemo.user.repository;

import com.nathaliamello.gitflowdemo.user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
}
