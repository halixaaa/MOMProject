/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Province;

/**
 *
 * @author HARRY-PC
 */
public interface IProvinceController {
    public List<Province> getAll();
    public List<Province> getByName(String name);
    public Province getById(String id);
    public String insert(String name);
    public String update(String id, String name);
    public String delete(String id);
}
