package DAL;


import BLL.Porosia;
import java.util.List;


public class PorosiaRepository extends EntMngClass implements PorosiaInterface {

    @Override
    public void create(Porosia p) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void edit(Porosia p) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.merge(p);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public void delete(Porosia p) throws CrudFormException {
        try{
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public List<Porosia> findAll() throws CrudFormException {
        try{
            return em.createNamedQuery("Porosia.findAll").getResultList();
        }catch(Exception e){
            throw new CrudFormException("Msg \n" + e.getMessage());
        }
    }

    @Override
    public Porosia findByID(Integer ID) throws CrudFormException {
        throw new UnsupportedOperationException("..."); //To change body of generated methods, choose Tools | Templates.
    }   
}