/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo;

import java.util.List;
import repo.transfers.Deposit;
import repo.transfers.Withdraw;

/**
 *
 * @author nazimelmardi
 */
public interface Repository {
    
    void createDeposit(Deposit deposit);
    
    void createWithdraw(Withdraw withdraw);  
    
    List<Deposit>listAllDeposits();
    
    List<Withdraw>listAllWithdraw();
    
    List<Withdraw>listWithdrawByDate(String date);
    
    List<Deposit>listDepositByDate(String date);
    
    Double sumOfDeposits();
    
    public Double sumOfWithdaws();
    
}
