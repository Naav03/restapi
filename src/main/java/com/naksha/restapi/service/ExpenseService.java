package com.naksha.restapi.service;

import com.naksha.restapi.dto.ExpenseDTO;

import java.util.List;

public interface ExpenseService {

    List<ExpenseDTO> getAllExpenses();

}
