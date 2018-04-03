package cn.diaket13.demo.dao.jdbc;

import cn.diaket13.demo.configuation.SecondBean;

import java.util.List;

public interface JdbcDAO {
    int save(SecondBean secondBean);

    int update(SecondBean secondBean);

    int remove(int id);

    SecondBean getById(int id);

    SecondBean getByInfo(SecondBean secondBean);

    List<SecondBean> list();
}
