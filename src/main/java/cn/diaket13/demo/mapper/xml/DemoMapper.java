package cn.diaket13.demo.mapper.xml;

import cn.diaket13.demo.entity.DemoDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangw
 */
public interface DemoMapper {
    /**
     * @param demoDO
     * @return
     */
    int save( DemoDO demoDO);

    /**
     * @param demoDO
     * @return
     */
    int update( DemoDO demoDO);

    /**
     * @param id
     * @return
     */
    int remove(@Param("id") int id);

    /**
     * @param id
     * @return
     */
    DemoDO getById(@Param("id") int id);

    /**
     * @param demoDO
     * @return
     */
    DemoDO getByInfo(DemoDO demoDO);

    /**
     * @return
     */
    List<DemoDO> list();
}
