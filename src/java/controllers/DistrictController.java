/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GenericDAO;
import icontrollers.IDistrictController;
import idaos.IGenericDAO;
import java.math.BigDecimal;
import java.util.List;
import models.District;
import models.Province;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author HARRY-PC
 */
public class DistrictController implements IDistrictController{

    private IGenericDAO iGenericDAO;
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public DistrictController(){
        iGenericDAO = new GenericDAO(District.class, sessionFactory);
    }
    
    @Override
    public List<District> getAll() {
        return iGenericDAO.getAll();
    }

    @Override
    public List<District> getByName(String name) {
        return iGenericDAO.getByName(name);
    }

    @Override
    public District getById(String id) {
        return (District) iGenericDAO.getById(id);
    }

    @Override
    public String insert(String name, String province) {
        String result = "";
        if(iGenericDAO.insert(new District(name, new Province(new BigDecimal(province))))){
            result = "Data berhasil disimpan";
        }else{
            result = "Maaf Data gagal disimpan";
        }
        return result;
    }

    @Override
    public String update(String id, String name, String province) {
        String result = "";
        if(iGenericDAO.update(new District(new BigDecimal(id), name, new Province(new BigDecimal(province))))){
            result = "Data berhasil disimpan";
        }else{
            result = "Maaf Data gagal disimpan";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        if(iGenericDAO.delete(new District(new BigDecimal(id)))){
            result = "Data berhasil dihapus";
        }else{
            result = "maaf data gagal dihapus";
        }
        return result;
    }
}
