package org.nekosoft.PDFferTemplates.invoice;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A VO with all the data needed to create a PDF invoice with the NekoSoft PDF Invoice template.
 * <p>
 * Line item data is represented by the {@link LineItemData} class, with one instance per invoice item.
 */
public class InvoiceData {
    private String invoiceNo;
    private LocalDate invoiceDate;
    private LocalDate dueDate;
    private String client;
    private String sender;
    private String clientAddress;
    private String senderAddress;
    private String clientEmail;
    private String senderEmail;
    private String clientTaxCode;
    private String senderTaxCode;
    private String currency;
    private List<LineItemData> lineItems;
    private String footer1;
    private String footer2;
    private String bankDetails;

    /**
     * Gets the invoice number.
     *
     * @return the invoice number
     */
    public String getInvoiceNo() {
        return invoiceNo;
    }

    /**
     * Sets the invoice number.
     *
     * @param invoiceNo the invoice number
     */
    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    /**
     * Gets the invoice date.
     *
     * @return the invoice date
     */
    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    /**
     * Sets the invoice date.
     *
     * @param invoiceDate the invoice date
     */
    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    /**
     * Gets the due date of the invoice.
     *
     * @return the due date
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Sets the due date of the invoice.
     *
     * @param dueDate the due date
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Gets the client name.
     *
     * @return the client name
     */
    public String getClient() {
        return client;
    }

    /**
     * Sets the client name.
     *
     * @param client the client name
     */
    public void setClient(String client) {
        this.client = client;
    }

    /**
     * Gets the sender's name.
     *
     * @return the sender's name
     */
    public String getSender() {
        return sender;
    }

    /**
     * Sets the sender's name.
     *
     * @param sender the sender's name
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * Gets the client's address.
     *
     * @return the client's address
     */
    public String getClientAddress() {
        return clientAddress;
    }

    /**
     * Sets the client's address.
     *
     * @param clientAddress the client's address
     */
    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    /**
     * Gets the sender's address.
     *
     * @return the sender's address
     */
    public String getSenderAddress() {
        return senderAddress;
    }

    /**
     * Sets the sender's address.
     *
     * @param senderAddress the sender's address
     */
    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    /**
     * Gets the client's email.
     *
     * @return the client's email
     */
    public String getClientEmail() {
        return clientEmail;
    }

    /**
     * Sets the client's email.
     *
     * @param clientEmail the client's email
     */
    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    /**
     * Gets the sender's email.
     *
     * @return the sender's email
     */
    public String getSenderEmail() {
        return senderEmail;
    }

    /**
     * Sets the sender's email.
     *
     * @param senderEmail the sender's email
     */
    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    /**
     * Gets the client's tax code.
     *
     * @return the client's tax code
     */
    public String getClientTaxCode() {
        return clientTaxCode;
    }

    /**
     * Sets the client's tax code.
     *
     * @param clientTaxCode the client's tax code
     */
    public void setClientTaxCode(String clientTaxCode) {
        this.clientTaxCode = clientTaxCode;
    }

    /**
     * Gets the sender's tax code.
     *
     * @return the sender's tax code
     */
    public String getSenderTaxCode() {
        return senderTaxCode;
    }

    /**
     * Sets the sender's tax code.
     *
     * @param senderTaxCode the sender's tax code
     */
    public void setSenderTaxCode(String senderTaxCode) {
        this.senderTaxCode = senderTaxCode;
    }

    /**
     * Gets the invoice currency.
     *
     * @return the invoice currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the invoice currency.
     *
     * @param currency the invoice currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Gets the line items.
     *
     * @return the line items
     */
    public List<LineItemData> getLineItems() {
        return lineItems;
    }

    /**
     * Sets the line items.
     *
     * @param lineItems the line items
     */
    public void setLineItems(List<LineItemData> lineItems) {
        this.lineItems = lineItems;
    }

    /**
     * Gets the first line of the footer.
     *
     * @return the first line of the footer
     */
    public String getFooter1() {
        return footer1;
    }

    /**
     * Sets the first line of the footer.
     *
     * @param footer1 the first line of the footer
     */
    public void setFooter1(String footer1) {
        this.footer1 = footer1;
    }

    /**
     * Gets the second line of the footer.
     *
     * @return the second line of the footer
     */
    public String getFooter2() {
        return footer2;
    }

    /**
     * Sets the second line of the footer.
     *
     * @param footer2 the second line of the footer
     */
    public void setFooter2(String footer2) {
        this.footer2 = footer2;
    }

    /**
     * Gets the bank details.
     *
     * @return the bank details
     */
    public String getBankDetails() {
        return bankDetails;
    }

    /**
     * Sets the bank details.
     *
     * @param bankDetails the bank details
     */
    public void setBankDetails(String bankDetails) {
        this.bankDetails = bankDetails;
    }

    /**
     * Calculates the subtotal of the invoice.
     *
     * @return the subtotal
     */
    public double getSubtotal() {
        return lineItems.stream().mapToDouble(LineItemData::getItemTotal).sum();
    }

    /**
     * Calculates the tax subtotals for each line item tax type.
     *
     * @return the tax subtotals
     */
    public Map<String, Double> getTaxSubtotals() {
        Map<String, Double> totals = new HashMap<>(lineItems.size());
        for (LineItemData item : lineItems) {
            totals.put(item.getTaxName(), totals.getOrDefault(item.getTaxName(), 0.0) + item.getTaxTotal());
        }
        return totals;
    }

    /**
     * Calculates the total of the invoice.
     *
     * @return the total
     */
    public double getTotal() {
        return getSubtotal() + lineItems.stream().mapToDouble(LineItemData::getTaxTotal).sum();
    }
}
