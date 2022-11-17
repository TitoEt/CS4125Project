package com.castletroymedical.jpa.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.castletroymedical.database.repository.PatientRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JPAUnitTest {
    
    // @Autowired
    // private TestEntityManager entityManager;

    @Autowired 
    PatientRepository repository;

    @Test
    public void should_find_no_tutorials_if_repository_is_empty() { }
  
    @Test
    public void should_store_a_tutorial() { }
  
    @Test
    public void should_find_all_tutorials() { }
  
    @Test
    public void should_find_tutorial_by_id() { }
}
