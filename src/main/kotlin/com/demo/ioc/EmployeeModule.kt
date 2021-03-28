package com.demo.ioc

import com.demo.service.EmployeeService
import get
import org.koin.dsl.module

val employeeModule = module {
    single<EmployeeService> { EmployeeService() }
}