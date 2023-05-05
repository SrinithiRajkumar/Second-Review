package com.spring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.model.Students;
import com.spring.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	public String index() {
		return "Welcome to My Hostel";
	}
	
	@GetMapping("/students")
	public List<Students> getAllStudent(){
		return studentService.getAllStudent();
	}
	
	@PostMapping("/addstudent")
	public Students addStudent(@RequestBody Students students) {
		return studentService.addStudent(students);
	}
	
	@PutMapping("/updatestudent/{rollno}")
	public Students updateStudent(@PathVariable String rollno,@RequestBody Students students) {
		return studentService.updateStudent(rollno,students);
	}
	
	@DeleteMapping("/deletestudent/{rollno}")
	public String deleteStudent(@PathVariable String rollno) {
		return studentService.deleteStudent(rollno);
	}
	
	@GetMapping("/pagination/{offset}/{pageSize}")
	public List<Students> paginationMethed(@PathVariable int offset,@PathVariable int pageSize){
		return studentService.pagination(offset,pageSize);
	}
	
	@GetMapping("/sort/{feild}")
	public List<Students> sortBy(@PathVariable String feild){
		return studentService.sortBy(feild);
	}
	
	@GetMapping("/fetchPrefix/{prefix}")
	public List<Students> fetchStudentByNamePrefix(@PathVariable String prefix)
	{
		return studentService.fetchStudentByNamePrefix(prefix);
	}
	@GetMapping("/fetchSuffix/{suffix}")
	public List<Students> fetchStudentByNameSuffix(@PathVariable String suffix)
	{
		return studentService.fetchStudentByNameSuffix(suffix);
	}
	@GetMapping("/auto/{field}")
	public List<Students>sortCrudD(@PathVariable String field){
		return studentService.sortStudent(field);
	}
	@GetMapping("/autio")
	public List<Students>sortCrudDes(@RequestParam String field){
		return studentService.sortDesStudent(field);
	}
	
	
	@GetMapping("/pagination")
	
	public List<Students> pagination(@RequestParam int offset,@RequestParam int pagesize){
		
		return studentService.getpaginationss(offset,pagesize);
	}
	
	@GetMapping("/sortpagination")
	
	public List<Students> sortpagination(@RequestParam int offset,@RequestParam int pagesize,String field){
		
		return studentService.getsortpaginations(offset,pagesize,field);
	}
	
	
	@PostMapping("/reg")
	public Students regroll_no(@RequestBody Students roll_no) {
		
		
		return studentService.register(roll_no);
		
	}
	@GetMapping("/getFieldByData/{field}")
	 public List<Students>getFieldByData(@PathVariable String firstname) {
		 List<Students> dataList=studentService.getStudentByName(firstname);
		 return dataList;
	 }
	 
	 @DeleteMapping("/deleteStudentByName/{name}")
	 public String deleteStudentByName(@PathVariable String name) {
		 int result=studentService.deleteStudentByName(name);
		 if(result>0)
			 return "Data record deleted";
		 else
			 return "Problem occured while deleting";
	 }
	 @PutMapping("/updateStudentByName/{name}/{roll_no}")
	 public String updateStudentByName(@PathVariable String name,@PathVariable String roll_no) {
		 int result=studentService.UpdateStudentByName(name,roll_no);
		 if(result>0)
			 return "Data record updated";
		 else
			 return "Problem occured while updating";
	 }
	
	
}