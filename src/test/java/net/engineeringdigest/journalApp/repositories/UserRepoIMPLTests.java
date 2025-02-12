package net.engineeringdigest.journalApp.repositories;

import net.engineeringdigest.journalApp.repository.UserRepoIMPL;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepoIMPLTests {

    @Autowired
    private UserRepoIMPL userRepoIMPL;

    @Test
    public void testSaveNewUser(){
        Assertions.assertNotNull(userRepoIMPL.getUserSA());
    }
}
