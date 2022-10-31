package com.atguigu.condition;

import com.atguigu.bean.Blue;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author linzihao
 * @create 2022-10-31-8:20
 */
//自定义逻辑返回需要导入的组件
public class MyImportSelector implements ImportSelector {

    //返回值就是要导入到容器的组件全类名
    //AnnotationMetadata：当前标注@Import注解的类的所有注解信息
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        //方法不要返回null值，否则会报空指针异常
        return new String[]{"com.atguigu.bean.Blue","com.atguigu.bean.Yellow"};

    }
}
