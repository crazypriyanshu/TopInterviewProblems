package org.pdas.LLD.FlexiShip;

import java.math.BigDecimal;
import java.util.Objects;

public class Order {
    private final long id;
    private BigDecimal price;
    private final int weight;
    private final int distance;
    private final String shippingProvider;
    private final CustomerTypes customerType;

    public long getId() {
        return id;
    }


    public int getWeight() {
        return weight;
    }

    public int getDistance() {
        return distance;
    }

    public String getShippingProvider(){
        return shippingProvider;
    }

    public CustomerTypes getCustomerType(){
        return customerType;
    }

    private Order(Builder builder){
        this.id = builder.id;
        this.price = builder.price;
        this.weight = builder.weight;
        this.distance = builder.distance;
        this.shippingProvider = builder.shippingProvider;
        this.customerType = builder.customerType;

    }

    public static Builder builder(){
        return new Builder();
    }


    public static class Builder{
        private long id;
        private BigDecimal price;
        private int weight;
        private int distance;
        private String shippingProvider;
        private CustomerTypes customerType;

        public Builder Id(long id){
            this.id = id;
            return this;
        }

        public Builder customerType(CustomerTypes customerType){
            this.customerType = customerType;
            return this;
        }

        public Builder shippingProvider(String shippingProvider){
            this.shippingProvider = shippingProvider;
            return this;
        }

        public Builder weight(int weight){
            this.weight = weight;
            return this;
        }

        public Builder distance(int distance){

            this.distance = distance;
            return this;
        }

        private void validate(){
            // keeping validate as another function as to cater a condition when we are getting data from Db, where some invalid data was there, and if we just want when building a new Object donot have that condition
            if (this.distance <= 0){
                throw new IllegalStateException("Distance can't be less than or equal to 0");
            }

            if (this.weight <= 0){
                throw new IllegalStateException("Weight can't be less than or equal to 0");
            }

            if (this.shippingProvider.startsWith("DHL")){

            }

        }

        public Order build(){
            validate();
            return new Order(this);
        }


    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", weight=" + weight +
                ", distance=" + distance +
                ", shippingProvider='" + shippingProvider + '\'' +
                ", customerType=" + customerType +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || !(object instanceof Order)) return false;
        Order order = (Order) object;
        return id == order.id &&
                weight == order.weight &&
                distance == order.distance;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, distance, weight);
    }
}
