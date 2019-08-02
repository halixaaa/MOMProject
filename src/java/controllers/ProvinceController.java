/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GenericDAO;
import icontrollers.IProvinceController;
import idaos.IGenericDAO;
import java.math.BigDecimal;
import java.util.List;
import models.Province;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author HARRY-PC
 */
public class ProvinceController implements IProvinceController{

    private IGenericDAO iGenericDAO;
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public ProvinceController(){
        iGenericDAO = new GenericDAO(Province.class, sessionFactory);
    }
    
    @Override
    public List<Province> getAll() {
        return iGenericDAO.getAll();
    }

    @Override
    public List<Province> getByName(String name) {
        return iGenericDAO.getByName(name);
    }

    @Override
    public Province getById(String id) {
        return (Province) iGenericDAO.getById(id);
    }

    @Override
    public String insert(String name) {
        String result = "";
        if(iGenericDAO.insert(new Province(name))){
            result = "Data berhasil disimpan";
        }else{
            result = "Maaf Data gagal disimpan";
        }
        return result;
    }

    @Override
    public String update(String id, String name) {
        String result = "";
        if(iGenericDAO.update(new Province(new BigDecimal(id), name))){
            result = "Data berhasil disimpan";
        }else{
            result = "Maaf Data gagal disimpan";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        if(iGenericDAO.delete(new Province(new BigDecimal(id)))){
            result = "Data berhasil dihapus";
        }else{
            result = "maaf data gagal dihapus";
        }
        return result;
    }
    
}