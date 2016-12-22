package com.glarimy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.glarimy.api.Directory;
import com.glarimy.api.DirectoryException;
import com.glarimy.api.DuplicateEmployeeException;
import com.glarimy.api.Employee;
import com.glarimy.api.EmployeeNotFoundException;
import com.glarimy.api.InvalidEmployeeException;
import com.glarimy.data.DAO;
import com.glarimy.data.MemoryDAO;

public class GlarimyDirectory implements Directory {
	private DAO dao = MemoryDAO.getInstance();

	@Override
	public void add(Employee employee) throws InvalidEmployeeException, DuplicateEmployeeException, DirectoryException {
		if (employee == null || employee.getEid() < 1972 || employee.getName() == null
				|| employee.getName().trim().length() == 0)
			throw new InvalidEmployeeException();
		if (dao.find(employee.getEid()) != null) {
			throw new DuplicateEmployeeException();
		}
		dao.add(employee);

	}

	@Override
	public Optional<Employee> find(int eid) throws EmployeeNotFoundException, DirectoryException {
		Optional<Employee> result = Optional.empty();
		return result;
	}

	@Override
	public List<Employee> list() throws DirectoryException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> search(Predicate<Employee> criteria) throws DirectoryException {
		List<Employee> results = new ArrayList<>();
		for (Employee e : dao.list()) {
			if (criteria.test(e)) {
				results.add(e);
			}
		}
		return results;
	}
}
