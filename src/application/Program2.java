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

		System.out.println("=== TEST 1: department findById ===");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n=== TEST 2: findAll =======");
		List<Department> list = departmentDao.findAll();
		for(Department depart : list) {
			System.out.println(depart);
		}
		
		System.out.println("\n=== TEST 3: insert =======");
		Department newDepartment = new Department(null, "Urbanism");
		departmentDao.insert(newDepartment);
		System.out.println("Inserted! New id: " + newDepartment.getId());
		
		System.out.println("\n=== TEST 4: update =======");
		dep = departmentDao.findById(3);
		dep.setName("Project");
		departmentDao.update(dep);
		System.out.println("Updated completed!");
		
		System.out.println("\n=== TEST 5: delete =======");
		System.out.print("Enter a id for delete test: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed!");
		
		sc.close();
	}

}
