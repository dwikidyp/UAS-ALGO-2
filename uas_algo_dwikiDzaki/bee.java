import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Write a description of class bee here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bee extends Actor
{
    /**
     * Act - do whatever the bee wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        tampil_data();
        kunci_kontrol();
    }
    public void tampil_data(){
        try{
            String sql = "SELECT * FROM arah";
            java.sql.Connection conn = (Connection)koneksi.koneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next()){
                res.getString("kunci database: "+res.getString(1));
            }
        }catch (Exception e){
            
        }
    }
    
    public void kunci_kontrol()
    {
        if(Greenfoot.isKeyDown("d"))
        {
            move(4);
        }
        
        if(Greenfoot.isKeyDown("a"))
        {
            move(-4);
        }
        
        if(Greenfoot.isKeyDown("s"))
        {
            setLocation(getX(),getY()+4);
        }
        
        if(Greenfoot.isKeyDown("w"))
        {
            setLocation(getX(),getY()-4);
        }
    }
}
