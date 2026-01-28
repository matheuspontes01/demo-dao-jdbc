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
		
		System.out.println("=== TEST 1: department findById");
		Department newDepartment = departmentDao.findById(4);
		System.out.println(newDepartment);
		
		System.out.println("=== TEST 2: department findAll");
		List<Department> list = departmentDao.findAll();
		for (Department d : list) {
			System.out.println(d);
		}
		
		System.out.println("=== TEST 3: department insert");
		Department dep = new Department(null, "Keyboards");
		departmentDao.insert(dep);
		System.out.println("Inserted! New id = " + dep.getId());
		
		System.out.println("=== TEST 4: department update");
		Department department = departmentDao.findById(2);
		department.setName("Smartphones");
		departmentDao.update(department);
		System.out.println("Update completed!");
		
		System.out.println("=== TEST 5: department deleteById");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		
		sc.close();
	}
}
