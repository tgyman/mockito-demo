package com.tgy.learning.service;

import com.tgy.learning.dao.PersonDao;
import com.tgy.learning.entity.Person;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

public class PersonServiceImplTest {

    private PersonDao mockDao;
    private PersonService personService;

    @Before
    public void setUp() throws Exception {
        //模拟PersonDao对象
//        mockDao=mock(PersonDao.class);
        when(mockDao.getPerson(1)).thenReturn(new Person(1,"许斌"));
        when(mockDao.update(isA(Person.class))).thenReturn(true);

        personService=new PersonServiceImpl(mockDao);
    }

    @Test
    public void updateTest() throws Exception{
        boolean result = personService.update(1, "李明");
        assertTrue("更新成功",result);

        //验证是否执行过一次getPerson(1)
        verify(mockDao,times(1)).getPerson(eq(1));
        //验证是否执行过一次update
        verify(mockDao,times(1)).update(isA(Person.class));
    }


    @Test
    public void updateNotFoundTest() throws Exception{
        boolean result = personService.update(2, "李明");
        assertFalse("更新失败",result);

        //验证是否执行过一次getPerson(1)
        verify(mockDao,times(1)).getPerson(eq(2));
        //验证是否执行过一次update
        verify(mockDao,times(1)).update(isA(Person.class));
    }
}