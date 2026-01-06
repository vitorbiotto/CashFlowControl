package com.example.CashFlowControl.model.enums;

public enum ExpenseType {
    LAZER("Lazer"),
    SAÚDE("Saúde"),
    ALIMENTAÇÃO("Alimentação"),
    CASA("Casa"),
    EDUCAÇÃO("Educação"),
    OUTROS("Outros");

    private String description;

    ExpenseType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
