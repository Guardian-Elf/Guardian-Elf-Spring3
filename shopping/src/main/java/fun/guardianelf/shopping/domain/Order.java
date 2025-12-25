package fun.guardianelf.shopping.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单对象 order
 * 
 * @author pc
 * @date 2025-12-25
 */
public class Order extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单号（唯一） */
    private String id;

    /** 用户ID */
    @Excel(name = "用户ID")
    private String userId;

    /** 地址ID */
    @Excel(name = "地址ID")
    private String addressId;

    /** 商品ID */
    @Excel(name = "商品ID")
    private String productId;

    /** 价格 */
    @Excel(name = "价格")
    private BigDecimal price;

    /** 购买数量 */
    @Excel(name = "购买数量")
    private String quantity;

    /** 订单总金额 */
    @Excel(name = "订单总金额")
    private BigDecimal totalAmount;

    /** 运费 */
    @Excel(name = "运费")
    private BigDecimal shippingFee;

    /** 实付金额 */
    @Excel(name = "实付金额")
    private BigDecimal payAmount;

    /** 订单状态(0:待付款 1:待发货 2:已发货 3:已完成 4:已取消) */
    @Excel(name = "订单状态(0:待付款 1:待发货 2:已发货 3:已完成 4:已取消)")
    private Integer orderStatus;

    /** 支付方式 */
    @Excel(name = "支付方式")
    private String paymentMethod;

    /** 支付时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "支付时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date paymentTime;

    /** 发货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date shippingTime;

    /** 收货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "收货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date receiveTime;

    /** 取消时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "取消时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date cancelTime;

    /** 用户备注 */
    @Excel(name = "用户备注")
    private String userNote;

    /** 是否需要发票(0:否 1:是) */
    @Excel(name = "是否需要发票(0:否 1:是)")
    private Integer invoiceNeeded;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createdAt;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date updatedAt;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }

    public void setUserId(String userId) 
    {
        this.userId = userId;
    }

    public String getUserId() 
    {
        return userId;
    }

    public void setAddressId(String addressId) 
    {
        this.addressId = addressId;
    }

    public String getAddressId() 
    {
        return addressId;
    }

    public void setProductId(String productId) 
    {
        this.productId = productId;
    }

    public String getProductId() 
    {
        return productId;
    }

    public void setPrice(BigDecimal price) 
    {
        this.price = price;
    }

    public BigDecimal getPrice() 
    {
        return price;
    }

    public void setQuantity(String quantity) 
    {
        this.quantity = quantity;
    }

    public String getQuantity() 
    {
        return quantity;
    }

    public void setTotalAmount(BigDecimal totalAmount) 
    {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalAmount() 
    {
        return totalAmount;
    }

    public void setShippingFee(BigDecimal shippingFee) 
    {
        this.shippingFee = shippingFee;
    }

    public BigDecimal getShippingFee() 
    {
        return shippingFee;
    }

    public void setPayAmount(BigDecimal payAmount) 
    {
        this.payAmount = payAmount;
    }

    public BigDecimal getPayAmount() 
    {
        return payAmount;
    }

    public void setOrderStatus(Integer orderStatus) 
    {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderStatus() 
    {
        return orderStatus;
    }

    public void setPaymentMethod(String paymentMethod) 
    {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentMethod() 
    {
        return paymentMethod;
    }

    public void setPaymentTime(Date paymentTime) 
    {
        this.paymentTime = paymentTime;
    }

    public Date getPaymentTime() 
    {
        return paymentTime;
    }

    public void setShippingTime(Date shippingTime) 
    {
        this.shippingTime = shippingTime;
    }

    public Date getShippingTime() 
    {
        return shippingTime;
    }

    public void setReceiveTime(Date receiveTime) 
    {
        this.receiveTime = receiveTime;
    }

    public Date getReceiveTime() 
    {
        return receiveTime;
    }

    public void setCancelTime(Date cancelTime) 
    {
        this.cancelTime = cancelTime;
    }

    public Date getCancelTime() 
    {
        return cancelTime;
    }

    public void setUserNote(String userNote) 
    {
        this.userNote = userNote;
    }

    public String getUserNote() 
    {
        return userNote;
    }

    public void setInvoiceNeeded(Integer invoiceNeeded) 
    {
        this.invoiceNeeded = invoiceNeeded;
    }

    public Integer getInvoiceNeeded() 
    {
        return invoiceNeeded;
    }

    public void setCreatedAt(Date createdAt) 
    {
        this.createdAt = createdAt;
    }

    public Date getCreatedAt() 
    {
        return createdAt;
    }

    public void setUpdatedAt(Date updatedAt) 
    {
        this.updatedAt = updatedAt;
    }

    public Date getUpdatedAt() 
    {
        return updatedAt;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("addressId", getAddressId())
            .append("productId", getProductId())
            .append("price", getPrice())
            .append("quantity", getQuantity())
            .append("totalAmount", getTotalAmount())
            .append("shippingFee", getShippingFee())
            .append("payAmount", getPayAmount())
            .append("orderStatus", getOrderStatus())
            .append("paymentMethod", getPaymentMethod())
            .append("paymentTime", getPaymentTime())
            .append("shippingTime", getShippingTime())
            .append("receiveTime", getReceiveTime())
            .append("cancelTime", getCancelTime())
            .append("userNote", getUserNote())
            .append("invoiceNeeded", getInvoiceNeeded())
            .append("createdAt", getCreatedAt())
            .append("updatedAt", getUpdatedAt())
            .toString();
    }
}
