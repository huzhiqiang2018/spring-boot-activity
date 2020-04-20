package com.cn.activitiserver.controller;

import com.cn.activitiserver.vo.ProcessVo;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.runtime.ProcessInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2019/8/2.
 */
@RestController
@RequestMapping(value = "/process")
public class ProcessController {

    @Autowired
    private ProcessEngine processEngine;

    /**
     * 开启流程方法
     * parms = ProcessVo
     * */
    @RequestMapping(value = "/startProcess",method = RequestMethod.POST)
    public String startProcess(@Validated @RequestBody ProcessVo processVo){
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceById(processVo.getFlowModelKey(),processVo.getBusinessKey());
        return processInstance.getProcessInstanceId();
    }
}
