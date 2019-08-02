/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;
import controllers.ProvinceController;
import controllers.RoleController;
import daos.GenericDAO;
import icontrollers.IProvinceController;
import icontrollers.IRoleController;
import idaos.IGenericDAO;
import java.sql.SQLException;
import models.Province;
import models.Role;
import models.Status;
import org.hibernate.SessionFactory;

/**
 *
 * @author Bella
 */
public class ManualTest {
    public static void main(String[] args) throws SQLException {  
//        IRegionDAO irdao = new RegionDAO();
/*        for (Region region : irdao.getAll()) {
            System.out.println(region.getRegionId()+" "+region.getRegionName());
            for (Country country : region.getCountryList()) {
                System.out.println(country.getCountryId());
                for (Location location : country.getLocationList()) {
                    System.out.println(location.getCity());
                    for (Department department : location.getDepartmentList()) {
                        System.out.println(department.getDepartmentName());
                        for (Employee employee : department.getEmployeeList()) {
                            System.out.println(employee.getFirstName());
                            System.out.println();
                        }System.out.println();
                    }System.out.println();
                }System.out.println();
            }System.out.println();
            
        } */
//        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
//        IGenericDAO<Status> igdao = new GenericDAO<>(Status.class, sessionFactory);
//        IRoleController irc = new RoleController();
        IProvinceController ipc = new ProvinceController();
//        System.out.println(ipc.insert("DKI Jakarta"));
        for (Province p : ipc.getAll()) {
            System.out.println(p.getId());
            System.out.println(p.getName());
        }
    }
} 
