package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserData,Integer> {
    /**
     *
     * @param userName
     * @param password
     * @return
     */
    @Query(value = "select * from user_data where user_name = :userName and password = :password",nativeQuery = true)
    UserData checkLogin(String userName, String password);
}
