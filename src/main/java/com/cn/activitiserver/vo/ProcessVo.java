package com.cn.activitiserver.vo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by admin on 2019/8/2.
 */
@Data
public class ProcessVo implements Serializable{

    //与业务关联的id标识
    @NotEmpty
    private String businessKey;

    @NotEmpty
    private String flowModelKey;
    //参数
    @NotEmpty
    private Map<String, Object> parmsMap;

    @Override
    public String toString() {
        return "ProcessVo{" +
                "businessKey='" + businessKey + '\'' +
                ", parmsMap=" + parmsMap +
                '}';
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (businessKey != null ? businessKey.hashCode() : 0);
        result = 31 * result + (parmsMap != null ? parmsMap.hashCode() : 0);
        return result;
    }
}
