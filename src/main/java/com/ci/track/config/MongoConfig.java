package com.ci.track.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoClientFactoryBean;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.MongoClient;

@Configuration
public class MongoConfig {

	/*
	 * Use the standard Mongo driver API to create a com.mongodb.MongoClient
	 * instance.
	 */
	@Bean
	public MongoClient mongoClient() {
		return new MongoClient("localhost");
	}
	
	/*
     * Factory bean that creates the com.mongodb.MongoClient instance
     */
	@Bean
    public MongoClientFactoryBean mongo() {
          MongoClientFactoryBean mongo = new MongoClientFactoryBean();
          mongo.setHost("localhost");
          return mongo;
     }
	
	@Bean
	public MongoDbFactory mongoDbFactory() {
	    return new SimpleMongoDbFactory(new MongoClient(), "ci_track");
	  }

}
