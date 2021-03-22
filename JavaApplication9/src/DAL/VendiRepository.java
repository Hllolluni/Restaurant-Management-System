/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.util.List;
import BLL.Vendi;

public class VendiRepository extends EntMngClass implements VendiInterface {

    @Override
    public void create(Vendi v) throws CrudFormException {
       try{
           em.getTransaction().begin();
           em.persist(v);
           em.getTransaction().commit();
       }catch(Exception e){
           throw new CrudFormException("Msg \n" + e.getMessage());
       }
    }

    @Override
    public void edit(Vendi v) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.merge(v);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Vendi v) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.remove(v);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Vendi> findAll() throws CrudFormException {
        try{
            return em.createNamedQuery("Vendi.findAll").getResultList();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public Vendi findByID(Integer ID) throws CrudFormException {
        throw new UnsupportedOperationException("..."); //To change body of generated methods, choose Tools | Templates.
    }   
}