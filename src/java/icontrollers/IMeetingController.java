/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Meeting;

/**
 *
 * @author Bella
 */
public interface IMeetingController {
    public List<Meeting> getAll();
    public Meeting getById(String id);
    public List<Meeting> getByName(String name);
    public String insert(String name, String project, String dates, String time, String type, String customer, String manager, String pic);
    public String update(String id, String name, String project, String dates, String time, String type, String customer, String manager, String pic);
    public String delete(String id);
}
