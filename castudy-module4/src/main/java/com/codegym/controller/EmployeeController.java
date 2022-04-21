package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.dto.EmployeeDto;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.model.employee.Division;
import com.codegym.model.employee.EducationDegree;
import com.codegym.model.employee.Employee;
import com.codegym.model.employee.Position;
import com.codegym.model.user.User;
import com.codegym.service.IEmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.soap.SOAPBinding;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;


    @GetMapping("/list")
    public ModelAndView showList(@PageableDefault(value = 2) Pageable pageable,
                                 @RequestParam Optional<String> keyWord) {
        String keyWordValue = keyWord.orElse("");

        Page<Employee> employeePage = iEmployeeService.findByAllCustomer(pageable, keyWordValue);
        ModelAndView modelAndView = new ModelAndView("employee/list", "list", employeePage);
        modelAndView.addObject("keyWord", keyWordValue);
        return modelAndView;
    }

    @GetMapping("/createEmployee")
    public ModelAndView showCreateNew() {
        EmployeeDto employeeDto = new EmployeeDto();
        ModelAndView modelAndView = new ModelAndView("employee/create", "employeeDto", employeeDto);
        List<Position> positionList = iEmployeeService.findByAllPosition();
        List<Division> divisionList = iEmployeeService.findByAllDivision();
        List<EducationDegree> educationDegreeList = iEmployeeService.findByAllEducation();
        modelAndView.addObject("positionList", positionList);
        modelAndView.addObject("divisionList", divisionList);
        modelAndView.addObject("educationDegreeList", educationDegreeList);
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid @ModelAttribute EmployeeDto employeeDto, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasFieldErrors()) {
            modelAndView.setViewName("employee/create");
            List<Position> positionList = iEmployeeService.findByAllPosition();
            List<Division> divisionList = iEmployeeService.findByAllDivision();
            List<EducationDegree> educationDegreeList = iEmployeeService.findByAllEducation();
            modelAndView.addObject("positionList", positionList);
            modelAndView.addObject("divisionList", divisionList);
            modelAndView.addObject("educationDegreeList", educationDegreeList);
            return modelAndView;
        }

        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeDto, employee);
        employee.setPosition(employeeDto.getPosition());
        employee.setEducationDegree(employeeDto.getEducationDegree());
        employee.setDivision(employeeDto.getDivision());
        User user = new User();
        user.setUserName(employeeDto.getUserDto().getUserName());
        user.setPassWord("123");
        employee.setUser(user);
        employee.setFlag(true);
        iEmployeeService.save(employee);
        modelAndView.setViewName("redirect:/employee/list");
        return modelAndView;
    }


}
