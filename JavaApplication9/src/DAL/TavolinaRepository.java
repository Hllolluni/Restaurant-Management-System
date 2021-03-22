package DAL;


import BLL.Tavolina;
import java.util.List;


public class TavolinaRepository extends EntMngClass implements TavolinaInterface {

    @Override
    public void create(Tavolina t) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.persist(t);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Tavolina t) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.merge(t);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Tavolina t) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.remove(t);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Tavolina> findAll() throws CrudFormException {
        try{
            return em.createNamedQuery("Tavolina.findAll").getResultList();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public Tavolina findByID(Integer ID) throws CrudFormException {
        throw new UnsupportedOperationException("..."); //To change body of generated methods, choose Tools | Templates.
    }   
}