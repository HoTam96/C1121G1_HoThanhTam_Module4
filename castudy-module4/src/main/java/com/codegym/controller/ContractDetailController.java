package com.codegym.controller;


import com.codegym.dto.ContractDetailDto;
import com.codegym.model.contract.Contract;
import com.codegym.model.detail.AttachService;
import com.codegym.model.detail.ContractDetail;
import com.codegym.service.IContractDetailService;
import com.codegym.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/contractDetail")
public class ContractDetailController {

    @Autowired
    private IContractDetailService iContractDetailService;
    @Autowired
    private IContractService iContractService;

    @ModelAttribute("attachServiceList")
    private List<AttachService>attachServiceList(){
        return iContractDetailService.finAllAttachService();
    }
    @ModelAttribute("contractList")
    private List<Contract>contractList(){
        return iContractService.findByAllContract();
    }
    @GetMapping("/detail")
    public ModelAndView createContractDetail(){
        ContractDetailDto contractDetailDto = new ContractDetailDto();
        ModelAndView modelAndView = new ModelAndView("/contractDetail/create","contractDetailDto",contractDetailDto);
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(@Valid @ModelAttribute ContractDetailDto contractDetailDto, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        if (bindingResult.hasFieldErrors()){
            modelAndView.setViewName("contractDetail/create");
            return modelAndView;
        }
        ContractDetail contractDetail = new ContractDetail();
        BeanUtils.copyProperties(contractDetailDto,contractDetail);
        Contract contract = new Contract();
        AttachService attachService = new AttachService();
        contract.setId(contractDetailDto.getContract().getId());
        attachService.setId(contractDetailDto.getAttachService().getId());
        contractDetail.setContract(contract);
        contractDetail.setAttachService(attachService);
        iContractDetailService.save(contractDetail);
        modelAndView.setViewName("redirect:/facility/home");
        return modelAndView;

    }







}
