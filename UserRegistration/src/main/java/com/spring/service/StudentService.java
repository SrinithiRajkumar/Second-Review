package com.spring.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.spring.model.Students;
import com.spring.repository.StudentsRepo;

import jakarta.transaction.Transactional;

@Service
public class StudentService {

	@Autowired
	private StudentsRepo studentsRepo;

	public List<Students> getAllStudent() {
		// TODO Auto-generated method stub
		return (List<Students>) studentsRepo.findAll();
	}

	public Students addStudent(Students students) {
		// TODO Auto-generated method stub
		return studentsRepo.save(students);
	}

	public Students updateStudent(String rollno, Students students) {
		// TODO Auto-generated method stub
		students.setRoll_no(rollno);
		return studentsRepo.save(students);
	}

	public String deleteStudent(String rollno) {
		// TODO Auto-generated method stub
		Optional<Students> stu = studentsRepo.findById(rollno);
		if(!stu.isEmpty()) {
			studentsRepo.deleteById(rollno);
			return "Student Record Deleted Successfull";
		}
		return "Student Record Not Found";
	}

	public List<Students> pagination(int offset, int pageSize) {
		// TODO Auto-generated method stub
		Pageable records = PageRequest.of(offset, pageSize);
		Page<Students> students = studentsRepo.findAll(records);
		return students.getContent();
	}

	public List<Students> sortBy(String field) {
		// TODO Auto-generated method stub
		return studentsRepo.findAll(Sort.by(Sort.Direction.DESC, field));
	}

	public List<Students> fetchStudentByNamePrefix(String prefix) {
		// TODO Auto-generated method stub
		return studentsRepo.findByNameStartingWith(prefix);
	}

	public List<Students> fetchStudentByNameSuffix(String suffix) {
		// TODO Auto-generated method stub
		return studentsRepo.findByNameEndingWith(suffix);
	}
	public List<Students>sortStudent(String field){
 		return studentsRepo.findAll(Sort.by(field));
 	}
 	
 	public List<Students> sortDesTennisData(String field){
 		
 		return studentsRepo.findAll(Sort.by(Direction.DESC,field));
 	}

 	public List<Students> getpaginationss(int offset, int pagesize) {
 		
 		Page<Students> paging=studentsRepo.findAll(PageRequest.of(offset, pagesize));
 		return paging.getContent();
 	}

 	public List<Students> getsortpaginations(int offset, int pagesize,String field) {
 		
 		Page<Students> paging=studentsRepo.findAll(PageRequest.of(offset, pagesize,Sort.by(field)));
 		return paging.getContent();
 	}
 	
public Students register(@RequestBody Students  roll_no) {
		
		return studentsRepo.save(roll_no);
	}
public List<Students>getStudentByName(String name) {
	List<Students> dataList=studentsRepo.getStudentByName(name);
	return dataList;
}
@Transactional
public int deleteStudentByName(String name) {
	return studentsRepo.deleteStudentByName(name);
}

@Transactional
public int UpdateStudentByName(String name,String roll_no) {
	return studentsRepo.UpdateStudentByName(name,roll_no);
}

public List<Students> sortDesStudent(String field) {
	// TODO Auto-generated method stub
	return null;
}
	
	
	
}