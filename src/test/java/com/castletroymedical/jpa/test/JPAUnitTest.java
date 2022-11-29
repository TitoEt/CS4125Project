package com.castletroymedical.jpa.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest; 
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JPAUnitTest {
    @Test
    public void should_find_no_tutorials_if_repository_is_empty() { }
  
    @Test
    public void should_store_a_tutorial() { }
  
    @Test
    public void should_find_all_tutorials() { }
  
    @Test
    public void should_find_tutorial_by_id() { }
}
