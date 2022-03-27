package org.aptech.t2004e.manager;

import org.aptech.t2004e.dto.ProductDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeManagerTest {
    @Autowired
    ProductManager employeeManager ;
    @Test
    void gets() {
        System.err.println(employeeManager.gets());
    }

    @Test
    void delete() {
        System.err.println(employeeManager.delete(5));
    }

    @Test
    void getById() {
        System.err.println(employeeManager.getById(1));
    }

    @Test
    void create() {
        System.err.println(employeeManager.save(new ProductDto("Trịnh Đức Nhân" , 10)));
    }
    @Test
    void save() {
        System.err.println(employeeManager.save(new ProductDto(Long.valueOf(1),"Trịnh Đức Nhân" , 10)));
    }
}