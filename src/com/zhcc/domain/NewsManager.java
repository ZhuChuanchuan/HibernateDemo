package com.zhcc.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



/**
 * Create by ZHCC on 2018/9/20
 */

public class NewsManager {

    public static void main(String[] args) {
        //实例化Configuration
        Configuration conf=new Configuration().configure(); //不带参数默认加载hibernate.cfg.xml
        ServiceRegistry serviceRegistry=new ServiceRegistryBuilder().applySettings(conf.getProperties()).build();
        //以Configuration实例创建SessionFactory实例
        SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
        //创建session
        Session sess=sf.openSession();

        Transaction tx=sess.beginTransaction();
        News n=new News();
        n.setTitle("j2ee");
        n.setContent("crazy buddy");
        sess.save(n);
        tx.commit();
        sess.close();
        sf.close();
    }
}
