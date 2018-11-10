package com.company.phonenumber.resources;

import com.codahale.metrics.annotation.Timed;
import com.company.phonenumber.core.PhoneNumber;
import com.company.phonenumber.db.PhoneNumberDAO;
import io.dropwizard.hibernate.UnitOfWork;
import io.dropwizard.jersey.params.IntParam;
import io.dropwizard.jersey.params.LongParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Optional;

@Path("/phoneNumber")
@Produces(MediaType.APPLICATION_JSON)
public class PhoneNumberResource {

    private PhoneNumberDAO phoneNumberDAO;

    public PhoneNumberResource(PhoneNumberDAO phoneNumberDAO) {
        this.phoneNumberDAO = phoneNumberDAO;
    }

    @GET
    @Path("phoneNumber/{id}")
    @UnitOfWork
    public PhoneNumber findByIndex(@PathParam("id") IntParam id) {
        return phoneNumberDAO.findByIndex(id.get());
    }
}