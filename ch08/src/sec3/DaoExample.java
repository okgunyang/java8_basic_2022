package sec3;

public class DaoExample {
    public static void dbwork(DataAccessObject dao){
        dao.select();
        dao.insert();
        dao.update();
        dao.delete();    
    }
    public static void main(String[] args){
        dbwork(new OracleDao());
        dbwork(new MySqlDao());
    }
}
