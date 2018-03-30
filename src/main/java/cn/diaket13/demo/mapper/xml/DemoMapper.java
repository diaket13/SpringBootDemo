package cn.diaket13.demo.mapper.xml;

import cn.diaket13.demo.entity.DemoDO;

import java.util.List;

/**
 * @author wangw
 */
public interface DemoMapper {
    int save(DemoDO demoDO);

    int update(DemoDO demoDO);

    int remove(int id);

    DemoDO getById(int id);

    DemoDO getByInfo(DemoDO demoDO);

    List<DemoDO> list();
}
