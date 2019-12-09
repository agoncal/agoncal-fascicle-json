package org.agoncal.fascicle.json.binding;

import javax.json.bind.annotation.JsonbNumberFormat;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Antonio Goncalves
 * http://www.antoniogoncalves.org
 * --
 */
// tag::adocSnippet[]
public class PurchaseOrder {

  private Integer id;
  private LocalDateTime creationDate;
  @JsonbNumberFormat("###,###.00")
  private BigDecimal totalWithoutTax;
  @JsonbNumberFormat("#0.00")
  private Long taxRate;
  private Double discountRate;
  @JsonbNumberFormat("###,###.00")
  private BigDecimal totalTax;

  // Constructors, getters, setters
  // tag::adocSkip[]

  public PurchaseOrder() {

  }

  public PurchaseOrder(Integer id, BigDecimal totalWithoutTax, Long taxRate, Double discountRate, BigDecimal totalTax) {
    this.id = id;
    this.totalWithoutTax = totalWithoutTax;
    this.taxRate = taxRate;
    this.discountRate = discountRate;
    this.totalTax = totalTax;
    this.creationDate = LocalDateTime.now();
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
  }

  public BigDecimal getTotalWithoutTax() {
    return totalWithoutTax;
  }

  public void setTotalWithoutTax(BigDecimal totalWithoutTax) {
    this.totalWithoutTax = totalWithoutTax;
  }

  public Long getTaxRate() {
    return taxRate;
  }

  public void setTaxRate(Long taxRate) {
    this.taxRate = taxRate;
  }

  public Double getDiscountRate() {
    return discountRate;
  }

  public void setDiscountRate(Double discountRate) {
    this.discountRate = discountRate;
  }

  public BigDecimal getTotalTax() {
    return totalTax;
  }

  public void setTotalTax(BigDecimal totalTax) {
    this.totalTax = totalTax;
  }

  // end::adocSkip[]
}
// end::adocSnippet[]
