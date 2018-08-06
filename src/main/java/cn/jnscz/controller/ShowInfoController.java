package cn.jnscz.controller;

import cn.jnscz.domain.User;
import cn.jnscz.service.RegisterUserServicelmp;
import cn.jnscz.service.ShowUserInfoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class ShowInfoController {

    @Autowired
    private ShowUserInfoServiceImp showUserInfoServiceImp;
    @Autowired
    private RegisterUserServicelmp registerUserServicelmp;

    @RequestMapping(value="/userInfo")
    public String displayUserInfo(@RequestParam("username") String username, ModelMap model) {
        try {
            User user = null;
            user = showUserInfoServiceImp.showInfo(username);
            model.addAttribute("user",user);
            return "userInfo";
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "error";
    }

    @RequestMapping(value="/register")
    public String registerUser(User user, ModelMap model) {
        try {
            User user1=null;
            user1=showUserInfoServiceImp.showInfo(user.getUsername());


                if(!user.getUsername().equals("")&&user1==null) {
                    //System.out.println(user);
                    if(!user.getPassword().equals("")&&user.getPassword().length()<=12&&user.getPassword().length()>=6) {
                        if(user.getAccount()>=0&&!user.getAccount().toString().equals("")) {
                            if(user.getAge()<100&&user.getAge()>0) {
                                if (user.getName().length()<5&&user.getName().length()>0) {
                                    registerUserServicelmp.registerUser(user);
                                    return "success";
                                }
                                else {
                                    model.addAttribute("msg","姓名不合法！");
                                    return "register";
                                }
                            }
                            else {
                                model.addAttribute("msg","年龄不合法！");
                            return "register";
                            }
                        }
                        else {
                            model.addAttribute("msg","账户不能为空且不能为负数！");
                            return "register";
                        }
                    }

                    else {
                        model.addAttribute("msg","密码长度必须为6-12位！");
                        return "register";
                    }
                }
                else {
                    model.addAttribute("msg","用户名已经存在！");
                    return "register";
                }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "failure";
    }

}
