package Tugas.StudyKasus2.scr;

import org.apache.ibatis.session.SqlSession;

import Tugas.StudyKasus2.scr.controller.UserController;
import Tugas.StudyKasus2.scr.model.MyBatisUtil;
import Tugas.StudyKasus2.scr.model.UserMapper;
import Tugas.StudyKasus2.scr.view.UserView;

public class Main {
    public static void main(String[] args) {
        SqlSession session = MyBatisUtil.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);

        UserView view = new UserView();
        new UserController(view, mapper);

        view.setVisible(true);
    }
}
