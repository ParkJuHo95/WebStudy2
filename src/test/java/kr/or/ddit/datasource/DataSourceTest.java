package kr.or.ddit.datasource;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class DataSourceTest extends AbstractRootContextTest{
	
	@Inject
	private DataSource dataSource;
	
	@Inject
	private SqlSessionFactory sqlSessionFactory;

	@Test
	void testDataSource() {
		log.info("주입된 datasource : {}", dataSource);
		assertDoesNotThrow(()->{
			try(
				Connection conn =	dataSource.getConnection();	
			){
				log.info("생성한 Connection : {}", conn);
			}
		});
	}

	@Test
	void testMapper() {
		log.info("주입된 sqlSessionFactory : {}", sqlSessionFactory);
		sqlSessionFactory.getConfiguration().getMapperRegistry().getMappers().forEach((m)->{
			log.info("등록된 mapper : {}", m.getName());
		});
	}
}
