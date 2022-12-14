/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.fpt.it17326.nhom5.repository;

import com.fpt.it17326.nhom5.config.HibernateConfig;
import com.fpt.it17326.nhom5.domainmodel.ImeiDaBan;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author youngboizseetinh
 */
public class ImeiDaBanRepository {

    private Session session = HibernateConfig.getFACTORY().openSession();
    private String fromTable = "FROM ImeiDaBan";

    public List<ImeiDaBan> getAll() {
        Query query = session.createQuery(fromTable);
        return query.getResultList();
    }

    public ImeiDaBan getOne(String MaImei) {
        String sql = fromTable + " WHERE MaImei =: MaImei1";
        Query query = session.createQuery(sql);
        query.setParameter("MaImei1", MaImei);
        return (ImeiDaBan) query.getSingleResult();
    }

    public Boolean add(ImeiDaBan imeiDaBan) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(imeiDaBan);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean update(ImeiDaBan imeiDaBan) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(imeiDaBan);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean delete(ImeiDaBan imeiDaBan) {
        Transaction transaction = null;
        try (Session session = HibernateConfig.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            imeiDaBan.setDeleted(true);
            session.update(imeiDaBan);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    //Thang
}
