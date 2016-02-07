package ynk.supports;

public class MathValue {

    private int currencyDecimals;
    private boolean zero;
    private boolean negative;
    private int intValue;
    private int decimalPosition;

    public void setCurrencyDecimals(int currencyDecimals) {
        this.currencyDecimals = currencyDecimals;
    }

    public int getCurrencyDecimals() {
        return currencyDecimals;
    }

    public void setZero(boolean zero) {
        this.zero = zero;
    }

    public boolean isZero() {
        return zero;
    }

    public void setNegative(boolean negative) {
        this.negative = negative;
    }

    public boolean isNegative() {
        return negative;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public void setDecimalPosition(int decimalPosition) {
        this.decimalPosition = decimalPosition;
    }

    public int getDecimalPosition() {
        return decimalPosition;
    }
}
