/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.Tavolina;
import java.util.List;


public interface TavolinaInterface {
    void create(Tavolina t) throws CrudFormException;
    void edit(Tavolina t) throws CrudFormException;
    void delete(Tavolina t) throws CrudFormException;
    List<Tavolina> findAll() throws CrudFormException;
    Tavolina findByID(Integer ID) throws CrudFormException;
}
