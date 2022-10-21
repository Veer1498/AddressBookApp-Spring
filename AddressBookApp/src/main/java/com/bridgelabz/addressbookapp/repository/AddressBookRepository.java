package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.ContactData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Puprose : To Create AddressBook App and Perform Operations like CRUD using Data Base.
 * Author : Veer.Singa
 */
@Repository
public interface AddressBookRepository extends JpaRepository<ContactData,Integer> {
    @Query(value = "select * from contact_data order by city ",nativeQuery = true)
    List<ContactData> sortByCity();
    @Query(value = "select * from contact_data order by state",nativeQuery = true)
    List<ContactData> sortByState();
}
