package sec3;

public class DbBoard implements Dbjob {

	@Override
	public void insert() {
		System.out.println("insert into board values (?, ?, ?)");
	}

	@Override
	public void update() {
		System.out.println("update board set=? where bid=?");
	}

	@Override
	public void delete() {
		System.out.println("delete from board where bid=?");
	}

	@Override
	public void select() {
		System.out.println("select * from board where bid=?");
	}
}
