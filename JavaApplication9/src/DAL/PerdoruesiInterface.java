/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Perdoruesi;
import java.util.List;

public interface PerdoruesiInterface {
    void create(Perdoruesi p) throws CrudFormException;
    void edit(Perdoruesi p) throws CrudFormException;
    void delete(Perdoruesi p) throws CrudFormException;
    List<Perdoruesi> findAll() throws CrudFormException;
    Perdoruesi findByID(Integer ID) throws CrudFormException;
    Perdoruesi loginByUsernameAndPassword(String u, String p) throws CrudFormException;
}
