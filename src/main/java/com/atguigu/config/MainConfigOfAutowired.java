package com.atguigu.config;

import com.atguigu.bean.Car;
import com.atguigu.bean.Colour;
import com.atguigu.dao.BookDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * 自动装配；
 *      Spring利用依赖注入（DI），完成对IOC容器中各个组件的依赖关系赋值；
 *
 *1) @Autowired：自动注入
 *              1）默认优先按照类型去容器中找对应的组件：ApplicationContext.getBean(BookDao.class)；
 *              2) 如果找到多个相同类型的组件，再将属性的名称作为组件id去容器里面查找：ApplicationContext.getBean("bookDao")；
 *              3)@Qualifier("bookDao")；使用@Qualifier指定需要装配的组件的id，而不是使用属性名
 *              4）自动装配默认一定要将属性赋值好，没有就会报错
 *                  可以使用@Autowired(required = false)
 *              5）@Primary：让Spring进行自动装配的时候，默认使用首选的Bean，这个时候如果有@Qualifier则以Qualifier为准
 *              BookService{
 *                  @Autowired
 *                  BookDao bookDao;
 *              }
 *2）Spring还支持@Resource（JSR250）和@Inject（JSR330）【java规范的注解】
 *          @Resource:
 *                  可以和@Autowired一样实现自动装配，默认是按照属性名进行装配
 *                  没有@Primary功能，不支持@Autowired（required=false）
 *          @Inject:
 *                  需要导入javax.inject的包，功能和Autowired一样，唯一不同是@Inject中没有required=false功能
 *
 *对比：@Autowired是Spring的注解，@Resource@Inject都是java规范的
 *
 * 3）@Autowired：可以用在构造器，参数，方法，属性
 *      1）标注在方法位置：@Bean+参数；参数从容器中获取，@Autowired默认不写，都能自动装配
 *      2）标注在构造器：如果组件只有一个构造器，这个有参构造器的@Autowired可以省略，参数位置的组件还是可以从容器中获取
 *      3）放在参数位置
 *
 *4）自定义组件想要使用Spring容器底层的一些组件，（ApplicationContext，BeanFactory，xxx）：
 *      自定义组件实现xxxAware；在创建对象的时候，会调用接口规定的方法（回调方法）注入相关组件；
 *      xxxAware：功能使用xxxprocessor实现
 *          ApplicationContextAware===>ApplicationContextAwareProcessor
 *         处理过程：对象初始化完毕后调用Processor的after...方法，如果对象实现了xxx接口就会把组件传进来
 *
 * @author linzihao
 * @create 2022-10-31-15:31
 */
@ComponentScan({"com.atguigu.controller","com.atguigu.dao","com.atguigu.service","com.atguigu.bean"})
@Configuration
public class MainConfigOfAutowired {

    @Primary
    @Bean("bookDao2")
    public BookDao bookDao(){
        BookDao bookDao = new BookDao();
        bookDao.setLabel("2");
        return bookDao;
    }

    @Bean
    public Colour colour(Car car){
        Colour colour = new Colour();
        colour.setCar(car);
        return colour;
    }

}
