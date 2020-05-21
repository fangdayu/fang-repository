package team.ustc.sensor.entity;


/**
 * 传感器实体类
 */
public class Sensor {
    //传感器id
    private Integer id;
    //传感器品牌
    private String brand;
    //产品ID
    private String product_id;
    //产品类型
    private String type;
    //产品具体类型
    private String type_detail;
    //输入电气特性
    private String input;
    //输出电气特性
    private String output;
    //使用环境
    private String using_environment;
    //量程范围
    private String sRange;
    //级别
    private String sLevel;
    //应用
    private String application;
    //产品描述
    private String description;
    //优势
    private String strength;
    //其它
    private String more_detail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType_detail() {
        return type_detail;
    }

    public void setType_detail(String type_detail) {
        this.type_detail = type_detail;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getUsing_environment() {
        return using_environment;
    }

    public void setUsing_environment(String using_environment) {
        this.using_environment = using_environment;
    }

    public String getsRange() {
        return sRange;
    }

    public void setsRange(String sRange) {
        this.sRange = sRange;
    }

    public String getsLevel() {
        return sLevel;
    }

    public void setsLevel(String sLevel) {
        this.sLevel = sLevel;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStrength() {
        return strength;
    }

    public void setStrength(String strength) {
        this.strength = strength;
    }

    public String getMore_detail() {
        return more_detail;
    }

    public void setMore_detail(String more_detail) {
        this.more_detail = more_detail;
    }
}
