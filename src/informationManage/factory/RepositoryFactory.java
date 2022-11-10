package informationManage.factory;

import informationManage.dataAccessObject.BookDAO;
import informationManage.dataAccessObject.BookRentDAO;
import informationManage.dataAccessObject.DAOInterface;
import informationManage.enums.RepoType;


public class RepositoryFactory {
    private RepositoryFactory(){

    }
    public static DAOInterface createRepository(RepoType type){

        switch (type){
            case BOOK: return new BookDAO();
            case BOOKRENT: return new BookRentDAO();
            default:throw new IllegalArgumentException("thieu tham so");
        }
    }
}
