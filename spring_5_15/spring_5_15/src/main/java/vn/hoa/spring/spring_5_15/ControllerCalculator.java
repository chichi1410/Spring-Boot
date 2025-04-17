package vn.hoa.spring.spring_5_15;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerCalculator {
    private Calculator calculator;

    @Autowired
    public ControllerCalculator(@Qualifier("getCalculator") Calculator calculator) {
        this.calculator = calculator;
    }

    @GetMapping("/CanBacHai") // them o duoi ?value=9
    public String tinhCanBacHai(@RequestParam("value")  double x){
        return "sqrt("+ x + ") = " + calculator.canBacHai(x);
    }

    @GetMapping("/BinhPhuong")
    public String tinhBinhPhuong(@RequestParam("value") double x){
        return x + "^2 = " + calculator.binhPhuong(x);
    }

}
