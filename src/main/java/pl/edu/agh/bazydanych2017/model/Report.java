package pl.edu.agh.bazydanych2017.model;

public class Report {
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private String shipPostalCode;
    private String shipCountry;
    private String customerID;
    private String customersCompasnyName;
    private String address;
    private String city;
    private String region;
    private String postalCode;
    private String country;
    private String salesperson;
    private String orderID;
    private String orderDate;
    private String requiredDate;
    private String shippedDate;
    private String shipersCompanyName;
    private String productID;
    private String productName;
    private String unitPrice;
    private String quantity;
    private String discount;
    private String extendedPrice;
    private String freight;

    public Report(String shipName, String shipAddress, String shipCity, String shipRegion, String shipPostalCode, String shipCountry, String customerID, String customersCompasnyName, String address, String city, String region, String postalCode, String country, String salesperson, String orderID, String orderDate, String requiredDate, String shippedDate, String shipersCompanyName, String productID, String productName, String unitPrice, String quantity, String discount, String extendedPrice, String freight) {
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.shipCity = shipCity;
        this.shipRegion = shipRegion;
        this.shipPostalCode = shipPostalCode;
        this.shipCountry = shipCountry;
        this.customerID = customerID;
        this.customersCompasnyName = customersCompasnyName;
        this.address = address;
        this.city = city;
        this.region = region;
        this.postalCode = postalCode;
        this.country = country;
        this.salesperson = salesperson;
        this.orderID = orderID;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.shipersCompanyName = shipersCompanyName;
        this.productID = productID;
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.discount = discount;
        this.extendedPrice = extendedPrice;
        this.freight = freight;
    }

    public Report() {
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    public String getShipRegion() {
        return shipRegion;
    }

    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }

    public String getShipPostalCode() {
        return shipPostalCode;
    }

    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
    }

    public String getShipCountry() {
        return shipCountry;
    }

    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCustomersCompasnyName() {
        return customersCompasnyName;
    }

    public void setCustomersCompasnyName(String customersCompasnyName) {
        this.customersCompasnyName = customersCompasnyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSalesperson() {
        return salesperson;
    }

    public void setSalesperson(String salesperson) {
        this.salesperson = salesperson;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(String requiredDate) {
        this.requiredDate = requiredDate;
    }

    public String getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getShipersCompanyName() {
        return shipersCompanyName;
    }

    public void setShipersCompanyName(String shipersCompanyName) {
        this.shipersCompanyName = shipersCompanyName;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getExtendedPrice() {
        return extendedPrice;
    }

    public void setExtendedPrice(String extendedPrice) {
        this.extendedPrice = extendedPrice;
    }

    public String getFreight() {
        return freight;
    }

    public void setFreight(String freight) {
        this.freight = freight;
    }

    @Override
    public String toString() {
        return "Report{" +
                "shipName='" + shipName + '\'' +
                ", shipAddress='" + shipAddress + '\'' +
                ", shipCity='" + shipCity + '\'' +
                ", shipRegion='" + shipRegion + '\'' +
                ", shipPostalCode='" + shipPostalCode + '\'' +
                ", shipCountry='" + shipCountry + '\'' +
                ", customerID='" + customerID + '\'' +
                ", customersCompasnyName='" + customersCompasnyName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", region='" + region + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", salesperson='" + salesperson + '\'' +
                ", orderID='" + orderID + '\'' +
                ", orderDate='" + orderDate + '\'' +
                ", requiredDate='" + requiredDate + '\'' +
                ", shippedDate='" + shippedDate + '\'' +
                ", shipersCompanyName='" + shipersCompanyName + '\'' +
                ", productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", quantity='" + quantity + '\'' +
                ", discount='" + discount + '\'' +
                ", extendedPrice='" + extendedPrice + '\'' +
                ", freight='" + freight + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Report report = (Report) o;

        if (shipName != null ? !shipName.equals(report.shipName) : report.shipName != null) return false;
        if (shipAddress != null ? !shipAddress.equals(report.shipAddress) : report.shipAddress != null) return false;
        if (shipCity != null ? !shipCity.equals(report.shipCity) : report.shipCity != null) return false;
        if (shipRegion != null ? !shipRegion.equals(report.shipRegion) : report.shipRegion != null) return false;
        if (shipPostalCode != null ? !shipPostalCode.equals(report.shipPostalCode) : report.shipPostalCode != null)
            return false;
        if (shipCountry != null ? !shipCountry.equals(report.shipCountry) : report.shipCountry != null) return false;
        if (customerID != null ? !customerID.equals(report.customerID) : report.customerID != null) return false;
        if (customersCompasnyName != null ? !customersCompasnyName.equals(report.customersCompasnyName) : report.customersCompasnyName != null)
            return false;
        if (address != null ? !address.equals(report.address) : report.address != null) return false;
        if (city != null ? !city.equals(report.city) : report.city != null) return false;
        if (region != null ? !region.equals(report.region) : report.region != null) return false;
        if (postalCode != null ? !postalCode.equals(report.postalCode) : report.postalCode != null) return false;
        if (country != null ? !country.equals(report.country) : report.country != null) return false;
        if (salesperson != null ? !salesperson.equals(report.salesperson) : report.salesperson != null) return false;
        if (orderID != null ? !orderID.equals(report.orderID) : report.orderID != null) return false;
        if (orderDate != null ? !orderDate.equals(report.orderDate) : report.orderDate != null) return false;
        if (requiredDate != null ? !requiredDate.equals(report.requiredDate) : report.requiredDate != null)
            return false;
        if (shippedDate != null ? !shippedDate.equals(report.shippedDate) : report.shippedDate != null) return false;
        if (shipersCompanyName != null ? !shipersCompanyName.equals(report.shipersCompanyName) : report.shipersCompanyName != null)
            return false;
        if (productID != null ? !productID.equals(report.productID) : report.productID != null) return false;
        if (productName != null ? !productName.equals(report.productName) : report.productName != null) return false;
        if (unitPrice != null ? !unitPrice.equals(report.unitPrice) : report.unitPrice != null) return false;
        if (quantity != null ? !quantity.equals(report.quantity) : report.quantity != null) return false;
        if (discount != null ? !discount.equals(report.discount) : report.discount != null) return false;
        if (extendedPrice != null ? !extendedPrice.equals(report.extendedPrice) : report.extendedPrice != null)
            return false;
        return freight != null ? freight.equals(report.freight) : report.freight == null;
    }

    @Override
    public int hashCode() {
        int result = shipName != null ? shipName.hashCode() : 0;
        result = 31 * result + (shipAddress != null ? shipAddress.hashCode() : 0);
        result = 31 * result + (shipCity != null ? shipCity.hashCode() : 0);
        result = 31 * result + (shipRegion != null ? shipRegion.hashCode() : 0);
        result = 31 * result + (shipPostalCode != null ? shipPostalCode.hashCode() : 0);
        result = 31 * result + (shipCountry != null ? shipCountry.hashCode() : 0);
        result = 31 * result + (customerID != null ? customerID.hashCode() : 0);
        result = 31 * result + (customersCompasnyName != null ? customersCompasnyName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (salesperson != null ? salesperson.hashCode() : 0);
        result = 31 * result + (orderID != null ? orderID.hashCode() : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode() : 0);
        result = 31 * result + (requiredDate != null ? requiredDate.hashCode() : 0);
        result = 31 * result + (shippedDate != null ? shippedDate.hashCode() : 0);
        result = 31 * result + (shipersCompanyName != null ? shipersCompanyName.hashCode() : 0);
        result = 31 * result + (productID != null ? productID.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (unitPrice != null ? unitPrice.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        result = 31 * result + (extendedPrice != null ? extendedPrice.hashCode() : 0);
        result = 31 * result + (freight != null ? freight.hashCode() : 0);
        return result;
    }
}
