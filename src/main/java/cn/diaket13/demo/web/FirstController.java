package cn.diaket13.demo.web;

import cn.diaket13.demo.bean.FirstBean;
import cn.diaket13.demo.bean.SecondBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/first")
@EnableConfigurationProperties({FirstBean.class, SecondBean.class})
public class FirstController {
    @Value("${data.string1}")
    private String s1;

    @Value("${information.name}")
    private String s2;

    @Value("${data.boolean1}")
    private boolean b1;
    @Autowired
    private FirstBean firstBean;
    @Autowired
    private SecondBean secondBean;

    @RequestMapping("111")
    public String index(){
        return s1+ s2;
    }
    @RequestMapping("222")
    public String index2(){
        if(b1){
            return "这是真的";
        }
        return "这是假的";
    }
    @RequestMapping("333")
    public String index3(){
        return firstBean.toString();
    }
    @RequestMapping("444")
    public String index4(){
        System.out.println(secondBean.getDescription());
        return "name" + secondBean.getName() + secondBean.getDescription();
    }
}
