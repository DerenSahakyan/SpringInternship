package com.intership.springdemo.persistance;

import com.intership.springdemo.persistance.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findUserEntityByFirstName(String str);

    @Query(value = "select * from custom_user where first_name = :name", nativeQuery = true)
    List<UserEntity> getByFirstName(@Param("name") String firstName);
}
