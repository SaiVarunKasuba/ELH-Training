package com.main;

import com.model.College;
import com.model.Department;
import com.model.Student;
import com.model.University;
import com.service.DepartmentService;
import com.service.DepartmentServiceImpl;

public class EducationMain {
	public static void main(String[] args) {
		Student student1 = new Student(11, "SaiVarun", 21);
		Student student2 = new Student(12, "Varun", 22);
		Student student3 = new Student(13, "John", 23);
		Student student4 = new Student(14, "Kevin", 24);
		Student student5 = new Student(15, "Mike", 25);

		Department department = new Department();
		department.setDeptId(100);
		department.setDeptName("ECE");
		Department dep = new Department();
		dep.setDeptId(101);
		dep.setDeptName("CSE");

		College college1 = new College();
		college1.setCollegeId("1001");
		college1.setCollegeName("CVR");

		College college2 = new College();
		college2.setCollegeId("1002");
		college2.setCollegeName("CBIT");
		College[] college = new College[2];
		college[0] = college1;
		college[1] = college2;
		Department[] departments = new Department[2];
		departments[0] = department;
		departments[1] = dep;
		college1.setDepartments(departments);
		student1.setDepartment(department);
		student2.setDepartment(dep);
		Student[] students = new Student[3];
		students[0] = student1;
		students[1] = student2;
		students[2] = student3;
		department.setStudent(students);
		Student[] batch2 = new Student[2];
		batch2[0] = student4;
		batch2[1] = student5;
		dep.setStudent(batch2);
		University university = new University();
		university.setUniversityCode(1234);
		university.setUniversityName("JNTU");
		university.setColleges(college);

		DepartmentService departmentService = new DepartmentServiceImpl();

		Student student = departmentService.searchStudentById(department, 11);
		// Student[] student = departmentService.searchStudentById(departments, 456);

		Department departmentObj = departmentService.searhDepartmentsByDepartmentId(college1, "1002");
		College collegeresult = departmentService.searchCollegeName(university, "CBIT");

		if (departmentObj != null) {
			System.out.println("College Name " + college1.getCollegeName());
			System.out.println("College id " + college1.getCollegeId());

			for (int i = 0; i < college1.getDepartments().length; i++) {

				System.out.println("Department Id" + departments[i].getDeptId());
				System.out.println("Department Name" + departments[i].getDeptName());

			}
			System.out.println();
		}

		Student batch = departmentService.searchStudentById(dep, 14);
		if (batch != null) {
			System.out.println("student id " + batch.getStuId());
			System.out.println("student name " + batch.getStuName());
			System.out.println("student age " + batch.getStuAge());
			System.out.println("student departmentid " + dep.getDeptId());
			System.out.println("student department Name " + dep.getDeptName());
			System.out.println("student collegeName " + college1.getCollegeName());
			if (collegeresult != null) {
				System.out.println("student UniversityName " + university.getUniversityName());
			}
		}
		if (student != null) {
			System.out.println("student id " + student.getStuId());
			System.out.println("student name " + student.getStuName());
			System.out.println("student age " + student.getStuAge());
			System.out.println("student departmentid " + department.getDeptId());
			System.out.println("student department Name " + department.getDeptName());
		}
	
		Student studentObj = departmentService.searchStudentByName(department, "John");
		if (studentObj != null) {
			System.out.println("student id " + studentObj.getStuId());
			System.out.println("student name " + studentObj.getStuName());
			System.out.println("student age " + studentObj.getStuAge());
			System.out.println("student departmentid " + department.getDeptId());
			System.out.println("student department Name " + department.getDeptName());
		}

	}

}
