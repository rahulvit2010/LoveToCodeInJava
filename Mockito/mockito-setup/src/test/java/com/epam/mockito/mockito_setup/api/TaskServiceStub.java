package com.epam.mockito.mockito_setup.api;

import java.util.Arrays;
import java.util.List;

public class TaskServiceStub implements TaskService {

	@Override
	public List<String> retreiveTasks(String user) {
		return Arrays.asList("Learn Spring MVC","Learn Spring");
	}

}
