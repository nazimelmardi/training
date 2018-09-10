/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repo.transfers;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author nazimelmardi
 */
@Entity
@Table(name="transfers")
public class Withdraw implements Serializable{
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @NotNull
    @Column(name = "transfer_number")
    private Long trans_numb;
    @NotNull
    @Column (name = "transfer_date")
    private String date;
    @NotNull
    @Column (name = "account_number")
    private Long account_number;
    @NotNull
    @Column (name = "amount_of_money")
    private Double money_amount;
    
}
