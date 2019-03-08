public class TestObject {
    private int num = 0;
    private String str = "str";

    public TestObject() {

    }

    public TestObject(int num, String str) {
        this.num = num;
        this.str = str;
    }
    public static void main(String[] args) {
        TestObject seven = new TestObject(7,"seven");
        Stack something = new Stack();
        something.push(new TestObject(3,"stringboi"));
        something.push(seven);
        something.push(new TestObject());
        something.push(seven);

        while(!something.isEmpty()) {
            System.out.println(something.peak());
            something.pop();
        }


    }

    @Override
    public String toString() {
        return this.num + this.str;
    }
}
