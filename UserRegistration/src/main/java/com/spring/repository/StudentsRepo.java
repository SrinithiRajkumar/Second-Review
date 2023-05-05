package com.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.model.Students;

@Repository
public interface StudentsRepo extends JpaRepository<Students, String> {

	List<Students> findByNameStartingWith(String prefix);

	List<Students> findByNameEndingWith(String suffix);
	
	//named parameter
		@Query("select s from Students s where s.roll_no=:roll_no")
		public List<Students>getStudentByName(String roll_no);
	    
		@Modifying
		@Query("delete from Students s  where s.roll_no=?1")
		public int deleteStudentByName(String roll_no);
		
		@Modifying
		@Query("update Students s set s.roll_no=?1 where s.name=?2")
		public int UpdateStudentByName(String roll_no,String name);
		
		/*List<Students> findByBrandStartingWith(String prefix);
		List<Students> findByBrandEndingWith(String suffix);
		List<Students> findByBrand(String roll_no);*/
		
		@Query(value="select * from Students s where s.roll_no=?",nativeQuery=true)
		public List<Students> fetchStudentByName(String roll_no);
}