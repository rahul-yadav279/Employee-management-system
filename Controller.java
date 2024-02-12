package com.jsp.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.jsp.model.Department;
import com.jsp.model.Employee;
import com.jsp.model.Project;



public class Controller {
	static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pgadmin");
	static EntityManager entityManager = entityManagerFactory.createEntityManager();
	static EntityTransaction entityTransaction = entityManager.getTransaction();
	
	public boolean addEmployee(Employee e) {
		if (e!=null) {
			entityTransaction.begin();
			entityManager.persist(e);
			entityTransaction.commit();
			return true;
		} return false;
		
	}
	public boolean addDepartment(Department d) {
		if (d!=null) {
			entityTransaction.begin();
			entityManager.persist(d);
			entityTransaction.commit();
			return true;
		} return false;
		
	}
	public boolean addProject(Project p) {
		if (p!=null) {
			entityTransaction.begin();
			entityManager.persist(p);
			entityTransaction.commit();
			return true;
		} return false;
		
	}
	public Employee findEmployee(int f_id) {
		Employee find_eid = entityManager.find(Employee.class,f_id);
		return find_eid;
	}
	public List<Department> fetchAllDepartment() {
		String jpql="SELECT d from Department d";
		TypedQuery<Department> query = entityManager.createQuery(jpql, Department.class);
		List<Department> resultList = query.getResultList();
		return resultList;
	}
	public List<Employee> fetchAllEmployee() {
		String jpql="SELECT e from Employee e";
		TypedQuery<Employee> query = entityManager.createQuery(jpql, Employee.class);
		List<Employee> resultList = query.getResultList();
		return resultList;
	}
	public List<Project> fetchAllProject() {
		String jpql="SELECT p from Project p";
		TypedQuery<Project> query = entityManager.createQuery(jpql, Project.class);
		List<Project> resultList = query.getResultList();
		return resultList;
	}
	public Department findDepartment(int dept_id) {
		Department department = entityManager.find(Department.class,dept_id );
		return department;
		
	}
	public boolean updateEmployeeDept(Department findDepartment,int emp_id) {
		Employee find_emp = entityManager.find(Employee.class,emp_id );
		if(find_emp!=null&&findDepartment!=null) {
			List<Employee> employee = findDepartment.getEmployee();
			employee.add(find_emp);
			findDepartment.setEmployee(employee);
			entityTransaction.begin();
			entityManager.merge(findDepartment);
			entityTransaction.commit();
			
			
			
			find_emp.setDepartment(findDepartment);
			entityTransaction.begin();
			entityManager.merge(find_emp);
			entityTransaction.commit();
			return true;
			
		}return false;
	}
	public void updateEmployee() {
		
	} 
	public boolean removeparticularEmployee(int rid) {
		Employee find_rid = entityManager.find(Employee.class, rid);
		if(find_rid!=null) {
			entityTransaction.begin();
			entityManager.remove(find_rid);
			
			entityTransaction.commit();
			return true;
			}
		return false;
			
		}
	
   public boolean removeparticularDepartment(int did) {
	   Department find_did = entityManager.find(Department.class, did);
	   if(find_did!=null) {
			entityTransaction.begin();
			entityManager.remove(find_did);
			
			entityTransaction.commit();
			return true;
			}
	return false;
	}
   public boolean removeparticularProject(int fid) {
	   Project find_fid = entityManager.find(Project.class, fid);
	   if(find_fid!=null) {
			entityTransaction.begin();
			entityManager.remove(find_fid);
			
			entityTransaction.commit();
			return true;
			}
	return false;
		
	}

	

}
