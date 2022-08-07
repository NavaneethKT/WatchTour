/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package watchtour;
import java.sql.*;

/**
 *
 * @author Muneeb
 */
public class NameSearch extends javax.swing.JFrame {

    /**
     * Creates new form NameSearch
     */
    private String mail;
    private String name;
    
    public NameSearch(String mail, String name) {
        this.mail = mail;
        this.name = name;
        initComponents();
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","muneeb");  
            PreparedStatement pstmt = con.prepareStatement("select username from users where email = ?");
            pstmt.setString(1, mail);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                uname.setText(rs.getString(1));
            }
            pstmt = con.prepareStatement("select id from movies where movie_name = ?");
            pstmt.setString(1, name);
            movieCards.setLayout(new java.awt.GridLayout(3, 3, 10, 10));
            rs = pstmt.executeQuery();
            while(rs.next()){
                movieCards.add(new MovieCard(rs.getInt(1), mail));
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
        LOGIN = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        movieCards = new javax.swing.JPanel();
        back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        uname.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        uname.setText("foo");

        LOGIN.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LOGIN.setText("WATCH TOUR");

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(back)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 868, Short.MAX_VALUE)
                        .addComponent(LOGIN)
                        .addGap(819, 819, 819)
                        .addComponent(uname, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(258, 258, 258))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(uname))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LOGIN)
                            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        this.dispose();
        new SearchMovies(mail).setVisible(true);
    }//GEN-LAST:event_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LOGIN;
    private javax.swing.JButton back;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel movieCards;
    private javax.swing.JLabel uname;
    // End of variables declaration//GEN-END:variables
}