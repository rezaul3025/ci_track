package com.ci.track.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public  class MongoConfig extends AbstractMongoConfiguration{

	/*
	 * Use the standard Mongo driver API to create a com.mongodb.MongoClient
	 * instance.
	 */
	@Bean
	public MongoClient mongoClient() {
		return new MongoClient("localhost");
	}
	
	
	@Bean
	public MongoDbFactory mongoDbFactory() {
	    return new SimpleMongoDbFactory(new MongoClient(), getDatabaseName());
	  }
	
	@Bean
	public GridFsTemplate gridFsTemplate() throws Exception {
	    return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter());
	}

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return "ci_track";
	}


	@Override
	public Mongo mongo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
