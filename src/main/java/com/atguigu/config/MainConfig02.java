package com.atguigu.config;

import com.atguigu.bean.Colour;
import com.atguigu.bean.ColourFactoryBean;
import com.atguigu.bean.Person;
import com.atguigu.bean.Red;
import com.atguigu.condition.LinuxCondition;
import com.atguigu.condition.MyImportBeanDefinitionRegistrar;
import com.atguigu.condition.MyImportSelector;
import com.atguigu.condition.WindowsCondition;
import org.springframework.context.annotation.*;

/**
 * @author linzihao
 * @create 2022-10-30-21:09
 */
//满足这个条件这个类中配置的bean注册才会生效，可以给类中的组件统一设置
@Conditional({WindowsCondition.class})
@Configuration
//Import导入组件，id默认是组件的全类名
@Import({Colour.class, Red.class, MyImportSelector.class, MyImportBeanDefinitionRegistrar.class})
public class MainConfig02 {

    /**
     * ioc容器里加的组件默认都是单实例的
     * @Scope:调整作用域
     * value属性：
     *      prototype:多实例的：ioc容器启动的时候不会调用方法创建对象放在容器中，每次获取的时候才会调用方法
     *      来创建对象
     *      singleton：单实例的（默认）：ioc容器启动的时候会调用方法创建对象放到ioc容器中，以后每次拿就是直接从
     *      容器中直接获取（map.get()）
     *
     * 懒加载：
     *      单实例bean：默认在容器启动时创建对象
     *      懒加载：容器启动的时候不创建对象，第一次获取Bean的时候才创建对象并初始化
     */
    // @Scope("prototype")
    @Lazy
    @Bean("person222")
    public Person person(){
        System.out.println("给容器中添加Person。。。");
        return new Person("张三", 25);
    }

    /**
     * @Conditional({Condition})：按照一定的条件进行判断，满足条件给容器注册Bean
     * 需求：
     *     如果是windows系统注册“Bill”
     *     如果是linux系统注册“linus”
     */
    @Conditional({WindowsCondition.class})
    @Bean("Bill")
    public Person person02(){
        return new Person("Bill Gates", 61);
    }
    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person03(){
        return new Person("linus", 50);
    }

    /**
     * 给容器中注册组件：
     * 1）包扫描+组件标注注解（@Controller/@Service/@Repository/@Component）【自己导入】
     * 2）@Bean【导入第三方包里的组件】
     * 3）@Import【快速给容器导入一个组件】
     *      1）@Import(要导入到容器里的组件)：容器会自动注册这个组件，id默认为全类名
     *      2)ImportSelector返回需要导入的组件的全类名数组
     *      3）ImportBeanDefinitionRegistrar：
     * 4)使用Spring提供的FactoryBean（工厂Bean
     *      1）用工厂bean的id获取到的是getobject创建的对象
     *      2）要获取工厂bean本身，我们需要给id前面加一个&：&colourFactoryBean
     */

    @Bean
    public ColourFactoryBean colourFactoryBean(){
        return new ColourFactoryBean();
    }

}
