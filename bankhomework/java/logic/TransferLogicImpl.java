/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import repo.Repository;
import repo.transfers.Deposit;
import repo.transfers.Withdraw;

/**
 *
 * @author nazimelmardi
 */
@Stateless
public class TransferLogicImpl implements TransferLogic{
    
        
    private Repository repository;
    
    public TransferLogicImpl() {
    }
    
    @Inject
    public TransferLogicImpl(Repository repository){
        this.repository = repository;
    }

    @Override
    public List<Deposit> getAllDeposits() {
        return repository.listAllDeposits();
    }

    @Override
    public List<Withdraw> getAllWithdraws() {
        return repository.listAllWithdraw();
    }

    @Override
    public List<Deposit> getAllDepositsByDate(String date) {
        return repository.listDepositByDate(date);
    }

    @Override
    public List<Withdraw> getAllWithdrawsByDate(String date) {
        return repository.listWithdrawByDate(date);
    }

    @Override
    public void saveDeposit(Deposit deposit) {
        this.repository.createDeposit(deposit);
    }

    @Override
    public void saveWithdraw(Withdraw withdraw) {
        this.repository.createWithdraw(withdraw);
    }

    @Override
    public Double balanceOfMoney() {
        return repository.sumOfDeposits() - repository.sumOfWithdaws();
    }
    
}
