package com.codegym.controller;

import com.codegym.dto.ContractDto;
import com.codegym.dto.CustomerDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.customer.Customer;
import com.codegym.model.customer.CustomerType;
import com.codegym.model.employee.Employee;
import com.codegym.model.service.Service;
import com.codegym.service.IContractService;
import com.codegym.service.ICustomerService;
import com.codegym.service.IEmployeeService;
import com.codegym.service.IFacilityService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService iContractService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IFacilityService iFacilityService;

    @ModelAttribute("customerList")
    private List<Customer>customerList(){
        return iCustomerService.findByAll();
    }
    @ModelAttribute("employeeList")
    private List<Employee>employeeList(){
        return iEmployeeService.findByAll();
    }
    @ModelAttribute("serviceList")
    private List<Service>serviceList(){
        return iFacilityService.findByAllService();
    }

    @GetMapping("/create")
    public ModelAndView showCreateNew() {
        ContractDto contractDto = new ContractDto();
        ModelAndView modelAndView = new ModelAndView("contract/create", "contractDto", contractDto);
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(@Valid @ModelAttribute ContractDto contractDto, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasFieldErrors()) {
            modelAndView.setViewName("contract/create");
            return modelAndView;
        }

        Contract contract = new Contract();
        BeanUtils.copyProperties(contractDto, contract);
        contract.setEmployee(contractDto.getEmployee());
        contract.setCustomer(contractDto.getCustomer());
        contract.setService(contractDto.getService());
        iContractService.save(contract);
        modelAndView.setViewName("redirect:/facility/home");
        return modelAndView;
    }

}
