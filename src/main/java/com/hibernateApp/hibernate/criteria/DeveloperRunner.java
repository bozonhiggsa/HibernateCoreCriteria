package com.hibernateApp.hibernate.criteria;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Entry point
 * @author Ihor Savchenko
 * @version 1.0
 */
public class DeveloperRunner {

    private static SessionFactory sessionFactory;

    public static void main(String[] args) {

        sessionFactory = new Configuration().configure().buildSessionFactory();
        DeveloperRunner developerRunner = new DeveloperRunner();

        System.out.println("Adding developer's records to the database...");
        Integer developerId1 = developerRunner.addDeveloper("NetSite", "Developer", "Java Developer", 3, 2000);
        Integer developerId2 = developerRunner.addDeveloper("First", "Developer", "C++ Developer", 10, 2000);
        Integer developerId3 = developerRunner.addDeveloper("Second", "Developer", "C# Developer", 5, 2000);
        Integer developerId4 = developerRunner.addDeveloper("Third", "Developer", "PHP Developer", 1, 2000);
        Integer developerId5 = developerRunner.addDeveloper("Third", "Developer", "PHP Developer", 7, 3000);

        System.out.println("List of Developers with experience more than 3 years:");
        developerRunner.listDevelopersOverThreeYears();

        System.out.println("Total Salary of all Developers:");
        developerRunner.totalSalary();
        sessionFactory.close();
    }

    public Integer addDeveloper(String firstName, String lastName, String specialty, int experience, int salary) {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;
        Integer developerId = null;

        transaction = session.beginTransaction();
        Developer developer = new Developer(firstName, lastName, specialty, experience, salary);
        developerId = (Integer) session.save(developer);
        transaction.commit();
        session.close();
        return developerId;
    }

    public void listDevelopersOverThreeYears() {
        Session session = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(Developer.class);
        criteria.add(Restrictions.gt("experience", 3));
        criteria.add(Restrictions.ne("experience", 5));
        List<Developer> developers = criteria.list();

        for (Developer developer : developers) {
            System.out.println("=======================");
            System.out.println(developer);
            System.out.println("=======================");
        }
        transaction.commit();
        session.close();
    }

    public void totalSalary() {
        Session session  = this.sessionFactory.openSession();
        Transaction transaction = null;

        transaction = session.beginTransaction();
        Criteria criteria1 = session.createCriteria(Developer.class);
        Criteria criteria2 = session.createCriteria(Developer.class);
        criteria1.setProjection(Projections.sum("salary"));
        criteria2.setProjection(Projections.avg("salary"));

        List totalSalary = criteria1.list();
        List averageSalary = criteria2.list();
        System.out.println("Total salary of all developers: " + totalSalary.get(0));
        System.out.println("Average salary of all developers: " + averageSalary.get(0));
        transaction.commit();
        session.close();
    }


}
