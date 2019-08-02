/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GenericDAO;
import icontrollers.IMomController;
import idaos.IGenericDAO;
import java.math.BigDecimal;
import java.util.List;
import models.Meeting;
import models.Mom;
import models.Status;
import org.hibernate.SessionFactory;
import tools.HibernateUtil;

/**
 *
 * @author Bella
 */
public class MomController implements IMomController{

    private IGenericDAO iGenericDAO;
    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    
    public MomController(){
        iGenericDAO = new GenericDAO(Mom.class, sessionFactory);
    }
    
    @Override
    public List<Mom> getAll() {
        return iGenericDAO.getAll();
    }

    @Override
    public Mom getById(String id) {
        return (Mom) iGenericDAO.getById(id);
    }

    @Override
    public String insert(String meetingdesc, String meeting, String status) {
        String result = "";
        Meeting newMeeting = new Meeting(new BigDecimal(meeting));
        Status newStatus = new Status(new BigDecimal(status));
        Mom mom = new Mom(meetingdesc, newMeeting, newStatus);
        if(iGenericDAO.insert(mom)){
            result = "Data berhasil disimpan";
        }else{
            result = "Maaf Data gagal disimpan";
        }
        return result;    
    }

    @Override
    public String update(String id, String meetingdesc, String meeting, String status) {
        String result = "";
        Meeting newMeeting = new Meeting(new BigDecimal(meeting));
        Status newStatus = new Status(new BigDecimal(status));
        Mom mom = new Mom(new BigDecimal(id), meetingdesc, newMeeting, newStatus);
        if(iGenericDAO.update(mom)){
            result = "Data berhasil disimpan";
        }else{
            result = "Maaf Data gagal disimpan";
        }
        return result;
    }
    
    @Override
    public String delete(String id) {
        String result = "";
        Mom mom = new Mom(new BigDecimal(id));
        if(iGenericDAO.delete(mom)){
            result = "Data berhasil dihapus";
        }else{
            result = "maaf data gagal dihapus";
        }
        return result;  
    }

}
