/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Subdistrict;

/**
 *
 * @author HARRY-PC
 */
public interface ISubdistrictController {
    public List<Subdistrict> getAll();
    public List<Subdistrict> getByName(String name);
    public Subdistrict getById(String id);
    public String insert(String name, String district);
    public String update(String id, String name, String district);
    public String delete(String id);
}
