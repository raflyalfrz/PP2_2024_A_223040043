package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.MyBatisUtil;
import model.User;
import model.UserMapper;
import org.apache.ibatis.session.SqlSession;
import view.UserPdf;
import view.UserView;

public class UserController {

    private UserView view;
    private UserMapper mapper;
    private UserPdf pdf;

    public UserController(UserView view, UserMapper mapper, UserPdf pdf) {
        this.view = view;
        this.mapper = mapper;
        this.pdf = pdf;

        // Menambahkan action listener untuk tombol "Add User"
        view.addAddUserListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ambil input nama dan email dari GUI
                String name = view.getNameInput();
                String email = view.getEmailInput();

                if (name.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Nama dan email tidak boleh kosong.");
                    return;
                }

                // Tambahkan user ke database dengan menggunakan MyBatis
                SqlSession session = MyBatisUtil.getSqlSession();
                try {
                    User user = new User();
                    user.setName(name);
                    user.setEmail(email);

                    // Menyimpan data user ke database
                    mapper.insertUser(user);
                    session.commit(); // Commit perubahan ke database

                    // Memberikan notifikasi sukses
                    JOptionPane.showMessageDialog(view, "User berhasil ditambahkan!");
                    
                    // Refresh UI jika diperlukan
                    refreshUserList();
                } catch (Exception ex) {
                    // Menangani kesalahan
                    if (session != null) {
                        session.rollback();  // Rollback jika terjadi kesalahan
                    }
                    JOptionPane.showMessageDialog(view, "Terjadi kesalahan saat menambahkan user.");
                    ex.printStackTrace();
                } finally {
                    if (session != null) {
                        session.close();  // Menutup session
                    }
                }
            }
        });
    }

    // Fungsi untuk me-refresh daftar user
    private void refreshUserList() {
        SqlSession session = MyBatisUtil.getSqlSession();
        try {
            // Ambil data user terbaru
            java.util.List<User> userList = mapper.getAllUsers();
            String[] users = new String[userList.size()];
            for (int i = 0; i < userList.size(); i++) {
                users[i] = userList.get(i).getName() + " (" + userList.get(i).getEmail() + ")";
            }
            view.setUserList(users);  // Update tampilan dengan daftar user terbaru
        } finally {
            if (session != null) {
                session.close();  // Pastikan session ditutup
            }
        }
    }
}
