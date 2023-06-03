package com.system.market.entities;

public record EmployeeResponseDTO(Long Id,String name,String email,Long cpf,String shift,Long phone) {
    public EmployeeResponseDTO(Employee employee) {
        this(employee.getId(),employee.getName(),employee.getEmail(),employee.getCpf(),employee.getShift(),employee.getPhone());
    }
}
