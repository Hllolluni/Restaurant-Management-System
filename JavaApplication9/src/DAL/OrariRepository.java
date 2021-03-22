package DAL;


import BLL.Orari;
import java.util.List;


public class OrariRepository extends EntMngClass implements OrariInterface {

    @Override
    public void create(Orari o) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.persist(o);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Orari o) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.merge(o);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Orari o) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.remove(o);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Orari> findAll() throws CrudFormException {
        try{
            return em.createNamedQuery("Orari.findAll").getResultList();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public Orari findByID(Integer ID) throws CrudFormException {
        throw new UnsupportedOperationException("..."); //To change body of generated methods, choose Tools | Templates.
    }   
}