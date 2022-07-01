package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		System.out.println("===== TEST 01: department findById =====");
		Department department = departmentDao.findById(2);
		System.out.println(department);

		System.out.println("\n===== TEST 02: department findAll =====");
		List<Department> list = departmentDao.findAll();
		list.forEach(System.out::println);

		System.out.println("\n===== TEST 03: department insert =====");
		Department newDepartment = new Department(null, "Foods");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id = " + newDepartment.getId());

		System.out.println("\n===== TEST 04: department update =====");
		department = departmentDao.findById(6);
		department.setName("Woodwork");
		departmentDao.update(department);
		System.out.println("Update complete");

		System.out.println("\n===== TEST 05: department deleteById =====");
		System.out.print("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");

		sc.close();
	}

}
