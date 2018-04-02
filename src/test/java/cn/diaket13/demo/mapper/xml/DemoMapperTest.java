package cn.diaket13.demo.mapper.xml;

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
public class DemoMapperTest {
    @Autowired
    private DemoMapper demoMapper;

    @Test
    public void test(){
        DemoDO demoDO = new DemoDO();
        demoDO.setName("折凳");
        demoDO.setAttack(7);
        demoDO.setType(DemoTypeEnum.WEAPON);
        demoDO.setDescription("街头九众之一");
        demoMapper.save(demoDO);
        demoDO.setName("台球杆");
        demoDO.setAttack(2);
        demoMapper.save(demoDO);

        Assert.assertEquals((long)3,(long)demoMapper.getByInfo(demoDO).getAttack());

    }
    @Test
    public void test2(){
        System.out.println(demoMapper.getById(1).getDescription());
        Assert.assertEquals((long)1,(long)demoMapper.getById(1).getAttack());

    }
    @Test
    public void test3(){
        System.out.println(demoMapper.getById(1).getDescription());
        Assert.assertEquals((long)1,(long)demoMapper.getById(1).getAttack());

    }

}