package Exercise1;

public class Main {
	public static void main(String[] args) {
		
		DbUserWriteRepository db = new DbUserWriteRepository();
		User dt = new User("aleqsi","aleqsi@gmail.com");
		
		db.save(dt);
		dt.setEmail("dsfhlflsd@gmail.com");
		dt.setName("jumberi");
		db.update(dt);
		db.delete((long) 1);
	}
}