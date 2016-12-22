package com.glarimy.api;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface Directory {
	public void add(Employee employee) throws InvalidEmployeeException, DuplicateEmployeeException, DirectoryException;

	public Optional<Employee> find(int eid) throws EmployeeNotFoundException, DirectoryException;

	public List<Employee> list() throws DirectoryException;

	public List<Employee> search(Predicate<Employee> criteria) throws DirectoryException;
}