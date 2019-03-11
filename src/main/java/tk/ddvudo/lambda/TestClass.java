package tk.ddvudo.lambda;

public class TestClass {
    private String id;
    private int age;
    private long money;

    public TestClass(String id, int age, long money) {
        super();
        this.id = id;
        this.age = age;
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "TestClass [id=" + id + ", age=" + age + ", money=" + money + "]";
    }
}
