package com.epam.mockito.mockito_setup.buisness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.epam.mockito.mockito_setup.api.TaskService;

public class TaskBuisnessImplMockTest {
	@Test
	public void testRetreiveTaskRelatedToSpring_UsingAMock()
	{
		TaskService taskServiceMock= mock(TaskService.class);
		when(taskServiceMock.retreiveTasks("Dummy")).thenReturn(Arrays.asList("Learn Spring MVC","Learn Spring"));
		TaskBuisnessImpl taskBuisness= new TaskBuisnessImpl(taskServiceMock);
		List<String> filteredTasks=taskBuisness.retreiveTaskRelatedToSpring("Dummy");
		
	   assertEquals(2,filteredTasks.size());
	}


	@Test
	public void testRetreiveTaskRelatedToSpring_EmptyList()
	{
		TaskService taskServiceMock= mock(TaskService.class);
		List<String> todos= Arrays.asList();
		when(taskServiceMock.retreiveTasks("Dummy")).thenReturn(todos);
		TaskBuisnessImpl taskBuisness= new TaskBuisnessImpl(taskServiceMock);
		List<String> filteredTasks=taskBuisness.retreiveTaskRelatedToSpring("Dummy");

		assertEquals(0,filteredTasks.size());
	}

}
