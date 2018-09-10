/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.List;
import repo.transfers.Deposit;
import repo.transfers.Withdraw;

/**
 *
 * @author nazimelmardi
 */
public interface TransferLogic {
    
    List<Deposit> getAllDeposits();
    
    List<Withdraw> getAllWithdraws();
    
    List<Deposit> getAllDepositsByDate(String date);

    List<Withdraw> getAllWithdrawsByDate(String date);
  
    void saveDeposit(Deposit deposit);
    
    void saveWithdraw(Withdraw withdraw);
    
    Double balanceOfMoney();
    
}
