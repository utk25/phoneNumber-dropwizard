package com.company.phonenumber.db;



import com.company.phonenumber.core.PhoneNumber;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;

public class PhoneNumberDAO extends AbstractDAO<PhoneNumber> {

    public PhoneNumberDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public PhoneNumber findByIndex(Integer index) {

        return (PhoneNumber) namedQuery("com.company.phonenumber.PhoneNumber.findByIndex")
                .setParameter("id", index);
    }

}
