package com.codegym.controller;


import com.codegym.dto.EmployeeDto;
import com.codegym.dto.UserDto;

import com.codegym.model.employee.Division;
import com.codegym.model.employee.EducationDegree;
import com.codegym.model.employee.Employee;
import com.codegym.model.employee.Position;
import com.codegym.model.user.AppRole;
import com.codegym.model.user.AppUser;
import com.codegym.model.user.UserRole;
import com.codegym.repository.IApproleRepository;
import com.codegym.repository.IUserRoleRepository;
import com.codegym.service.IEmployeeService;
import com.codegym.util.EncrytedPasswordUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IUserRoleRepository iUserRoleRepository;
    @Autowired
    private IApproleRepository iApproleRepository;


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
        AppUser user = new AppUser();
        user.setUserName(employeeDto.getUserDto().getUserName());
        String decoPassWord = EncrytedPasswordUtils.encrytePassword(employeeDto.getUserDto().getPassWord());
        user.setPassWord(decoPassWord);

        employee.setUser(user);
        employee.setFlag(true);
        iEmployeeService.save(employee);
        UserRole userRole = new UserRole();
        AppRole appRole = new AppRole();
        if (employee.getPosition().getId() == 1 || employee.getPosition().getId() == 2) {
            List<AppRole> appRoleList = iApproleRepository.findAll();
            userRole.setUser(user);
            appRole.setId(appRoleList.get(0).getId());
            appRole.setRoleName(appRoleList.get(0).getRoleName());
            userRole.setRole(appRole);
            iUserRoleRepository.save(userRole);
        }else {
            List<AppRole> appRoleList = iApproleRepository.findAll();
            userRole.setUser(user);
            appRole.setId(appRoleList.get(1).getId());
            appRole.setRoleName(appRoleList.get(1).getRoleName());
            userRole.setRole(appRole);
            iUserRoleRepository.save(userRole);
        }

        modelAndView.setViewName("redirect:/employee/list");
        return modelAndView;
    }

    @GetMapping("/showEdit/{id}")
    public ModelAndView showEdit(@PathVariable("id") Integer id) {
        Employee employee = iEmployeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        UserDto userDto = new UserDto();
        userDto.setUserName(employee.getUser().getUserName());
        employeeDto.setUserDto(userDto);
        ModelAndView modelAndView = new ModelAndView("employee/edit", "employeeDto", employeeDto);

        List<Position> positionList = iEmployeeService.findByAllPosition();
        List<Division> divisionList = iEmployeeService.findByAllDivision();
        List<EducationDegree> educationDegreeList = iEmployeeService.findByAllEducation();
        modelAndView.addObject("positionList", positionList);
        modelAndView.addObject("divisionList", divisionList);
        modelAndView.addObject("educationDegreeList", educationDegreeList);
        return modelAndView;
    }

    @PostMapping("/saveEdit")
    public ModelAndView saveEdit(@Valid @ModelAttribute EmployeeDto employeeDto, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasFieldErrors()) {
            modelAndView.setViewName("employee/edit");
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

        BeanUtils.copyProperties(employeeDto, employee);
        employee.setPosition(employeeDto.getPosition());
        employee.setEducationDegree(employeeDto.getEducationDegree());
        employee.setDivision(employeeDto.getDivision());
        AppUser user = new AppUser();
        user.setUserName(employeeDto.getUserDto().getUserName());
        user.setPassWord(employeeDto.getUserDto().getPassWord());
        employee.setUser(user);
        employee.setFlag(true);

        iEmployeeService.update(employee);
        modelAndView.setViewName("redirect:/employee/list");
        return modelAndView;
    }


}
