package com.glarimy.ui;

import java.util.List;

import com.glarimy.api.Directory;
import com.glarimy.api.Employee;
import com.glarimy.service.GlarimyDirectory;

public class DirectoryConsole {
	public static void main(String[] args) throws Exception {
		Directory directory = new GlarimyDirectory();
		directory.add(new Employee(1973, "Krishna"));
		directory.add(new Employee(1974, "Mohan"));

		List<Employee> results = directory.search((e) -> {
			if (e.getName().length() < 8)
				return true;
			return false;
		});

		System.out.println(results);
	}
}
