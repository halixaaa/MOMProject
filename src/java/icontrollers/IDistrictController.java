/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.District;

/**
 *
 * @author HARRY-PC
 */
public interface IDistrictController {
    public List<District> getAll();
    public List<District> getByName(String name);
    public District getById(String id);
    public String insert(String name, String province);
    public String update(String id, String name, String province);
    public String delete(String id);
}
