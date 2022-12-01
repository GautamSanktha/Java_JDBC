package com.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTrans {
	private Connection conn = null;
	EmployeeTrans()
	{
		conn = Dbconnection.getConnection();
		System.out.println("Connected ....");
	}
	public String  addRecord(Employee emp)
	{
		String res = "";
		try
		{
			PreparedStatement ps = conn.prepareStatement("Insert into gautam values(?,?,?,?)");
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.setInt(3, emp.getSalary());
			ps.setString(4, emp.getMail());
			int r = ps.executeUpdate();
			if(r>=1)
				res = "Success";				
		}
		catch(Exception ex)
		{
			res = "Error ! " + ex.getMessage();
		}
		
		return res;
	}
	public List<Employee> showAllEmployee()
	{
		List<Employee>  empobj = new ArrayList<Employee>();
		try {
			Employee emp=null;
			PreparedStatement ps=conn.prepareStatement("select * from gautam");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("ename"));
				emp.setSalary(rs.getInt("salary"));
				emp.setMail(rs.getString("email"));
				empobj.add(emp);
			}
		}
		catch (SQLException e) {
		
			e.printStackTrace();
		}
		return empobj;
		
	}
	public Employee search(int id)
	{
		Employee obj=null;
		try {
			PreparedStatement ps=conn.prepareStatement("select * from gautam where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
			{
				obj=new Employee();
				obj.setId(rs.getInt("id"));
				obj.setName(rs.getString("ename"));
				obj.setSalary(rs.getInt("salary"));
				obj.setMail(rs.getString("email"));
			}
		}
		catch (SQLException e) {
			obj=null;
			e.printStackTrace();
		}
		return obj;
		
	}
	public String update(Employee emp)
	{
		String res = "";
		try
		{
			PreparedStatement ps = conn.prepareStatement("Update gautam set ename=? where id=?");
			ps.setString(1, emp.getName());
			ps.setInt(2, emp.getId());			
			int r = ps.executeUpdate();
			if(r>=1)
				res = "Success";				
		}
		catch(Exception ex)
		{
			res = "Error ! " + ex.getMessage();
		}
		
		return res;
	}

}
