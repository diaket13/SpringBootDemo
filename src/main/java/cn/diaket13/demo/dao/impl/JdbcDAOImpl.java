package cn.diaket13.demo.dao.impl;

import cn.diaket13.demo.bean.SecondBean;
import cn.diaket13.demo.dao.JdbcDAO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class JdbcDAOImpl implements JdbcDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(SecondBean secondBean) {
        return jdbcTemplate.update("INSERT INTO demo(NAME,ATTACK,TYPE,DESCRIPTION) VALUES (?,?,?,?)",
                secondBean.getName(), secondBean.getAttack(), secondBean.getType(), secondBean.getDescription());
    }

    @Override
    public int update(SecondBean secondBean) {
        return jdbcTemplate.update("UPDATE demo SET NAME=?,ATTACK=?,TYPE=?,DESCRIPTION=? WHERE ID=?",
                secondBean.getName(),secondBean.getAttack(),secondBean.getType(),secondBean.getDescription(),secondBean.getId());
    }

    @Override
    public int remove(int id) {
        return jdbcTemplate.update("DELETE FROM demo WHERE ID=?",id);
    }

    @Override
    public SecondBean getById(int id) {
       List<SecondBean> list = jdbcTemplate.query("SELECT ID,NAME,ATTACK,TYPE,DESCRIPTION FROM DEMO WHERE ID=?",
               new Object[]{id}, new BeanPropertyRowMapper<>(SecondBean.class));
       if(list != null && list.size() > 0){
           return list.get(0);
       }
        return null;
    }

    @Override
    public SecondBean getByInfo(SecondBean secondBean) {
        if(secondBean == null){
            return null;
        }
        ArrayList<Object> argList = new ArrayList<>(3);
        StringBuilder sqlBuilder = new StringBuilder("SELECT ID,NAME,ATTACK,TYPE,DESCRIPTION FROM DEMO WHERE 1==1");
        if(secondBean.getName()!=null){
            sqlBuilder.append("AND NAME = ?");
            argList.add(secondBean.getName());
        }
        if(secondBean.getType()!=null){
            sqlBuilder.append("AND TYPE = ?");
            argList.add(secondBean.getType());
        }
        if(secondBean.getAttack()!=null){
            sqlBuilder.append("AND ATTACK = ?");
            argList.add(secondBean.getAttack());
        }
        List<SecondBean> list = jdbcTemplate.query(sqlBuilder.toString(),
                argList.toArray(), new BeanPropertyRowMapper<>(SecondBean.class));
        if(list != null && list.size() > 0){
            return list.get(0);
        }
        return secondBean;
    }

    @Override
    public List<SecondBean> list() {
        return null;
    }
}
