package io.khasang.gahelp.controller;

import io.khasang.gahelp.model.Cat;
import io.khasang.gahelp.model.CreateTable;
import io.khasang.gahelp.service.KnightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    private Cat cat;
    private KnightService knightService;
    private CreateTable createTable;

    @RequestMapping("/")
    public String getStatus() {
        return "status";
    }

//    @Secured("ROLE_ADMIN")
    @RequestMapping("/hello/{name}")
    public String getHelloPage(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping("/password/{password}")
    public String getEncryptPassword(@PathVariable("password") String password, Model model) {
        model.addAttribute("password",password);
        model.addAttribute("passwordAfterEncode",new BCryptPasswordEncoder().encode(password));
        return "password";
    }

    @RequestMapping("/knight/fight/{enemy}")
    public String getKnightFightInfo(@PathVariable String enemy, Model model) {
        model.addAttribute("info", knightService.getAchievement(enemy));
        return "knight";
    }

    @RequestMapping("/name")
    public String getCatName(Model model) {
        model.addAttribute("name", cat.getName());
        return "cat";
    }

    @RequestMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }
    @RequestMapping("/user")
    public String getUserPage(){
        return "user";
    }

    @RequestMapping("/create")
    public String getTableCreationStatus(Model model) {
        model.addAttribute("status", createTable.tableCreationStatus());
        return "createtable";
    }

    @RequestMapping("/count")
    public String getCatCount(Model model) {
        model.addAttribute("count", createTable.check());
        return "catCount";
    }

    @RequestMapping("/addCat/{name}/{desc}")
    public String addCat(@PathVariable("name") String name,@PathVariable("desc") String desc,Model model) {
        model.addAttribute("addCat", createTable.addCat(name,desc));
        return "addCat";
    }

    @RequestMapping("/catNames")
    public String catNames(Model model) {
        model.addAttribute("catNames",createTable.getCatNames());
        return "catNames";
    }

    @RequestMapping("/updateCat/{name}/{desc}")
    public String updateCat(@PathVariable("name") String name,@PathVariable("desc") String desc,Model model) {
        model.addAttribute("updateCat",createTable.updateCatColor(name,desc));
        return "updateCat";
    }

    @RequestMapping("/deleteCat/{name}")
    public String deleteCat(Model model,@PathVariable String name) {
        model.addAttribute("deleteCat",createTable.deleteCatByName(name));
        return "deleteCat";
    }

    @Autowired
    public void setService(KnightService service) {
        this.knightService = service;
    }

    @Autowired
    public void setCreateTable(CreateTable createTable) {
        this.createTable = createTable;
    }
}
