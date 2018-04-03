package cn.diaket13.demo.mapper.annotation;

import cn.diaket13.demo.entity.DemoDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AnotherDemoMapper {
    /**
     * @param demoDO
     * @return
     */
    @Insert("INSERT INTO DEMO (NAME, ATTACK, TYPE, DESCRIPTION) VALUES  (#{name}, #{attack}, #{type}, #{description})")
    int save( DemoDO demoDO);

    /**
     * @param demoDO
     * @return
     */
    @UpdateProvider(type = DemoSqlProvider.class,method = "updateSql")
    int update( DemoDO demoDO);

    /**
     * @param id
     * @return
     */
    @DeleteProvider(type = DemoSqlProvider.class,method = "removeSql" )
    int remove(@Param("id") int id);

    /**
     * @param id
     * @return
     */
    @SelectProvider(type = DemoSqlProvider.class,method = "getByIdSql")
    DemoDO getById(@Param("id") int id);

    /**
     * @param demoDO
     * @return
     */
    @SelectProvider(type = DemoSqlProvider.class,method = "getByInfoSql")
    DemoDO getByInfo(DemoDO demoDO);

    /**
     * @return
     */
    @SelectProvider(type = DemoSqlProvider.class,method = "list")
    List<DemoDO> list();


}
