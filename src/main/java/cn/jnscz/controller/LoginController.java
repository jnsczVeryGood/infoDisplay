package cn.jnscz.controller;

import cn.jnscz.service.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    private LoginServiceImp loginServiceImp;

    @RequestMapping(value = "/login")
    public String displayUserInfo(@RequestParam("username") String username, @RequestParam("password") String password, ModelMap model) {
        try {
            if (loginServiceImp.login(username, password)) {
                model.addAttribute("username",username);
                return "redirect:/userInfo";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "error";
    }
}
