package gov.oupp.jwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import gov.oupp.jwt.entity.UserInfo;


public interface UserInfoRepository extends JpaRepository<UserInfo, Integer>{
	
	Optional<UserInfo> findByName(String name);

}
