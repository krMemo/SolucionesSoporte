package ynk.supports;

import java.util.Date;

public class FieldMobile extends Field {
    //Field level representation of the MathValue at this level for ADF use only, not part of JSON.
    private int currencyDecimals;
    private boolean zero;
    private boolean negative;
    private int intValue;
    private int decimalPosition;
    
    public FieldMobile() {
        super();
    }

    public void setCurrencyDecimals(int currencyDecimals) {
        this.currencyDecimals = currencyDecimals;
        this.getMathValue().setCurrencyDecimals(currencyDecimals);
    }

    public int getCurrencyDecimals() {
        return this.getMathValue().getCurrencyDecimals();
    }

    public void setZero(boolean zero) {
        this.zero = zero;
        this.getMathValue().setZero(zero);
    }

    public boolean isZero() {
        return this.getMathValue().isZero();
    }

    public void setNegative(boolean negative) {
        this.negative = negative;
        this.getMathValue().setNegative(negative);
    }

    public boolean isNegative() {
        return this.getMathValue().isNegative();
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
        this.getMathValue().setIntValue(intValue);
    }

    public int getIntValue() {
        return this.getMathValue().getIntValue();
    }

    public void setDecimalPosition(int decimalPosition) {
        this.decimalPosition = decimalPosition;
        this.getMathValue().setDecimalPosition(decimalPosition);
    }

    public int getDecimalPosition() {
        return this.getMathValue().getDecimalPosition();
    }
}
