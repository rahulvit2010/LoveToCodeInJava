package com.epam.mockito.mockito_setup.buisness;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    public void test()
    {

    List listMOck=mock(List.class);
    when(listMOck.size()).thenReturn(2);
    assertEquals(2,listMOck.size());

    }
}




