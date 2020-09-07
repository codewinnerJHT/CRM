import com.gxa.mapper.AdminMapper;
import com.gxa.mapper.CourseMapper;
import com.gxa.mapper.MarketPlanMapper;
import com.gxa.pojo.Admin;
import com.gxa.pojo.MarketPlan;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author:IT-CNLM
 * @date:Created at 2020/08/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-dao-config.xml")
public class MybatisTest {


    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private MarketPlanMapper marketPlanMapper;


    @Test
    public void test01(){
        List<Admin> all = adminMapper.findAll();
        System.out.println(all);
    }

    @Test
    public void test02(){
        String[] ids={"6","5"};
        courseMapper.deleteCourseIds(ids);
    }

//    @Test
//    public void test03(){
//        List<MarketPlan> marketPlans = marketPlanMapper.findAll();
//        for (MarketPlan m:marketPlans) {
//            System.out.println("**********"+m.getClassRoom());
//            System.out.println("----------"+m.getCourse());
//            System.out.println("&&&&&&&&&&&"+m);
//
//        }
//
//    }






}
