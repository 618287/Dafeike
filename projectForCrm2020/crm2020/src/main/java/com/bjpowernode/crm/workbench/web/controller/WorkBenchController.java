package com.bjpowernode.crm.workbench.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ************
 * 暗月     *********
 * **    *   *
 * **********
 * <p>
 * 2021/6/5
 */
@Controller
public class WorkBenchController {
    @RequestMapping("/workbench/index")
    public String skipWorkBench(){
        return "workbench/index";
    }
}
