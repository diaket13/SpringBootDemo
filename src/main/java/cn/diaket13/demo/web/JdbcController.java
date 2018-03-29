package cn.diaket13.demo.web;

import cn.diaket13.demo.bean.SecondBean;
import cn.diaket13.demo.dao.JdbcDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("jdbc")
public class JdbcController {
    @Autowired
    JdbcDAO jdbcDAO;

    @RequestMapping(value = "{id:^[1-9][0-9]*$}", method = RequestMethod.GET)
    public @ResponseBody
    SecondBean get(@PathVariable("id") int id) {
        return jdbcDAO.getById(id);
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public @ResponseBody
    String save(@RequestBody SecondBean secondBean) {
        int i = jdbcDAO.save(secondBean);
        if (i > 0) {
            return "save success";
        } else {
            return "save failure";
        }
    }

    @RequestMapping(value = "{id:^[1-9][0-9]*$}", method = RequestMethod.DELETE)
    public @ResponseBody
    String delete(@PathVariable("id") int id) {
        int i = jdbcDAO.remove(id);
        if (i > 0) {
            return "remove success";
        } else {
            return "remove failure";
        }
    }

    @RequestMapping(value = "{id:^[1-9][0-9]*$}", method = RequestMethod.PUT)
    public @ResponseBody
    String update(@PathVariable("id") int id, @RequestBody SecondBean secondBean) {
        secondBean.setId(id);
        int i = jdbcDAO.update(secondBean);
        if (i > 0) {
            return "update success";
        } else {
            return "update failure";
        }
    }

}
