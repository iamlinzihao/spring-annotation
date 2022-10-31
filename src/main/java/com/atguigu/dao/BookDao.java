package com.atguigu.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

/**
 * @author linzihao
 * @create 2022-10-30-19:47
 */
//用注解+扫描的方法加载到容器里面的组件名字默认为类名首字母小写 bookDao
@Repository
public class BookDao {

    @Override
    public String toString() {
        return "BookDao{" +
                "label='" + label + '\'' +
                '}';
    }

    private String label = "1";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
