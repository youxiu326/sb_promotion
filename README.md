
###### 使用策略模式 实现一个基本的促销



```

    //加法
    BigDecimal result1 = num1.add(num2);
    //减法
    BigDecimal result2 = num1.subtract(num2);
    //乘法
    BigDecimal result3 = num1.multiply(num2);
    //除法
    BigDecimal result5 = num2.divide(num1,20,BigDecimal.ROUND_HALF_UP);
    //绝对值
    BigDecimal result4 = num3.abs();

    比较大小
    结果是:   -1：小于；   0 ：等于；   1 ：大于；
    BigDecimal b1 = new BigDecimal("-121454125453.145");
    if(b1.compareTo(BigDecimal.ZERO)==-1) {
    	System.out.println("金额为负数！");
    }

```


```
/**
 * 商品
 */
public class Product implements Serializable {

    private String code;

    private String name;

    /**
     * 销售价
     */
    private BigDecimal amount;

    /**
     * 优惠金额
     */
    private BigDecimal discountAmount;

    /**
     * 最终实付价格
     */
    private BigDecimal finalAmount;


    private Integer quantity;
 }

```