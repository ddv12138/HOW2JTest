package tk.ddvudo.multiThread.DeadLock;

public class Resource {
	String name;

	public Resource(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Resource [name=" + name + "]";
	}
	
}
