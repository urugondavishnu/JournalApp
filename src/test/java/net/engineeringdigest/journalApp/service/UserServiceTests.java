package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.repository.UserRepo;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepo userRepo;


//    @Disabled
//    @Test
//    public void testFindByUserName(){
////        assertEquals(4, 2+2);
////        assertNotNull(userRepo.findByUserName("hello")); //Both the asserts come under one test
//
//        User user = userRepo.findByUserName("hello");
//        assertTrue(!user.getJournalEntries().isEmpty());
//    }

    @Disabled
    @ParameterizedTest
    @ValueSource(strings={
            "hello",
            "vishnu",
            "vipul",
            "sumedh"
    })
    public void testFindByUserName(String name){
        assertNotNull(userRepo.findByUserName(name), "Test is failed for: " + name);
    }


    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,2,2",
            "69,31,100"
    })
    public void test(int a, int b, int expected){
        assertEquals(expected,a+b);
    }

}
