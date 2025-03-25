package JDBC;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class JDBConnection extends JFrame {
    public JDBConnection() {
        // JFrame 설정
        setTitle("Project Plan");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 데이터베이스 연결 정보 설정
        String url = "jdbc:mysql://localhost:3306/project"; // 데이터베이스 URL
        String user = "root"; // MySQL 사용자 이름
        String password = "1234"; // MySQL 비밀번호

        Connection conn = null; // 데이터베이스 연결을 위한 Connection 객체
        Statement stmt = null; // SQL 문을 실행하기 위한 Statement 객체
        ResultSet rs = null; // SQL 쿼리 결과를 저장하기 위한 ResultSet 객체

        try {
            // MySQL JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 데이터베이스 연결 설정
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("데이터베이스에 연결되었습니다!");

            // SQL 쿼리 작성 및 실행
            String query = "SELECT * FROM plan"; // plan 테이블에서 모든 데이터 조회
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            // JTable 데이터 모델 설정
            DefaultTableModel model = new DefaultTableModel(new String[]{"PjName", "StartDate", "EndDate", "State"}, 0);
            while (rs.next()) {
                String pjName = rs.getString("PjName"); // 프로젝트 이름
                String startDate = rs.getDate("StartDate") != null ? rs.getDate("StartDate").toString() : null; // 시작일
                String endDate = rs.getDate("EndDate") != null ? rs.getDate("EndDate").toString() : null; // 종료일
                String state = rs.getString("state"); // 상태

                // 모델에 데이터 추가
                model.addRow(new Object[]{pjName, startDate, endDate, state});
            }

            // JTable 설정 및 JScrollPane에 추가
            JTable table = new JTable(model);
            add(new JScrollPane(table), BorderLayout.CENTER);

        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
        } finally {
            // 리소스 정리
            try {
                if (rs != null) rs.close(); // ResultSet 객체 닫기
                if (stmt != null) stmt.close(); // Statement 객체 닫기
                if (conn != null) conn.close(); // Connection 객체 닫기
            } catch (Exception e) {
                e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력
            }
        }
    }

    public static void main(String[] args) {
        // Swing GUI 시작
        SwingUtilities.invokeLater(() -> {
            JDBConnection frame = new JDBConnection();
            frame.setVisible(true);
        });
    }
}
