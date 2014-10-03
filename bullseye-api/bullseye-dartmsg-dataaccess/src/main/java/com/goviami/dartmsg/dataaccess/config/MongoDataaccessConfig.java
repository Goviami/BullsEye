package com.goviami.dartmsg.dataaccess.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.WriteConcern;

@Import(DataaccessSpringConfig.class)
@Configuration
@EnableMongoRepositories(basePackages = { "com.goviami.dartmsg.dataaccess.repository" })
public class MongoDataaccessConfig extends AbstractMongoConfiguration {
	/**
	 * Load database details from properties file.
	 */
	@Value("${bullseye.dartmsg.mongodb.host}")
	private String dbHost;
	@Value("${bullseye.dartmsg.mongodb.port}")
	private int dbPort;
	@Value("${bullseye.dartmsg.mongodb.database}")
	private String dbName;
	@Value("${bullseye.dartmsg.mongodb.user.avatar.bucket}")
	private String avatarBucket;

	/**
	 * Get Mongo Database Name.
	 * 
	 * @return Database Name.
	 */
	@Override
	protected String getDatabaseName() {
		return dbName;
	}

	/**
	 * Mogo Client Instance.
	 * 
	 * @return {@link Mongo}
	 * @throws Exception {@link Exception}
	 */
	@Override
	@Bean
	public Mongo mongo() throws Exception {
		MongoClient mongoClient = new MongoClient(dbHost, dbPort);
		mongoClient.setWriteConcern(WriteConcern.SAFE);
		return mongoClient;
	}

	/**
	 * GridFsTemplate Bean.
	 * 
	 * @return {@link GridFsTemplate}
	 * @throws Exception {@link Exception}
	 */
	@Bean(name = "avatarGridFsTemplate")
	public GridFsTemplate gridFsTemplate() throws Exception {
		return new GridFsTemplate(mongoDbFactory(), mappingMongoConverter(), avatarBucket);
	}

	/**
	 * MongoTemplate Bean.
	 * 
	 * @return {@link MongoTemplate}
	 * @throws Exception {@link Exception}
	 */
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongo(), dbName);
	}

}
