package com.epam.mockito.mockito_setup.buisness;

import java.util.ArrayList;
import java.util.List;

import com.epam.mockito.mockito_setup.api.TaskService;

public class TaskBuisnessImpl {
	
	private TaskService taskService;

	public TaskBuisnessImpl(TaskService taskService) {
		super();
		this.taskService = taskService;
	}
	
	public List<String> retreiveTaskRelatedToSpring(String user )
	{
		List<String> filteredtask= new ArrayList<String>();
		List<String> tasks=taskService.retreiveTasks(user);
		
		for(String task:tasks)
		{
			if(task.contains("Spring"))
			{
				filteredtask.add(task);
			}
		}
		return filteredtask;
	}

}
