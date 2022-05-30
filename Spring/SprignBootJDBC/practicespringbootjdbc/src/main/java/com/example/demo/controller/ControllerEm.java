package com.example.demo.controller;

import com.example.demo.domain.Employee;
import com.example.demo.repository.Repository;
import com.example.demo.service.ServiceEm;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class ControllerEm {

    private final ServiceEm serviceEm;

    public ControllerEm(ServiceEm serviceEm) {
        this.serviceEm = serviceEm;
    }

    @PostMapping
    public ResponseEntity add(@RequestBody Employee employee) {
        Integer id = serviceEm.addEmployee(employee);
        if (id != null) {
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        } else {
            return new ResponseEntity(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity getEmployees(){
        List<Employee> employeeList= serviceEm.getEmployees();
        return new ResponseEntity<>(employeeList,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity getEmployee(@PathVariable ("id") int id){
        Employee employee = serviceEm.getEmployee(id);
        if (employee==null){
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }
    }

    @DeleteMapping ("{id}")
    public ResponseEntity deleteEmployee(@PathVariable int id){
        if (serviceEm.getEmployee(id)!=null){
            serviceEm.deleteEmployee(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("Zaměstnanec s tímto id neexistuje");
        }

    }

    @PatchMapping("{id}")
    public ResponseEntity updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        if (serviceEm.getEmployee(id) !=null){
            serviceEm.updateEmployee( id, employee);
            return ResponseEntity.ok().build();
        }else {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body("Zaměstnanec s tímto ID neexistuje, proto jej nelze aktualizovat");
        }
    }
}
