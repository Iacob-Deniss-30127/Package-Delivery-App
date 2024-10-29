package com.example.PackageDelivery.Controllers;

import com.example.PackageDelivery.Services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {
    @Autowired
    public TestService testService;

    @GetMapping()
    @ResponseBody()
    public String getMessage() {
        testService.message();
        return "Message printed in backend";
    }

}
