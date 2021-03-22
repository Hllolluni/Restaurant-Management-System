/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.util.List;
import BLL.Ushqimi;

public class UshqimiRepository extends EntMngClass implements UshqimiInterface {

    @Override
    public void create(Ushqimi u) throws CrudFormException {
       try{
           em.getTransaction().begin();
           em.persist(u);
           em.getTransaction().commit();
       }catch(Exception e){
           throw new CrudFormException("Msg \n" + e.getMessage());
       }
    }

    @Override
    public void edit(Ushqimi u) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.merge(u);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Ushqimi u) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.remove(u);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Ushqimi> findAll() throws CrudFormException {
        try{
            return em.createNamedQuery("Ushqimi.findAll").getResultList();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public Ushqimi findByID(Integer ID) throws CrudFormException {
        throw new UnsupportedOperationException("..."); //To change body of generated methods, choose Tools | Templates.
    }   
}