package yaroslav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import yaroslav.model.User;
import yaroslav.service.interfaces.UserService;

@Controller
public class AdminController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public ModelAndView welcome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        return modelAndView;
    }

    @GetMapping(value = "/admin")
    public ModelAndView admin(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("adminUsers");
        modelAndView.addObject("usersList", userService.getAllUsers());
        return modelAndView;
    }

    @GetMapping(value = "/admin/editUser/{id}")
    public ModelAndView editPage(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/editUser");
        modelAndView.addObject("userEditing", userService.getUserById(id));
        return modelAndView;
    }

    @PostMapping(value = "/admin/editUser")
    public ModelAndView editUser(@ModelAttribute("user") User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        userService.edit(user);
        return modelAndView;
    }

    @GetMapping(value = "/admin/add")
    public ModelAndView addPage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/addUser");
        return modelAndView;
    }

    @PostMapping(value = "/admin/addUser")
    public ModelAndView addUser(@ModelAttribute("user") User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");

        if (userService.userIsExist(user)){
            modelAndView.addObject("message", "Имя занято");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/admin");
        userService.addUser(user);
        return modelAndView;
    }

    @GetMapping(value = "/admin/delete/{id}")
    public ModelAndView deletePage(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/admin/deleteUser");
        modelAndView.addObject("userDelete", userService.getUserById(id));
        return modelAndView;
    }

    @PostMapping(value = "/admin/delete/{id}")
    public ModelAndView deleteUser(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/admin");
        userService.deleteUser(id);
        return modelAndView;
    }
}
