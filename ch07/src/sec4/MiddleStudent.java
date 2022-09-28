package sec4;

public class MiddleStudent extends Student {
	private int jum4;

	public int getJum4() {
		return jum4;
	}

	public void setJum4(int jum4) {
		this.jum4 = jum4;
	}

	@Override
	int computeTot(int jum1, int jum2, int jum3) {
		return jum1+jum2+jum3+jum4;
	}

	@Override
	double computeAvg(int jum1, int jum2, int jum3) {
		return (float) (jum1+jum2+jum3+jum4)/4;
	}

	@Override
	public String computeHak(int jum1, int jum2, int jum3) {
		int tot = jum1+jum2+jum3+jum4;
		if(tot/4>=90){
			return "A";
		} else if(tot/4>=80){
			return "B";
		} else if(tot/4>=70){
			return "C";
		} else if(tot/4>=60){
			return "D";
		} else {
			return "F";
		}
	}
	
}
