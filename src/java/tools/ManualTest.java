/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;
import controllers.DistrictController;
import controllers.ProvinceController;
import controllers.RoleController;
import controllers.SubdistrictController;
import daos.GenericDAO;
import icontrollers.IDistrictController;
import icontrollers.IProvinceController;
import icontrollers.IRoleController;
import icontrollers.ISubdistrictController;
import idaos.IGenericDAO;
import java.sql.SQLException;
import models.District;
import models.Province;
import models.Role;
import models.Status;
import models.Subdistrict;
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
        IRoleController irc = new RoleController();
        IProvinceController ipc = new ProvinceController();
        IDistrictController idc =  new DistrictController();
        ISubdistrictController isc = new SubdistrictController();
//        System.out.println(isc.insert("Grogol", "1"));
//        System.out.println(idc.update("1", "Jakarta Barat", "141"));
        for (Subdistrict s : isc.getAll()) {
            System.out.println(s.getId());
            System.out.println(s.getName());
            System.out.println(s.getDistrict().getName());
        }
    }
} 
