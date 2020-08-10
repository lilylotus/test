package cn.nihility.starter;

import cn.nihility.aware.MyApplicationContextAware;
import cn.nihility.entity.DogWalk;
import cn.nihility.entity.PersonWalk;
import cn.nihility.entity.Walk;
import cn.nihility.registrar.RegistrarConfiguration;
import cn.nihility.registrar.User;
import cn.nihility.registrar.mapper.UserMapper01;
import cn.nihility.registrar.mapper.UserMapper02;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRegistryStart {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(RegistrarConfiguration.class);
        ctx.refresh();

        UserMapper01 mapper = ctx.getBean(UserMapper01.class);
        User user = mapper.selectUserById(1);
        System.out.println(user);

        /*Object myBean = ctx.getBean("&myFactoryBean");
        System.out.println(myBean);*/

        UserMapper02 userMapper02 = MyApplicationContextAware.getBean(UserMapper02.class);
        User user1 = userMapper02.selectUserById(1);
        System.out.println(user1);

        DogWalk dogWalk = MyApplicationContextAware.getBean(DogWalk.class);
        System.out.println(dogWalk);

        Walk walk = (Walk) MyApplicationContextAware.getBean("personWalkxxxx");
        walk.walk();

        walk = (Walk) MyApplicationContextAware.getBean("dogWalkxxxx");
        walk.walk();


        Walk walk1 = (Walk) MyApplicationContextAware.getBean("getWalk");
        walk1.walk();

        PersonWalk personWalkxxxx = MyApplicationContextAware.getBean("personWalkxxxx", PersonWalk.class);
        personWalkxxxx.walk();

        ctx.registerShutdownHook();
    }

}
