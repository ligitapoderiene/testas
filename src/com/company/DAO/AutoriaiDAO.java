package com.company.DAO;

import com.company.entity.Autoriai;
import com.company.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class AutoriaiDAO {


    public AutoriaiDAO() {

    }

    public void insert(Autoriai autoriai) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(autoriai);

        session.getTransaction().commit();
        System.out.println("Pavyko sekmingai iterpti nauja irasa.");
    }

    public Autoriai searchById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Autoriai autoriai = session.get(Autoriai.class, id);

        session.getTransaction().commit();
        System.out.println("Pavyko sekmingai atlikti paieska pagal ID.");

        return autoriai;
    }

    public void update(Autoriai autoriai) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(autoriai);

        session.getTransaction().commit();
        System.out.println("Pavyko sekmingai atnaujinti irasa.");
    }

    public void delete(Autoriai autoriai) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(autoriai);

        session.getTransaction().commit();
        System.out.println("Pavyko sekmingai pasalinti irasa.");
    }

    public void deleteById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Autoriai autoriai = session.get(Autoriai.class, id);
        if (autoriai != null) {
            session.delete(autoriai);
            System.out.println("Pavyko istrinti naudojant ID");
        }
        session.getTransaction().commit();

    }

    public List<Autoriai> searchByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Autoriai> autoriai = new ArrayList<>();
        Query q = session.createQuery("SELECT count(e) from Autoriai e where e.name like'" + name + "'");
        List l = q.list();
        //Long result[] = (Long[]) l.get(0);
        //Integer res = (Integer) result[0];
        System.out.println("Pagal count uzklausa Jonu skaicius: " + l.get(0));
       autoriai = session.createQuery("from Autoriai where e.name like '" + name + "'").getResultList();

        session.getTransaction().commit();
        System.out.println("Pavyko sekmingai atlikti paieska pagal varda.");

        return autoriai;
    }

    public List<Autoriai> printAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Autoriai> autoriai = new ArrayList<>();
        autoriai = session.createQuery("from Autoriai").getResultList();

        session.getTransaction().commit();
        System.out.println("Pavyko sekmingai atspausdinti visus irasus.");

        return autoriai;
    }

}
