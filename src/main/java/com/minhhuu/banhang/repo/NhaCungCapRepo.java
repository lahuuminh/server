package com.minhhuu.banhang.repo;

import com.minhhuu.banhang.model.NCC;
import com.minhhuu.banhang.util.ConnectDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Component
public class NhaCungCapRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public NhaCungCapRepo() {
        connection= ConnectDB.con();
    }

    private final Connection connection;

    public void update(NCC ncc) throws SQLException {

        System.out.println(ncc);
        String sql = "UPDATE nhacungcap SET ten=?,diachi=?,email=?,soDienThoai=? where manhacungcap=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);

        preparedStatement.setString(1,ncc.getTen());
        preparedStatement.setString(2,ncc.getDiaChi());
        preparedStatement.setString(3,ncc.getEmail());
        preparedStatement.setString(4,ncc.getSoDienThoai());
        preparedStatement.setInt(5,ncc.getManhacungcap());
        int row=preparedStatement.executeUpdate();
        System.out.println(row);
        if(row==0){
            throw new EmptyResultDataAccessException("Không tìm thấy bản ghi với ID: "+ncc.getManhacungcap(), 1);
        }
    }
    public void deleteById(Long id) throws SQLException {
        String sql = "DELETE FROM nhacungcap WHERE manhacungcap = ?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setLong(1,id);
        int row=  preparedStatement.executeUpdate();
        if(row==0){
            throw new EmptyResultDataAccessException("Không tìm thấy bản ghi với ID: " + id, 1);
        }
    }
    public  void create(NCC ncc) throws SQLException {
        System.out.println(ncc);
        String sql="insert into nhacungcap(ten,diachi,email,soDienThoai) values(?,?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setString(1,ncc.getTen());
        preparedStatement.setString(2,ncc.getDiaChi());
        preparedStatement.setString(3,ncc.getEmail());
        preparedStatement.setString(4,ncc.getSoDienThoai());
        preparedStatement.executeUpdate();

    }
    public List<NCC>findAll() throws SQLException {
        List<NCC>l=new ArrayList<>();
        String sql="select * from nhacungcap";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
       ResultSet rs= preparedStatement.executeQuery();
       while (rs.next()){
           NCC ncc=new NCC();
           ncc.setManhacungcap(rs.getInt("manhacungcap"));
           ncc.setTen(rs.getString("ten"));
           ncc.setDiaChi(rs.getString("diachi"));
           ncc.setEmail(rs.getString("email"));
           ncc.setSoDienThoai(rs.getString("soDienThoai"));
           l.add(ncc);
       }
       return l;
    }
    public NCC findById(Long id) throws SQLException {
        NCC ncc=new NCC();
        String sql="select * from nhacungcap where manhacungcap=?";
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        preparedStatement.setLong(1,id);
        ResultSet rs= preparedStatement.executeQuery();
        if(rs.next()){
            ncc.setManhacungcap(rs.getInt("manhacungcap"));
            ncc.setTen(rs.getString("ten"));
            ncc.setDiaChi(rs.getString("diachi"));
            ncc.setEmail(rs.getString("email"));
            ncc.setSoDienThoai(rs.getString("soDienThoai"));
        }
        return ncc;
    }

    public List<NCC> timKiemNCCByFieldAndOrder(String ten, String diachi, String email) {
        String sql = "SELECT * FROM nhacungcap ";
        if((ten!=null&&!ten.isBlank())||(diachi!=null&&!diachi.isBlank())||email!=null&&!email.isBlank()){
            sql+="where"+" ";
        }
        if (ten!=null&&!ten.isBlank()) {
            sql += "ten LIKE ? AND ";
        }
        if (diachi!=null&&!diachi.isBlank()) {
            sql += "diachi like ? AND ";
        }
        if (email!=null&&!email.isBlank()) {
            sql += "email  like ? AND ";
        }
        if (sql.endsWith("AND ")) {
            sql = sql.substring(0, sql.length() - 4);
        }

        // Chuẩn bị tham số
        List<Object>params=new ArrayList<>();
        if (ten!=null&&!ten.isBlank()) {
//            o[0]="%" + ten+ "%";
            params.add("%" + ten+ "%");
        }
        if (diachi!=null&&!diachi.isBlank()) {
            params.add("%" + diachi+ "%");
        }
        if (email!=null&&!email.isBlank()) {
            params.add("%" + email+ "%");
        }


        // Truy vấn dữ liệu
        Object o[]=   params.toArray();
        System.out.println(o.length);
        System.out.println(sql);
        List<NCC> sanPhams =jdbcTemplate.query(sql,o, new RowMapper<NCC>() {
            @Override
            public NCC mapRow(ResultSet rs, int rowNum) throws SQLException {
                NCC ncc=new NCC();
                ncc.setManhacungcap(rs.getInt("manhacungcap"));
                ncc.setTen(rs.getString("ten"));
                ncc.setDiaChi(rs.getString("diachi"));
                ncc.setEmail(rs.getString("email"));
                ncc.setSoDienThoai(rs.getString("soDienThoai"));
                return ncc;
            }
        });

        return sanPhams;
    }

    public List<NCC> order(String id) throws SQLException {
        String sql="select * from nhacungcap order by "+id;
        PreparedStatement preparedStatement=connection.prepareStatement(sql);
        ResultSet rs= preparedStatement.executeQuery();
        List<NCC>l=new ArrayList<>();
        while (rs.next()){
            NCC ncc=new NCC();
            ncc.setManhacungcap(rs.getInt("manhacungcap"));
            ncc.setTen(rs.getString("ten"));
            ncc.setDiaChi(rs.getString("diachi"));
            ncc.setEmail(rs.getString("email"));
            ncc.setSoDienThoai(rs.getString("soDienThoai"));
            l.add(ncc);
        }
        return l;
    }
}
