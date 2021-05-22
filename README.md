# config-datasoruces

how can config different JPA repositories linking to different databases? for instance, one repository linking to the Product database, another repo. linking to the User database.
When having one data source within the context, all the repositories are proxied by the Spring JPA and pointing to it. So when having two databases, we need to customize the
repository and its proxy generation, and thus pointing to the database as expected.

Set up Spring to create proxy instances for those interfaces, either with JavaConfig or with XML configuration.

To use Java configuration, create a class similar to the following:

````
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
class Config { … }
````

The JPA namespace is used in this example. If you use the repository abstraction for any other store, you need to change this to the appropriate namespace declaration of your store module. In other words, you should exchange jpa in favor of, for example, mongodb.

Also, note that the JavaConfig variant does not configure a package explicitly, because the package of the annotated class is used by default. To customize the package to scan, use one of the basePackage… attributes of the data-store-specific repository’s @Enable${store}Repositories-annotation.

The following example shows annotation-driven configuration of base packages:

````
@EnableJpaRepositories(basePackages = "com.acme.repositories.jpa")
@EnableMongoRepositories(basePackages = "com.acme.repositories.mongo")
class Configuration { … }
````



