package net.javaguides.banking.controller;


import io.swagger.v3.oas.annotations.Operation;
import net.javaguides.banking.dto.AccountDto;
import net.javaguides.banking.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;


    // Add account REST API
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    // Get Accout REST API
    @GetMapping("/{id}")
     public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id){
        AccountDto accountDto =accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
     }

     // Deposit RestAPI
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable Long id,@RequestBody Map<String,Double>request){
        Double amount =request.get("amount");
        AccountDto accountDto=accountService.deposit(id,amount);
        return ResponseEntity.ok(accountDto);
    }

    //WithDraw RESTAPI
    @Operation(
            summary = "Withdraw amount from account",
            description = "Withdraws the specified amount from the account with given ID"
    )
    @PutMapping("/{id}/withdraw")
    public  ResponseEntity<AccountDto>withdraw(@PathVariable Long id,@RequestBody Map<String,Double>request){
        Double amount =request.get("amount");
        AccountDto accountDto=accountService.withdraw(id,amount);
        return ResponseEntity.ok(accountDto);
    }

    //GET All Accounts REST API
    @GetMapping
    public ResponseEntity<List<AccountDto>>getAllAccounts(){
        List<AccountDto> accounts =accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String>deleteAccount(@PathVariable  Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account deleted Successfully...");
    }
}
