package com.cts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.cts.model.Employee;

@Repository
public class EmployeeDAO 
{
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	DataSource dataSource;
    ResultSet resultset;

	public boolean employeeInsert(Employee employee)
	{
		
			String sql="insert into employee values(?,?,?,?)";
			
			int flag=jdbcTemplate.update(sql,employee.getId(),employee.getName(),employee.getDesg(),employee.getSalary());
			if(flag>0)
				return true;
				else
					return false;
	}

	public Employee employeeSearch(int id) {

		 String sql="select * from employee where id=?";
		return  jdbcTemplate.queryForObject(sql,new MyRowMapper(),id);
	  
	}
	
	class MyRowMapper implements RowMapper<Employee>{
		
		@Override
		public Employee mapRow(ResultSet rs,int rowNum) throws SQLException{
			Employee emp=new Employee();
			emp.setId(rs.getInt("id"));
			emp.setName(rs.getString("name"));
			emp.setDesg(rs.getString("desg"));
			emp.setSalary(rs.getInt("salary"));
			return emp;
		}
	}
	
	public List<Employee> getAllEmployee() {
		
		
			String sql="select * from employee";
		return	jdbcTemplate.query(sql,new MyRowMapper());
	  		
	}

	
}

