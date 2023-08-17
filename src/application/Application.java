package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Employee;

public class Application {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> list = new ArrayList<>();

		System.out.print("How many Employees will be registered: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			Employee em = new Employee();
			System.out.print("\nEmployee #" + (i + 1) + "\n");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			while(em.position(list,id)!=null) {
				System.out.println("Id already taken! Try again: ");
				id = sc.nextInt();
			}
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();

			Employee emp = new Employee(id, name, salary);
			list.add(emp);
		}
		
		Employee em = new Employee();

		System.out.print("\nEnter the employee id that will have salary increase : ");
		int idsalary = sc.nextInt();
		
		Integer pos = em.position(list,idsalary);

		if (pos == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.print("Enter the percentage: ");
			double percent = sc.nextDouble();
			list.get(pos).increaseSalary(percent);
		}

		System.out.println("\nList of employees");

		for (Employee e : list) {
			System.out.println(e);
		}

		sc.close();
	}
}
