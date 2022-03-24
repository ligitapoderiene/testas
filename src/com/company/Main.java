package com.company;

import com.company.DAO.KnygosDAO;
import com.company.DAO.AutoriaiDAO;
import com.company.entity.Knygos;
import com.company.entity.Autoriai;
import com.company.utils.HibernateUtil;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        AutoriaiDAO autoriaiDAO = new AutoriaiDAO();
        KnygosDAO knygosDAO = new KnygosDAO();

/*
        Autoriai autoriai = new Autoriai(6, "Paulius", "Paulenas");
        Autoriai autoriai1 = new Autoriai(7, "Pranas", "Pranenas");
        Knygos knygos = new Knygos(2016, 1, "Kazkada kazkas");
        Knygos knygos1 = new Knygos(2017, 6, "Kauno bokstai");

        //pridejimas
        knygosDAO.insert(knygos);
        autoriai.setKnygos(knygos);
        autoriaiDAO.insert(autoriai);
        autoriai.setKnygos(knygos);
        autoriaiDAO.insert(autoriai1);

        knygosDAO.insert(knygos);
        knygosDAO.insert(knygos1);


        //kad galetume priskirti autoriui knyga, pirmiau reikia ja susikurti
        //tada priskiriama
        autoriai.setKnygos(knygos);
        autoriai1.setKnygos(knygos1);

        //reikia issaugotis autorius su  priskirtom knygom
        autoriaiDAO.insert(autoriai);
        autoriaiDAO.insert(autoriai1);
/*

        // redagavimas

        Knygos knygos2 = new Knygos(8, 2021, 2, "Kam skambina");
        Autoriai autoriai2 = new Autoriai(1, 8, "Kipras", "Kriptenas");

        knygosDAO.update(knygos1);
        autoriai2.setKnygos(knygos1);
        autoriaiDAO.update(autoriai2);

        //salinimas knygos

     autoriai1.setKnygos(knygos);
      knygosDAO.deleteById(11);

        Knygos knygos3 = knygosDAO.searchByID(12);
       System.out.println(knygos3);
      System.out.println(knygos3.getAutoriai());

        List<Autoriai> autoriai3 = autoriaiDAO.searchByName("Kipras");
        System.out.println(autoriai3);

       for (Autoriai em : autoriai3) {
          System.out.println(em.getKnygos());
      }
      */


       List<Knygos> knygos4= knygosDAO.searchByName("Drugelio namai");

       for (Knygos em: knygos4) {
           System.out.println(knygos4);

       }
       /*

        autoriaiDAO.deleteById(10);
*/

        HibernateUtil.getSessionFactory().close();
    }
}
