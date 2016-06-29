package com.premierinc.sboot.demo.controller;

import com.premierinc.sboot.demo.dto.AppProperties;
import com.premierinc.sboot.demo.dto.UserInfoDTO;
import com.premierinc.sboot.demo.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class DemoController {

    private static final Logger logger = LoggerFactory.getLogger(DemoController.class);

    @Autowired
    AppProperties appProperties;

    @Autowired
    UserInfoService userInfoService;

    @RequestMapping("/demoPage")
    public String addUser(Model model) {

        model.addAttribute("userInfoDTO", new UserInfoDTO());
        model.addAttribute("name", appProperties.getEnv());
        model.addAttribute("userInfoDTOList", userInfoService.getAllUsers());

        return "demopage";
    }

    @RequestMapping("/addUser")
    public String addUser(@Valid UserInfoDTO userInfoDTO, BindingResult bindingResult, Model model) {

        logger.info("UserInfo submitted: " + userInfoDTO);

        if(!bindingResult.hasErrors()){
            userInfoService.update(userInfoDTO);
            model.addAttribute("userInfoDTO", new UserInfoDTO());
        }else{
            model.addAttribute("userInfoDTO", userInfoDTO);
        }

        model.addAttribute("name", appProperties.getEnv());
        model.addAttribute("userInfoDTOList", userInfoService.getAllUsers());

        logger.info(bindingResult.toString());
        return "demopage";
    }
}
