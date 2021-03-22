/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.util.List;
import BLL.Vendi;

public interface VendiInterface {
    void create(Vendi v) throws CrudFormException;
    void edit(Vendi v) throws CrudFormException;
    void delete(Vendi v) throws CrudFormException;
    List <Vendi> findAll() throws CrudFormException;
    Vendi findByID(Integer ID) throws CrudFormException;
}
