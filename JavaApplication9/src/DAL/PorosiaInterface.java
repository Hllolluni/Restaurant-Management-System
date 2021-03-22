/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Porosia;
import java.util.List;


public interface PorosiaInterface {
    void create(Porosia p) throws CrudFormException;
    void edit(Porosia p) throws CrudFormException;
    void delete(Porosia p) throws CrudFormException;
    List<Porosia> findAll() throws CrudFormException;
    Porosia findByID(Integer ID) throws CrudFormException;
}
