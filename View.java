package com.jsp.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jsp.controller.Controller;
import com.jsp.model.Department;
import com.jsp.model.Employee;
import com.jsp.model.Project;

public class View {
	static Scanner sc = new Scanner(System.in);
	static Controller c= new Controller();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("*****Welcome******");
		do {
			System.out.println("Enter a Number to perform Respective Operation");
			System.out.println(
					"0.Exit \n1. Add Employee \n2.View Employee information \n3.Update Employee details \n4.REmove Employee \n5.View Department details \n6.Add DEpartment \n7.Add project \n8.View project \n9.Update emp department");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 0:
				System.exit(0);
                break;
			case 1:
				
				Employee e = new Employee();
				System.out.println("Enter employee name");
				String name=sc.nextLine();
				e.setName(name);
				System.out.println("Enter employee position");
				String position=sc.nextLine();
				e.setPosition(position);
				System.out.println("Enter employee salary");
				double salary=sc.nextDouble();
				e.setSalary(salary);
				sc.nextLine();
				ArrayList<Project> project_list = new ArrayList<Project>();
				e.setProject(project_list);
				boolean addEmployee = c.addEmployee(e);
				
				if(addEmployee) {
					System.out.println("Employee details inserted");
				}
				else {
					System.out.println("Employee not inserted");
				}

				break;
			case 2:
				
				System.out.println("Enter emp id");
				int id=sc.nextInt();
				sc.nextLine();
			    Employee findemp = c.findEmployee(id);
				System.out.println(findemp.getEid());
				System.out.println(findemp.getName());
				System.out.println(findemp.getPosition());
				System.out.println(findemp.getSalary());

				break;
			case 3:
				System.out.println("Enter the emp id to update");
				int updateemp=sc.nextInt();
				sc.nextLine();
				System.out.println("Enter new salary");
				double updated_salary=sc.nextDouble();
				sc.nextLine();
				System.out.println("Enter the position to update");
				String updated_position=sc.nextLine();
//				boolean updateemployee= c.updateemployee();

				break;
			case 4:
				System.out.println("Enter the emp id to remove");
				int removeemp=sc.nextInt();
				sc.nextLine();
				
				boolean removeparticularEmployee = c.removeparticularEmployee(removeemp);
				if (removeparticularEmployee) {
					System.out.println("Bank removed sucessfully");
				} else {
					System.out.println("Bank not removed succesfully");

				}

				

				break;
			case 5:
			
				

				break;
			case 6:
				Department d = new Department();
				System.out.println("Enter deparment name");
				String d_name=sc.nextLine();
				d.setName(d_name);
				boolean addDepartment = c.addDepartment(d);
				if(addDepartment) {
					System.out.println("Employee details inserted");
				}
				else {
					System.out.println("Employee not inserted");
				}
				
				

				break;
			case 7:
				Project p = new Project();
				System.out.println("Enter project name");
				String p_name=sc.nextLine();
				p.setName(p_name);
				System.out.println("Enter project desc");
				String p_desc=sc.nextLine();
				p.setDescription(p_desc);
				boolean addProject = c.addProject(p);
				if(addProject) {
					System.out.println("Employee details inserted");
				}
				else {
					System.out.println("Employee not inserted");
				}
				break;
			case 8:
				break;
				
			case 9:
				System.out.println("Enter employee id to update ");
				int e_id1=sc.nextInt();
				sc.nextLine();
				
				List<Department> fetchAllDepartment = c.fetchAllDepartment();
				for (Department department : fetchAllDepartment) {
					System.out.println(department.getD_id());
					System.out.println(department.getName());
				}
				System.out.println("enter id of dept to assign to employee");
				int emp_dept_id=sc.nextInt();
				sc.nextLine();
				Department findDepartment = c.findDepartment(emp_dept_id);
				boolean updateEmployeeDept = c.updateEmployeeDept(findDepartment, e_id1);
				if(updateEmployeeDept) {
					System.out.println("dept assigned to employee");
				}
				else {
					System.out.println("dept not assigned");
				}
				break;
				
			default:
				System.out.println("invalid option");
				break;
			}
		} while (true);
	}

}
