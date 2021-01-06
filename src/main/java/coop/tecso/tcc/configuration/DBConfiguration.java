package coop.tecso.tcc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

 
 


@Configuration
@ConfigurationProperties( "spring.datasource" )
@SuppressWarnings( "unused" )
public class DBConfiguration 
{
 	private String url;
	private String username;
	private String password;
	private String driverClassName;

    Logger logger = LoggerFactory.getLogger( DBConfiguration.class );

	
	@Profile( "dev" )
	@Bean
	public void devDatabaseConnection()
	{
		String connection = "DB connection for DEV - MySQL-Workbench";
		logger.info( connection );
 	}
	
	@Profile( "prod" )
	@Bean
	public void prodDatabaseConnection()
	{
		String connection = "DB connection for PROD - Heroku-CleanDB-MySQL" ;
		logger.info( connection );
 	}
}
