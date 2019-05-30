package com.acquisio.app.controller;

import com.acquisio.app.domain.Employee;
import com.acquisio.app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


/* The following results returned from http://localhost:8080/employees, so can use gravatarImageURL to find the gravatar image now

[{"id":1,"firstName":"John","lastName":"Smith","email":"onlinetest.acquisio+jsmith@gmail.com","salary":20000,"gravatarImageURL":"https://www.gravatar.com/avatar/a2d0c93c17683377100645a0d1db3d2f"},{"id":2,"firstName":"Ava","lastName":"Muffinson","email":"onlinetest.acquisio+amuffinson@gmail.com","salary":10000,"gravatarImageURL":"https://www.gravatar.com/avatar/a25a90b8bbe6acb55c4d7ac5007894e1"},{"id":3,"firstName":"Cailin","lastName":"Ninson","email":"onlinetest.acquisio+cninson@gmail.com","salary":30000,"gravatarImageURL":"https://www.gravatar.com/avatar/6838aa212ebe3786c73696ede0c21d4f"},{"id":4,"firstName":"Mike","lastName":"Peterson","email":"onlinetest.acquisio+mpeterson@gmail.com","salary":20000,"gravatarImageURL":"https://www.gravatar.com/avatar/bf6fc85076d59cc375fa0520a6b60fab"},{"id":5,"firstName":"Ian","lastName":"Peterson","email":"onlinetest.acquisio+ipeterson@gmail.com","salary":80000,"gravatarImageURL":"https://www.gravatar.com/avatar/4fd6503f7b75a5eb244c98a2107ddfe7"},{"id":6,"firstName":"John","lastName":"Mills","email":"onlinetest.acquisio+jmills@gmail.com","salary":50000,"gravatarImageURL":"https://www.gravatar.com/avatar/29a7feb1240230c92509e18115bb179e"}]

*/


@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping("/employees")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Employee> listEmployees() throws SQLException {
        return employeeRepository.findAll();
    }
}
