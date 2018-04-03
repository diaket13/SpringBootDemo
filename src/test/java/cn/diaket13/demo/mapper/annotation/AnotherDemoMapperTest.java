package cn.diaket13.demo.mapper.annotation;

import cn.diaket13.demo.entity.DemoDO;
import cn.diaket13.demo.enums.DemoTypeEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AnotherDemoMapperTest {
    @Autowired
    private AnotherDemoMapper demoMapper;

    @Test
    public void save() throws Exception {
        DemoDO demoDO = new DemoDO();
        demoDO.setName("折凳");
        demoDO.setAttack(17);
        demoDO.setType(DemoTypeEnum.WEAPON);
        demoDO.setDescription("七把武器之首(民间)");
        demoMapper.save(demoDO);
        demoDO.setName("猪肉刀");
        demoDO.setAttack(13);
        demoDO.setDescription("七把武器之二(民间)");
        demoMapper.save(demoDO);
        Assert.assertEquals((long)13,(long)demoMapper.getByInfo(demoDO).getAttack());
        int i = demoMapper.list().size();
        demoMapper.remove(demoMapper.getByInfo(demoDO).getId());
        Assert.assertEquals(i-1,demoMapper.list().size());
    }

    @Test
    public void update() throws Exception {
        DemoDO demoDO = demoMapper.getById(4);
        DemoDO demoDO1 = new DemoDO();
        demoDO1.setName("猪肉刀1");
        demoDO1.setId(demoDO.getId());
        demoMapper.update(demoDO1);
        Assert.assertEquals("猪肉刀1",demoMapper.getById(4).getName());
        demoDO1.setName(demoDO.getName());
        demoMapper.update(demoDO1);
    }

    @Test
    public void remove() throws Exception {
        DemoDO demoDO = new DemoDO();
        demoDO.setName("要被删除的");

    }

    @Test
    public void get() throws Exception {
    }

    @Test
    public void list() throws Exception {
    }

}