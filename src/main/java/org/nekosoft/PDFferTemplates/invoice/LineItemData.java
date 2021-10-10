package org.nekosoft.PDFferTemplates.invoice;

/**
 * A VO for each line item in a PDF invoice.
 */
public class LineItemData {
    private String description;
    private int quantity;
    private String unitFormat;
    private double unitPrice;
    private String taxName;
    private double taxRate;

    /**
     * Gets the unit format. See {@link #setUnitFormat(String)}.
     *
     * @return the unit format
     */
    public String getUnitFormat() {
        return unitFormat;
    }

    /**
     * Sets the unit format. This will be used with the {@code String.format} method to display the quantity in the invoice.
     * It needs to include one format specifier for an integer value ({@code %d}), which will replaced with
     * the {@link #setQuantity(int) quantity}.
     *
     * @param unitFormat the unit format
     */
    public void setUnitFormat(String unitFormat) {
        this.unitFormat = unitFormat;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the quantity.
     *
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity. Also see {@link #setUnitFormat(String)}.
     *
     * @param quantity the quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the unit price.
     *
     * @return the unit price
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * Sets the unit price.
     *
     * @param unitPrice the unit price
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * Gets the tax name.
     *
     * @return the tax name
     */
    public String getTaxName() {
        return taxName;
    }

    /**
     * Sets the tax name.
     *
     * @param taxName the tax name
     */
    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    /**
     * Gets the tax rate.
     *
     * @return the tax rate
     */
    public double getTaxRate() {
        return taxRate;
    }

    /**
     * Sets the tax rate.
     *
     * @param taxRate the tax rate
     */
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * Calculates the item total.
     *
     * @return the item total
     */
    public double getItemTotal() {
        return unitPrice * quantity;
    }

    /**
     * Calculates the tax total.
     *
     * @return the tax total
     */
    public double getTaxTotal() {
        return unitPrice * quantity * taxRate;
    }
}
