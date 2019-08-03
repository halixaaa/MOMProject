/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GenericDAO;
import icontrollers.ISubdistrictController;
import idaos.IGenericDAO;
import java.math.BigDecimal;
import java.util.List;
import models.District;
import models.Subdistrict;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author HARRY-PC
 */
public class SubdistrictController implements ISubdistrictController{
    
    private IGenericDAO iGenericDAO;
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public SubdistrictController(){
        iGenericDAO = new GenericDAO(Subdistrict.class, sessionFactory);
    }

    @Override
    public List<Subdistrict> getAll() {
        return iGenericDAO.getAll();
    }

    @Override
    public List<Subdistrict> getByName(String name) {
        return iGenericDAO.getByName(name);
    }

    @Override
    public Subdistrict getById(String id) {
        return (Subdistrict) iGenericDAO.getById(id);
    }

    @Override
    public String insert(String name, String district) {
        String result = "";
        District dist = new District(new BigDecimal(district));
        Subdistrict subdistrict = new Subdistrict(name, dist);
        if(iGenericDAO.insert(subdistrict)){
            result = "Data berhasil disimpan";
        }else{
            result = "Maaf Data gagal disimpan";
        }
        return result;
    }

    @Override
    public String update(String id, String name, String district) {
        String result = "";
        if(iGenericDAO.update(new Subdistrict(new BigDecimal(id),name, new District(new BigDecimal(district))))){
            result = "Data berhasil disimpan";
        }else{
            result = "Maaf Data gagal disimpan";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        if(iGenericDAO.delete(new Subdistrict(new BigDecimal(id)))){
            result = "Data berhasil dihapus";
        }else{
            result = "maaf data gagal dihapus";
        }
        return result;
    }
    
}
