package divorra;

import divorra.core.Film;
import divorra.db.FilmDAO;
import divorra.resources.FilmResource;
import io.dropwizard.Application;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class VideoRentalStoreApplication extends Application<VideoRentalStoreConfiguration> {

    public static void main(final String[] args) throws Exception {
        new VideoRentalStoreApplication().run(args);
    }
    
    private final HibernateBundle<VideoRentalStoreConfiguration> hibernateBundle =
            new HibernateBundle<VideoRentalStoreConfiguration>(Film.class) {
                @Override
                public DataSourceFactory getDataSourceFactory(VideoRentalStoreConfiguration configuration) {
                    return configuration.getDataSourceFactory();
                }
            };

    @Override
    public String getName() {
        return "VideoRentalStore";
    }

    @Override
    public void initialize(final Bootstrap<VideoRentalStoreConfiguration> bootstrap) {
    	 // Enable variable substitution with environment variables
        bootstrap.setConfigurationSourceProvider(
                new SubstitutingSourceProvider(
                        bootstrap.getConfigurationSourceProvider(),
                        new EnvironmentVariableSubstitutor(false)
                )
        );
        
        
        bootstrap.addBundle(new MigrationsBundle<VideoRentalStoreConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(VideoRentalStoreConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(final VideoRentalStoreConfiguration configuration,
                    final Environment environment) {
        final FilmDAO dao = new FilmDAO(hibernateBundle.getSessionFactory());
        environment.jersey().register(new FilmResource(dao));
    }

}
