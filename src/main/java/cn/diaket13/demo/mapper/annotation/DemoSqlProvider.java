package cn.diaket13.demo.mapper.annotation;

import cn.diaket13.demo.entity.DemoDO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class DemoSqlProvider {
    private final String selectSql = "ID, NAME, ATTACK, TYPE, DESCRIPTION";

    public String updateSql(DemoDO demoDO) {
        return new SQL() {{
            UPDATE("DEMO");
            if (demoDO.getName() != null) {
                SET("NAME = #{name}");
            }
            if (demoDO.getAttack() != null) {
                SET("ATTACK = #{attack}");
            }
            if (demoDO.getType() != null) {
                SET("TYPE = #{type}");
            }
            if (demoDO.getDescription() != null) {
                SET("DESCRIPTION = #{description}");
            }
            WHERE("ID = #{id}");
        }}.toString();
    }

    public String removeSql(@Param("id") Integer id) {
        return new SQL() {{
            DELETE_FROM("DEMO");
            WHERE("ID = #{id}");
        }}.toString();
    }

    public String getByIdSql() {
        return new SQL() {{
            SELECT(selectSql);
            FROM("DEMO");
            WHERE("ID = #{id}");
        }}.toString();
    }

    public String getByInfoSql(DemoDO demoDO){
        return new SQL(){{
            SELECT(selectSql);
            FROM("DEMO");
            if (demoDO.getName() != null) {
                WHERE("NAME = #{name}");
            }
            if (demoDO.getAttack() != null) {
                WHERE("ATTACK = #{attack}");
            }
            if (demoDO.getType() != null) {
                WHERE("TYPE = #{type}");
            }
        }}.toString();
    }

    public String list(){
        return new SQL(){{
            SELECT(selectSql);
            FROM("DEMO");
        }}.toString();
    }
}
