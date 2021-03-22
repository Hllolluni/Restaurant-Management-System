/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.util.List;
import BLL.Ushqimi;

public interface UshqimiInterface {
    void create(Ushqimi u) throws CrudFormException;
    void edit(Ushqimi u) throws CrudFormException;
    void delete(Ushqimi u) throws CrudFormException;
    List <Ushqimi> findAll() throws CrudFormException;
    Ushqimi findByID(Integer ID) throws CrudFormException;
}
