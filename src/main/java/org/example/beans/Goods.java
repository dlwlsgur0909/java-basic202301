package org.example.beans;

import java.util.Objects;

public class Goods {

    // 자바 beans(Entity, DTO, VO 등) 규약

    // 핃드를 설계할 때 private, protected 제한자를 사용

    private final Long goodsId; // 상품번호
    private String goodsName; // 상품명
    private Integer price; // 상품 가격

    // 기본 생성자는 필수

    public Goods() {
        this.goodsId = 1L;
    }
    public Goods(String goodsName, Integer price) {
        this();
        this.goodsName = goodsName;
        this.price = price;
    }

    // Setter / Getter (규약에서는 필수라 하지만 실무에선 선택적)
    // 불변하는 값은 필드애 final을 선언하고 setter는 만들지 않는다
    // getter는 보통 다 만들어준다


    public Long getGoodsId() {
        return goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


    // toString 오버라이딩

//    @Override
//    public String toString() {
//        return String.format("상품번호: %d, 상품명: %s, 상품가격: %d원", goodsId, goodsName, price);
//    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", price=" + price +
                '}';
    }


    // equals 오버라이딩 룰
    // equals를 오버라이딩 하면 항상 hashCode도 같이 오버라이딩 해줘야 한다

//    @Override
//    public boolean equals(Object obj) {
//        if(!(obj instanceof Goods)) {
//            return false;
//        }
//        Goods target = (Goods) obj;
//
//        return      this.goodsId == target.getGoodsId()
//                && this.goodsName.equals(target.getGoodsName())
//                && this.price == target.getPrice();
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods goods = (Goods) o;
        return Objects.equals(goodsId, goods.goodsId) && Objects.equals(goodsName, goods.goodsName) && Objects.equals(price, goods.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(goodsId, goodsName, price);
    }
}
