package cn.diaket13.demo.web;

import cn.diaket13.demo.entity.DemoDO;
import cn.diaket13.demo.mapper.xml.DemoMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "mybatisX")
public class MybatisXmlController {
    @Resource
    private DemoMapper demoMapper;

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

}
