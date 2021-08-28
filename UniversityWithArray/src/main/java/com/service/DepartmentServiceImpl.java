package com.service;

import com.model.College;
import com.model.Department;
import com.model.Student;
import com.model.University;

public class DepartmentServiceImpl implements DepartmentService {

	public Student searchStudentById(Department department, int id) {
		Student studentObj = null;
		Student[] studentArray = department.getStudent();
		for (int i = 0; i < studentArray.length; i++) {
			if (studentArray[i].getStuId() == id) {
				studentObj = studentArray[i];
			} else {

			}
		}
		return studentObj;
	}

	public Student searchStudentById1(Department dep, int id) {
		Student batch2 = null;
		Student[] batchArray = dep.getStudent();
		for (int i = 0; i < batchArray.length; i++) {
			if (batchArray[i].getStuId() == id) {

				batch2 = batchArray[i];

			}
		}
		return batch2;

	}

	public Student searchStudentByName(Department department, String name) {
		Student studentObj = null;
		Student[] studentArray = department.getStudent();
		for (int i = 0; i < studentArray.length; i++) {
			if (studentArray[i].getStuName() == name) {
				studentObj = studentArray[i];
			} else {

			}
		}
		return studentObj;
	}



	public Department searhDepartmentsByDepartmentId(College college1, String string) {
		Department dep = null;
		Department[] depArray = college1.getDepartments();
		for (int i = 0; i < depArray.length; i++) {
			dep = depArray[i];
		}

		return dep;
	}
	 public College searchCollegeName(University university, String string) {
	        College college=null;
	        College[] colleges=university.getColleges();
	        for (int i = 0; i < colleges.length; i++) {
	            college=colleges[i];
	        }
	        return college;
	    }
	
}
