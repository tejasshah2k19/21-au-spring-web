package com.controller;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.StudentBean;
import com.dao.StudentDao;



@RestController
public class StudentController {

	@GetMapping("/demo")
	public String demo() {
		return "demo";
	}

	@PostMapping("/demo")
	public String demoPost() {
		return "demoPost";
	}

	@PostMapping("/student")
	public StudentBean saveStudent(StudentBean studentBean) {

		int stdId = (int) (Math.random() * 1000000);
		studentBean.setStudentId(stdId);
		studentBean.setCreatedAt(new Date());
		studentBean.setUpdatedAt(new Date());
		StudentDao.students.add(studentBean);
		return studentBean;
	}

	@GetMapping("/students")
	public ArrayList<StudentBean> getAllStudents() {
		return StudentDao.students;
	}

	@DeleteMapping("/student/{studentId}")
	public ArrayList<StudentBean> deleteStudentById(@PathVariable("studentId") int studentId) {

		for (int i = 0; i < StudentDao.students.size(); i++) {
			if (StudentDao.students.get(i).getStudentId() == studentId) {
				StudentDao.students.remove(i);
				break;
			}
		}
		return StudentDao.students;
	}

	@GetMapping("/student/{studentId}")
	public StudentBean getStudentById(@PathVariable("studentId") int studentId) {
		for (int i = 0; i < StudentDao.students.size(); i++) {
			if (StudentDao.students.get(i).getStudentId() == studentId) {
				return StudentDao.students.get(i);
			}
		}
		return null;
	}

	// for update we need to use putmapping http put

	@PutMapping("/student")
	public StudentBean updateStudent(StudentBean studentBean) { // argument is student bean so user can pass any field
																// for update

		// now search for the user in array list and update the detail

		// we don't have database so we can not execute update query
		// we just remove the old student and adding new student with same id
		for (int i = 0; i < StudentDao.students.size(); i++) {
			if (StudentDao.students.get(i).getStudentId() == studentBean.getStudentId()) {
				// set created at
				studentBean.setCreatedAt(StudentDao.students.get(i).getCreatedAt());
				StudentDao.students.remove(i);

				break;
			}
		}
		studentBean.setUpdatedAt(new Date());
		StudentDao.students.add(studentBean);
		return studentBean;
	}
	
	
	//search student 
	//login  
	
}
//   M    E   A   N
//   M    E   R   N

//spring boot + Angular  + Pg 

//angular + node + Pg (express)

//angular + node + mongo  (express) 
