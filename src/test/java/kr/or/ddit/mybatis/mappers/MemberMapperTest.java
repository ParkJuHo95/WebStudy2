package kr.or.ddit.mybatis.mappers;

import static org.junit.jupiter.api.Assertions.*;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import kr.or.ddit.AbstractRootContextTest;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class MemberMapperTest extends AbstractRootContextTest{

	@Inject
	MemberMapper mapper;
	
	@Test
	void testSelectMemberByUsername() {
		log.info("username 으로 조회한 사용자 : {}", mapper.selectMemberByUsername("c001"));
	}

}
