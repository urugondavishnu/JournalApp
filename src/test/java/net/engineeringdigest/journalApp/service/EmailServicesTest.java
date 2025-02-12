package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.services.EmailServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServicesTest {

    @Autowired
    private EmailServices emailServices;

    @Test
    void testSendMail(){
        emailServices.sendEmail("nashikvaddi@gmail.com", "java Email Test", "potti puka");
    }
}
