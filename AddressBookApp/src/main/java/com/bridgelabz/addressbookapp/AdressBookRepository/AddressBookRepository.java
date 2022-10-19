package com.bridgelabz.addressbookapp.AdressBookRepository;

import com.bridgelabz.addressbookapp.model.ContactData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends JpaRepository<ContactData,Integer> {

}
