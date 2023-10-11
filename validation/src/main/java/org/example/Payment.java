package org.example;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import org.example.group.CreditCardPaymentGroup;
import org.example.group.VirtualAccountPaymentGroup;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;

public class Payment {

    @CheckOrderID(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class})
    private String orderId;

    @NotNull(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, message = "amount can't null")
    @Range(groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class}, min = 50_000L, max = 2_000_000L, message = "amount must between {min} and {max}")
    private Long amount;

    @LuhnCheck(payload = {ErrorPayload.class}, groups = {CreditCardPaymentGroup.class}, message = "invalid credit card number")
    @NotBlank(groups = {CreditCardPaymentGroup.class}, message = "credit card can't blank")
    private String creditCard;

    @LuhnCheck(payload = {ErrorPayload.class}, groups = {VirtualAccountPaymentGroup.class}, message = "invalid virtual account number")
    @NotBlank(groups = {VirtualAccountPaymentGroup.class}, message = "virtual account can't blank")
    private String virtualAccount;

    @NotNull(message = "customer cannot null", groups = {CreditCardPaymentGroup.class, VirtualAccountPaymentGroup.class})
    @Valid
    @ConvertGroup(from = VirtualAccountPaymentGroup.class, to = Default.class)
    @ConvertGroup(from = CreditCardPaymentGroup.class, to = Default.class)
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", creditCard='" + creditCard + '\'' +
                ", virtualAccount='" + virtualAccount + '\'' +
                ", customer=" + customer +
                '}';
    }
}
