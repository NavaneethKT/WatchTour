/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package watchtour;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Muneeb
 */
public class GetRecommendedMovies extends javax.swing.JFrame {

    private String mail;
    /**
     * Creates new form GetRecommendedMovies
     */
    public GetRecommendedMovies(String mail) {
        this.mail = mail;
        initComponents();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","muneeb");  
            PreparedStatement pstmt = con.prepareStatement("select username from users where email = ?");
            pstmt.setString(1, mail);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) 
                uname.setText(rs.getString(1));
            pstmt = con.prepareStatement("select liked_genre from user_genres where email = ? and rownum <= 5");
            pstmt.setString(1, mail);
            rs = pstmt.executeQuery();
            ArrayList<String> liked = new ArrayList<String>(); 
            while(rs.next()){
                System.out.println(rs.getString(1));
                liked.add(rs.getString(1));
            }
            int n = liked.size();
            movieCards.setLayout(new java.awt.GridLayout(3, 3, 10, 10));
            if(n == 0){
                pstmt = con.prepareStatement("select id from movies where rownum <= 9 order by rating desc");
                rs = pstmt.executeQuery();
                if(rs.next()){
                    movieCards.add(new MovieCard(rs.getInt(1), mail));
                }
            }
            else if(n == 1){
                pstmt = con.prepareStatement("select id from movies where rownum <= 9 and genre = ? order by rating desc");
                pstmt.setString(1, liked.get(0));
                rs = pstmt.executeQuery();
                while(rs.next()){
                    movieCards.add(new MovieCard(rs.getInt(1), mail));
                }
            }
            else if(n == 2){
                pstmt = con.prepareStatement("select id from movies where rownum <= 5 and genre = ? order by rating desc");
                pstmt.setString(1, liked.get(0));
                rs = pstmt.executeQuery();
                while(rs.next()){
                    movieCards.add(new MovieCard(rs.getInt(1), mail));
                }
                pstmt = con.prepareStatement("select id from movies where rownum <= 4 and genre = ? order by rating desc");
                pstmt.setString(1, liked.get(1));
                rs = pstmt.executeQuery();
                while(rs.next()){
                    movieCards.add(new MovieCard(rs.getInt(1), mail));
                }
            }
            else if(n == 3){
                for(int i = 0; i < 3; i++){
                    pstmt = con.prepareStatement("select id from movies where rownum <= 3 and genre = ? order by rating desc");
                    pstmt.setString(1, liked.get(i));
                    rs = pstmt.executeQuery();
                    while(rs.next()){
                        movieCards.add(new MovieCard(rs.getInt(1), mail));
                    }
                }
            }
            else if(n == 4){
                pstmt = con.prepareStatement("select id from movies where rownum <= 3 and genre = ? order by rating desc");
                pstmt.setString(1, liked.get(0));
                rs = pstmt.executeQuery();
                while(rs.next()){
                    movieCards.add(new MovieCard(rs.getInt(1), mail));
                }
                for(int i = 1; i < 4; i++){
                    pstmt = con.prepareStatement("select id from movies where rownum <= 2 and genre = ? order by rating desc");
                    pstmt.setString(1, liked.get(i));
                    rs = pstmt.executeQuery();
                    while(rs.next()){
                        movieCards.add(new MovieCard(rs.getInt(1), mail));
                    }
                }
            }
            else{
                pstmt = con.prepareStatement("select id from movies where rownum <= 1 and genre = ? order by rating desc");
                pstmt.setString(1, liked.get(0));
                rs = pstmt.executeQuery();
                while(rs.next()){
                    movieCards.add(new MovieCard(rs.getInt(1), mail));
                }
                for(int i = 1; i < 5; i++){
                    pstmt = con.prepareStatement("select id from movies where rownum <= 2 and genre = ? order by rating desc");
                    pstmt.setString(1, liked.get(i));
                    rs = pstmt.executeQuery();
                    while(rs.next()){
                        movieCards.add(new MovieCard(rs.getInt(1), mail));
                    }
                }
            }
            con.close();  
        }catch(Exception e){
            System.out.println(e);
        }  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        uname = new javax.swing.JLabel();
        LOGIN1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        movieCards = new javax.swing.JPanel();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        uname.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        uname.setText("foo");

        LOGIN1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LOGIN1.setText("WATCH TOUR");

        movieCards.setLayout(new java.awt.GridBagLayout());
        jScrollPane1.setViewportView(movieCards);

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(back)
                .addGap(746, 746, 746)
                .addComponent(LOGIN1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 859, Short.MAX_VALUE)
                .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(jScrollPane1)
                    .addGap(3, 3, 3)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(uname))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LOGIN1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(831, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(79, 79, 79)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(30, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.dispose();
        new UserPage(mail).setVisible(true);
    }//GEN-LAST:event_backActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LOGIN1;
    private javax.swing.JButton back;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel movieCards;
    private javax.swing.JLabel uname;
    // End of variables declaration//GEN-END:variables
}
