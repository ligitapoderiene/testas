package com.company.DAO;

import com.company.entity.Knygos;
import com.company.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class KnygosDAO {


    public KnygosDAO() {

    }

    public void insert(Knygos knygos) {
        // Norint atlikti uzklausa i DB reikia is sesiju gamyklos paprasyti sesijos.
        // Sesiju objektas yra lengvasvoris (lightweight).
        // Sesiju galima tureti neribota kieki per aplikacija.
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(knygos);

        session.getTransaction().commit();
        System.out.println("Sekmingai issaugojam nauja objekta.");
    }

    public void update(Knygos knygos) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.update(knygos);

        session.getTransaction().commit();
        System.out.println("Irasa pavyko sekmingai atnaujinti (pagal ID).");
    }

    public void delete(Knygos knygos) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(knygos);

        session.getTransaction().commit();
        System.out.println("Irasa pavyko sekmingai pasalinti.");

    }

    public void deleteById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Knygos knygos = session.get(Knygos.class, id);
        if (knygos != null) {
            session.delete(knygos);
            System.out.println("Pavyko istrinti naudojant ID");
        }
        session.getTransaction().commit();

    }

    public Knygos searchByID(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Knygos knygos = session.get(Knygos.class, id);

        session.getTransaction().commit();
        System.out.println("Pavyko atlikti paieska sekmingai pagal ID.");


        return knygos;
    }

    public List<Knygos> searchByName(String name) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        List<Knygos> knygos = new ArrayList<>();
        // Panaudosime hibernate query language (HQL). Naudojama su metodu create query.
        knygos = session.createQuery("from Knygos a where a.name like '" + name + "'").getResultList();

        session.getTransaction().commit();
        System.out.println("Pavyko sekmingai atlikti paieska pagal varda.");

        return knygos;
    }


}
