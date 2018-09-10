/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import repo.transfers.Deposit;
import repo.transfers.Withdraw;

/**
 *
 * @author nazimelmardi
 */
@Stateless
public class TransferRepo implements Repository{
    
    @PersistenceContext (name = "test")
    private EntityManager entityManager;
    
    public TransferRepo(){
        
    }
   
    @Override
    public void createDeposit(Deposit deposit){
        entityManager.persist(deposit);
    }
    
    @Override
    public void createWithdraw(Withdraw withdraw){
        entityManager.persist(withdraw);
    }
    
    @Override
    public List<Deposit>listAllDeposits(){
        TypedQuery<Deposit>findAllDeposits = entityManager.createQuery("SELECT d FROM Deposit d", Deposit.class);
        return findAllDeposits.getResultList();
    }
    
    @Override
    public List<Withdraw>listAllWithdraw(){
        TypedQuery<Withdraw>findAllWithdraws = entityManager.createQuery("SELECT w FROM Withdraw w", Withdraw.class);
        return findAllWithdraws.getResultList();
    }
    
    @Override
    public List<Withdraw>listWithdrawByDate(String date){
        TypedQuery<Withdraw>findAllWithdrawsByDate = entityManager.createQuery("SELECT w FROM Withdraw w WHERE e.date=:date", Withdraw.class);
        return findAllWithdrawsByDate.getResultList();
    }
    
    @Override
    public List<Deposit>listDepositByDate(String date){
        TypedQuery<Deposit>findAllDepositsByDate = entityManager.createQuery("SELECT w FROM Deposit w WHERE e.date=:date", Deposit.class);
         return findAllDepositsByDate.getResultList();
    }
    
    @Override
    public Double sumOfDeposits(){
        TypedQuery<Double>sumAllDeposits = entityManager.createQuery("SELECT SUM(d.money_amount) FROM Deposit d", Double.class);
        return sumAllDeposits.getSingleResult();
    }
    
    @Override
    public Double sumOfWithdaws(){
        TypedQuery<Double>sumAllWithdraw = entityManager.createQuery("SELECT SUM(w.money_amount) FROM Withdraw w", Double.class);
        return sumAllWithdraw.getSingleResult();
    }
    
}
