package com.oocl.web.sampleWebApp.jpaSample.repository;

import com.oocl.web.sampleWebApp.jpaSample.entity.Single;
import com.oocl.web.sampleWebApp.jpaSample.entity.User;
import com.oocl.web.sampleWebApp.jpaSample.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

public class SingleRespositoryTest {

    @Autowired
    private SingleRepository singleRepository;

    @Test
    public void test_should_return_single_when_the_user_exist() {
        //given
        Single single = new Single();
        single.setName("test");
        singleRepository.save(single);

        //when
        List<Single> SingleList = singleRepository.findAll();

        //then
        Assertions.assertEquals(1, SingleList.size());
        Assertions.assertEquals("test", SingleList.get(0).getName());
    }

    @Test
    public void test_should_throw_exception_when_id_large_than_sixty() {
        //given
        Single single = new Single();
        single.setName("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");

        //when
//        singleRepository.saveAndFlush(single);

        //then
        Assertions.assertThrows(Exception.class,() ->  singleRepository.saveAndFlush(single));
    }

    @Test
    public void test_should_return_User_when_select_by_name() {
        //given
        Single single = new Single();
        single.setName("test");
        singleRepository.save(single);
        Single singleone = new Single();
        singleone.setName("testone");
        singleRepository.save(singleone);

        //when
        Single singletest = singleRepository.findByName("test");

        //then
        Assertions.assertEquals("test",singletest.getName());
    }

    @Test
    public void test_should_return_users_when_select_by_name() {
        //given
        Single single = new Single();
        single.setName("test");
        singleRepository.save(single);
        Single singleone = new Single();
        singleone.setName("testone");
        singleRepository.save(singleone);
        Single singletwo = new Single();
        singletwo.setName("test");
        singleRepository.save(singletwo);

        //when
        List<Single> singletest = singleRepository.findSingleByName("test");

        //then
        Assertions.assertEquals("test",singletest.get(0).getName());
        Assertions.assertEquals("test",singletest.get(1).getName());
    }

    @Test
    public void test_should_delete_users_by_name_when_give_a_name() {
        //given
        Single single = new Single();
        single.setName("test");
        singleRepository.save(single);
        Single singleone = new Single();
        singleone.setName("testone");
        singleRepository.save(singleone);
        Single singletwo = new Single();
        singletwo.setName("testtwo");
        singleRepository.save(singletwo);

        //when
        singleRepository.delete(singletwo);
        List<Single> singletest = singleRepository.findAll();

        //then
        Assertions.assertEquals("test",singletest.get(0).getName());
        Assertions.assertEquals("testone",singletest.get(1).getName());
        Assertions.assertThrows(Exception.class,()->singletest.get(2).getName());
    }

    @Test
    public void test_should_delete_allusers() {
        //given
        Single single = new Single();
        single.setName("test");
        singleRepository.save(single);
        Single singleone = new Single();
        singleone.setName("testone");
        singleRepository.save(singleone);
        Single singletwo = new Single();
        singletwo.setName("testtwo");
        singleRepository.save(singletwo);

        //when
        singleRepository.deleteAll();
        List<Single> singletest = singleRepository.findAll();

        //then

        Assertions.assertThrows(Exception.class,()->singletest.get(0).getName());
        Assertions.assertThrows(Exception.class,()->singletest.get(1).getName());
        Assertions.assertThrows(Exception.class,()->singletest.get(2).getName());
    }
}
