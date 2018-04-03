package cn.diaket13.demo.web;

import cn.diaket13.demo.entity.DemoDO;
import cn.diaket13.demo.mapper.annotation.AnotherDemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.beans.Transient;
import java.util.List;

@RestController
@RequestMapping(value = "mybatisA")
public class MybatisAnnotationController {
    @Autowired
    AnotherDemoMapper demoMapper;

    @RequestMapping(value = "{id:^[1-9][0-9]*$}", method = RequestMethod.GET)
    public @ResponseBody
    DemoDO get(@PathVariable("id") int id) {
        return demoMapper.getById(id);
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public @ResponseBody
    String save(@RequestBody DemoDO demoDO) {
        int i = demoMapper.save(demoDO);
        if (i > 0) {
            return "save success";
        } else {
            return "save failure";
        }
    }

    @RequestMapping(value = "{id:^[1-9][0-9]*$}", method = RequestMethod.DELETE)
    public @ResponseBody
    String delete(@PathVariable("id") int id) {
        int i = demoMapper.remove(id);
        if (i > 0) {
            return "remove success";
        } else {
            return "remove failure";
        }
    }

    @RequestMapping(value = "{id:^[1-9][0-9]*$}", method = RequestMethod.PUT)
    public @ResponseBody
    String update(@PathVariable("id") int id, @RequestBody DemoDO demoDO) {
        demoDO.setId(id);
        int i = demoMapper.update(demoDO);
        if (i > 0) {
            return "update success";
        } else {
            return "update failure";
        }
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public @ResponseBody
    List<DemoDO> list() {
        return demoMapper.list();
    }
    /*以下两个方法为事务控制的测试,一个加了注解,一个没加*/
    @RequestMapping(value = "test",method = RequestMethod.GET)
    @Transactional
    public @ResponseBody
    DemoDO test(){
        DemoDO demoDO = demoMapper.getById(1);
        System.out.println(demoDO.getDescription());
        demoDO.setDescription("useful1");
        demoMapper.update(demoDO);
        int i = 1/0;
        DemoDO demoDO1 = new DemoDO();
        demoDO1.setName("测试武器");
        demoMapper.save(demoDO1);
        return demoDO;
    }

    @RequestMapping(value = "test1",method = RequestMethod.GET)
    public @ResponseBody
    DemoDO test1(){
        DemoDO demoDO = demoMapper.getById(1);
        System.out.println(demoDO.getDescription());
        demoDO.setDescription("useful2");
        demoMapper.update(demoDO);
        int i = 1/0;
        DemoDO demoDO1 = new DemoDO();
        demoDO1.setName("测试武器");
        demoMapper.save(demoDO1);
        return demoDO;
    }
}
