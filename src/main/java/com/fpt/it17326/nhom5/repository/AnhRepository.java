package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.Anh;
import com.fpt.it17326.nhom5.response.AnhResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * AowVN_Nyaruko
 *
 */
public class AnhRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();

    private String fromTable = "FROM Anh";

    public List<Anh> getAll() {
        String sql = fromTable + " WHERE deleted = 0";
        Query query = session.createQuery(sql);
        return query.getResultList();
    }
    
    public List<Anh> getAllDeleted() {
        String sql = fromTable + " WHERE deleted = 1";
        Query query = session.createQuery(sql);
        return query.getResultList();
    }
    
    public Anh getOne(String MaAnh) {
        String sql = fromTable + " WHERE MaAnh =: MaAnh1";
        Query query = session.createQuery(sql);
        query.setParameter("MaAnh1", MaAnh);
        return (Anh) query.getSingleResult();
    }

    public Boolean add(Anh anh) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(anh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean update(Anh anh) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(anh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean delete(Anh anh) {
        Transaction transaction = null;
        try ( Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            anh.setDeleted(true);
            session.update(anh);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

//    public static void main(String[] args) throws ParseException {
//
//        Anh anh = new AnhRepository().getOne(1);
//        System.out.println(anh.toString());
//        Anh anh = new Anh();
//        anh.setUrlAnh("01062003");
//        anh.setCover(true);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//
//        anh.setCreatedAt(format.parse("2022-11-21"));
//
//        anh.setDeleted(false);
//
//        anh.setUpdatedAt(format.parse("2022-11-21"));
//
//        anh.setMaAnh("A001");
//        new AnhRepository().add(anh);
//
//        List<Anh> lst = new AnhRepository().getAll();
//        for (Anh x : lst) {
//            System.out.println(x.toString());
//        }
//    }
}