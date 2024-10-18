interface Program {
	String getCode();
	String getType();
	void runProgram();
}

class PythonProgram implements Program {

	public String getCode() {
		return "print \"hello world\"";
	}

	public String getType() {
		return "Python";
	}

	public void runProgram() {
		System.out.println("Running Python program: " + getCode());
	}

}

class RubyProgram implements Program {

	public String getCode() {
		return "puts \'hello world\'";
	}

	public String getType() {
		return "Ruby";
	}

	public void runProgram() {
		System.out.println("Running Ruby program: " + getCode());
	}

}

class JavaProgram implements Program {

    public String getCode() {
        return "System.out.println(\"hello world\");";
    }

    public String getType() {
        return "Java";
    }

    public void runProgram() {
        System.out.println("Running Java program: " + getCode());
    }

}


public class OpenClosedPrincipleGood {
    public static void main(String[] args) {

        Program java = new JavaProgram();
        Program python = new PythonProgram();
        Program ruby = new RubyProgram();

        java.runProgram();
        python.runProgram();
        ruby.runProgram();

    }
}
