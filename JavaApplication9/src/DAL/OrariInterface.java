/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Orari;
import java.util.List;


public interface OrariInterface {
    void create(Orari o) throws CrudFormException;
    void edit(Orari o) throws CrudFormException;
    void delete(Orari o) throws CrudFormException;
    List<Orari> findAll() throws CrudFormException;
    Orari findByID(Integer ID) throws CrudFormException;
}
