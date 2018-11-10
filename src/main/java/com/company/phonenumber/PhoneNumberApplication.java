package com.company.phonenumber;

import com.company.phonenumber.core.PhoneNumber;
import com.company.phonenumber.db.PhoneNumberDAO;
import com.company.phonenumber.resources.PhoneNumberResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class PhoneNumberApplication extends Application<PhoneNumberConfiguration> {
    public static void main(String[] args) throws Exception {
        new PhoneNumberApplication().run(args);
    }

    private final HibernateBundle<PhoneNumberConfiguration> hibernateBundle
            = new HibernateBundle<PhoneNumberConfiguration>(PhoneNumber.class ) {

        @Override
        public DataSourceFactory getDataSourceFactory(PhoneNumberConfiguration configuration) {

            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public void initialize(final Bootstrap<PhoneNumberConfiguration> bootstrap) {

        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(PhoneNumberConfiguration configuration, Environment environment) {

        final PhoneNumberDAO phoneNumberDAO = new PhoneNumberDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new PhoneNumberResource(phoneNumberDAO));
    }
}
