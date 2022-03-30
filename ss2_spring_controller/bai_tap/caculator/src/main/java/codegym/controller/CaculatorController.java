package codegym.controller;

import codegym.repository.ICaculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {

    @Autowired
    private ICaculator iCaculator;

    @GetMapping("")
    public String getCaculator() {
        return "caculator";

    }

    @GetMapping("/caculator")
    public String resultCaculator(@RequestParam("number1") double num1, @RequestParam("number2") double num2,
                                  @RequestParam("opera") String opera, Model model) {

        double result = 0;
        switch (opera) {
            case "plus":
                result = this.iCaculator.plus(num1, num2);
                break;
            case "minus":
                result = this.iCaculator.minus(num1, num2);
                break;
            case "multiplication":
                result = this.iCaculator.mutiplication(num1, num2);
                break;
            case "division":
                if (num2 ==0){
                    model.addAttribute("message","không được để số 0");
                    return "caculator";
                }
                result = this.iCaculator.division(num1, num2);
                break;
            default:

        }

        model.addAttribute("result",result);
        return "caculator";


    }

}
