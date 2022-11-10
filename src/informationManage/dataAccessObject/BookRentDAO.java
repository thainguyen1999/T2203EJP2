package informationManage.dataAccessObject;

import java.util.ArrayList;

public class BookRentDAO implements DAOInterface {
    public static BookRentDAO getInstance(){
        return new BookRentDAO();
    }
    @Override
    public int insert(Object o) {
        return 0;
    }

    @Override
    public int update(Object o) {
        return 0;
    }

    @Override
    public int delete(Object o) {
        return 0;
    }

    @Override
    public int findOne(Integer id) {
        return 0;
    }

    @Override
    public ArrayList selectAll() {
        return null;
    }

    @Override
    public Object selectById(Object o) {
        return null;
    }

    @Override
    public ArrayList selectCondition(String condition) {
        return null;
    }
}
