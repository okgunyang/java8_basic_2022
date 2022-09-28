package sec1;

public class Parent {
	int field1;
	String field2;
	
	public Parent() { }
	public Parent(int field1){ 
		//this.field1=field1;
		this(field1, "kim");
	}
	public Parent(int field1, String field2){
		this.field1=field1;
		this.field2=field2;
	}
	public void method1(){ }
	public int method2() { return field1+100; }
}
