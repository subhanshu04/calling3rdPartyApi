package com.example.productservicescaler;

import com.example.productservicescaler.inheritanceExamples.singleTable.SingleMentorRepo;
import com.example.productservicescaler.inheritanceExamples.singleTable.SingleUserRepo;
import com.example.productservicescaler.inheritanceExamples.singleTable.Mentor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProductServiceScalerApplicationTests {
    @Autowired
    private SingleUserRepo singleUserRepo;
    @Autowired
    private SingleMentorRepo singleMentorRepo;
    @Test
    void contextLoads() {
    }

    @Test
    void testDifferentInheritance(){
        Mentor mentor = new Mentor();
        mentor.setName("Subhanshu");
        mentor.setMenteeList(6);
        singleMentorRepo.save(mentor);
    }
}
