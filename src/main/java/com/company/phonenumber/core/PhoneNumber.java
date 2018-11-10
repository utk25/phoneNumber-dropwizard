package com.company.phonenumber.core;

import com.company.phonenumber.constants.PhoneNumberConstants;

import javax.persistence.*;

@Entity
@Table(name = "phone_number_table")
@NamedQueries({
        @NamedQuery(name = "com.company.phonenumber.PhoneNumber.findByIndex",
                query = "select pn from PhoneNumber pn " +
                        "where pn.id like :id")
})
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_number_id")
    private Integer id;

    @Column(name = "number")
    private Long number = PhoneNumberConstants.STARTING_NUMBER;

    public PhoneNumber(){}
}
