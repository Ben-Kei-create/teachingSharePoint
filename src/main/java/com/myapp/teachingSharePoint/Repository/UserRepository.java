package com.myapp.teachingSharePoint.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myapp.teachingSharePoint.bean.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("SELECT u.userName FROM User u WHERE u.id = :userId")
	String findUserNameByUserId(@Param("userId") Long userId);
	
	User findUserNameByUserId(Integer userId);

    Optional<User> findById(Integer userId);  // UserをOptionalで取得

}
