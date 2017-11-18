package divorra;

import divorra.core.Film;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
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
        // TODO: application initialization
    }

    @Override
    public void run(final VideoRentalStoreConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
