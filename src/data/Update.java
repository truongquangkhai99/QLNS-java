/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.TimeZone;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import static jdk.nashorn.internal.objects.NativeString.toUpperCase;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author huu21
 */
public class Update {

    public static PreparedStatement ps;
    public static ResultSet rs;
    public static TimeZone tz = TimeZone.getTimeZone("Asia/Ho_Chi_Minh");
    public static Calendar calTZ = new GregorianCalendar(tz);
    static JTable table;
    static String[] Employees = {"Employee1", "Employee2", "Employee3", "Employee4"};

    public static void LoadData(Connection con, String sql, JTable table) {
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs));
            table.getColumnModel().getColumn(0).setHeaderValue("After");
            table.getColumnModel().getColumn(1).setHeaderValue("Before");
// Forces the header to resize and repaint itself
            table.getTableHeader().resizeAndRepaint();
        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e, "Lỗi", 1);
        }
        // Connect.FreeConnection();
    }

    public static ResultSet showTextFile(Connection con, String sql) {
        try {
            ps = con.prepareStatement(sql);
            return ps.executeQuery();
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public static String GetToDay() {

        //lich duong
        return calTZ.get(Calendar.YEAR) + "/" + (calTZ.get(Calendar.MONTH) + 1) + "/" + calTZ.get(Calendar.DATE);
        //trong java thang bat dau tu 0 -->11
    }

    public static int getMonth() {
        return (calTZ.get(Calendar.MONTH) + 1);
    }

    public static int getYear() {
        return calTZ.get(Calendar.YEAR);
    }

    public static String CodeXXX() {
        int x, y, z, k, r;
        char a, b, c, d;
        String temp = null;
        Random ran = new Random();
        x = ran.nextInt(5);
        y = ran.nextInt(5);
        z = ran.nextInt(5);
        k = ran.nextInt(5);
        a = (char) (ran.nextInt(26) + 'a');
        b = (char) (ran.nextInt(26) + 'a');
        c = (char) (ran.nextInt(26) + 'a');
        d = (char) (ran.nextInt(26) + 'a');
        r = 1 + ran.nextInt(4);
        switch (r) {
            case 1:
                temp = x + "" + k + "a" + "b" + z + "" + y;
                break;
            case 2:
                temp = x + "a" + k + "b" + z + "c";
                break;
            case 3:
                temp = "a" + k + "b" + z + "c" + x;
                break;
            case 4:
                temp = "c" + "d" + x + "" + k + "a" + "b";
                break;

        }
        temp = toUpperCase(temp);
        return temp;

    }

}
