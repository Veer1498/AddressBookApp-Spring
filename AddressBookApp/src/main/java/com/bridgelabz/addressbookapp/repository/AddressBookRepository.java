package com.bridgelabz.addressbookapp.repository;

import com.bridgelabz.addressbookapp.model.ContactData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Puprose : To Create AddressBook App and Perform Operations like CRUD using Data Base.
 * Author : Veer.Singa
 */
@Repository
public interface AddressBookRepository extends JpaRepository<ContactData,Integer> {

}
