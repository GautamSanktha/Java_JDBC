package com.jdbc;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
//import java.util.*;

public class MainEmployee {

	public static void main(String args[]) throws NumberFormatException, IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		EmployeeTrans emptrans = new EmployeeTrans();
		Employee emp = new Employee();
		while(true)
		{
			System.out.println("1- Add New Employee\n2- Show All Emps\n3- Search Emp based on Empno\n4- Update Employee\n5- Exit");
			Integer choice=Integer.parseInt(br.readLine());
			switch(choice)
			{
			case 1:
				System.out.println("Enter Employee Id");
				emp.setId(Integer.parseInt(br.readLine()));
				System.out.println("Enter Employee Name");
				emp.setName(br.readLine());
				System.out.println("Enter Salary");
				emp.setSalary(Integer.parseInt(br.readLine()));
				System.out.println("Enter Mail ");
				emp.setMail(br.readLine());
				String str=emptrans.addRecord(emp); 
				if(str.equals("Success"))
					System.out.println("Employee Added....");
				else
					System.out.println(str);
				break;
			case 2:
				List<Employee>  empinfo = emptrans.showAllEmployee();
				if(empinfo.size()==0)
					System.out.println("No Employees existed");
				else
				{
					for(Employee e: empinfo)
					{
						System.out.println(e.getId() + "\t" + e.getName() + "\t" + e.getSalary() + "\t" + e.getMail());
					}
				}
				break;
			case 3:
				System.out.println("Enter id to search");
				int id=Integer.parseInt(br.readLine());
				Employee em = emptrans.search(id);
				if(em!=null)
				{
					System.out.println(em.getId() + "\t" + em.getName() + "\t" + em.getSalary() + "\t" + em.getMail());
				}
				else
					System.out.println("Emp Not Found");
				break;
			case 4:
				System.out.println("Employee Id : ");
				int eno=Integer.parseInt(br.readLine());
				Employee em1 = emptrans.search(eno);
				if(em1!=null)
				{
					System.out.println(em1.getId() + "\t" + em1.getName() + "\t" + em1.getSalary() + "\t" + em1.getMail());
					System.out.println("Enter New name for employee to modify");
					em1.setName(br.readLine());
					
					String r1 = emptrans.update(em1);
					if(r1.equals("Success"))
						System.out.println("Employee Name Modified....");
					else
						System.out.println(r1);
				}
				else
					System.out.println("Emp Not Found");
				break;
			case 5:
				System.out.println("Thanks for Using App!");
				System.exit(0);
				break;
			}
		}
	}
}
