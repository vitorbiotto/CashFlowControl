package com.example.CashFlowControl.model.enums;

public enum IncomeType {
    PRESENTE("Presente"),
    SALÁRIO("Salário"),
    JUROS("Juros"),
    OUTROS("outros");

    private String description;

    IncomeType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
