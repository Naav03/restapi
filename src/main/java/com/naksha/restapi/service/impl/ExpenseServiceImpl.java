package com.naksha.restapi.service.impl;

import com.naksha.restapi.dto.ExpenseDTO;
import com.naksha.restapi.entity.ExpenseEntity;
import com.naksha.restapi.repository.ExpenseRepository;
import com.naksha.restapi.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.antlr.v4.runtime.tree.xpath.XPath.findAll;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;
    private ModelMapper modelMapper;

    @Override
    public List<ExpenseDTO> getAllExpenses() {
        //call the repository method
        List<ExpenseEntity> list = expenseRepository.findAll();
        // convert the entity obj to dto obj
        List<ExpenseDTO> listOfExpenses = list.stream().map(expenseEntity -> mapToExpenseDTO(expenseEntity)).collect(Collectors.toList());
        //return the list
        return listOfExpenses;
    }

    private ExpenseDTO mapToExpenseDTO(ExpenseEntity expenseEntity) {
        return modelMapper.map(expenseEntity, ExpenseDTO.class);
    }
}
