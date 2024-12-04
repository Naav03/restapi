package com.naksha.restapi.controller;

import com.naksha.restapi.dto.ExpenseDTO;
import com.naksha.restapi.io.ExpenseResponse;
import com.naksha.restapi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@RestController
@RequiredArgsConstructor
public class Controller {

    private  ExpenseService expenseService;
    private  ModelMapper modelMapper;


    @GetMapping("/expenses")
    public List<ExpenseResponse> getExpenses(){
        //Call the service method
        List<ExpenseDTO> list = expenseService.getAllExpenses();
        //Convert the Expense DTO to Expense Response
        List<ExpenseResponse> response = list.stream().map(expenseDTO -> mapToExpenseResponse(expenseDTO)).collect(Collectors.toList());
        //return the list
        return response;
    }

    private ExpenseResponse mapToExpenseResponse(ExpenseDTO expenseDTO) {
      return  modelMapper.map(expenseDTO, ExpenseResponse.class);
    }
}
