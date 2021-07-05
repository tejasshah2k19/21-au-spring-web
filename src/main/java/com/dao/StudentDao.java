package com.dao;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.bean.StudentBean;

@Repository
public class StudentDao {

	public static ArrayList<StudentBean> students = new ArrayList<>();

	static {
		
		int stdId = (int) (Math.random() * 1000000);
	
		
		
		StudentBean s1 = new StudentBean();
		s1.setFirstName("ram");
		s1.setEmail("ram@gmail.com");
		s1.setPassword("ram");
		s1.setStudentId(stdId);
		s1.setCreatedAt(new Date());
		s1.setUpdatedAt(new Date());
		
		
		StudentBean s2 = new StudentBean();
		s2.setFirstName("laxman");
		s2.setEmail("laxman@gmail.com");
		s2.setPassword("laxman");
		s2.setStudentId(stdId+25);
		s2.setCreatedAt(new Date());
		s2.setUpdatedAt(new Date());
		
		
		StudentBean s3 = new StudentBean();
		s3.setFirstName("ravan");
		s3.setEmail("ravan@gmail.com");
		s3.setPassword("ravan");
		s3.setStudentId(stdId+75);
		s3.setCreatedAt(new Date());
		s3.setUpdatedAt(new Date());
		
		students.add(s1);
		students.add(s2);
		students.add(s3);
		
		
	}
}
