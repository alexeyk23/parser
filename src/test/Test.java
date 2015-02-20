/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author admin
 */
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;

public class Test {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException 
    {
        Connector c = new Connector();
       try
       {
           c.setConnection();
       }
       catch(ClassNotFoundException | SQLException e)
       {
           System.err.println(e.getMessage());
       }
        HtmlCleaner hcleaner = new HtmlCleaner();
        TagNode tagNode =  hcleaner.clean(new URL("http://fapl.ru/posts/38123/"),"WINDOWS-1251");
        TagNode[] tags= tagNode.getElementsByAttValue("class","content",true,false);       
 
        StringBuilder sb    = new StringBuilder();
        if(tags.length>0 && tags[0].getName().equals("div"))            
        {
            
            for (TagNode t : tags[0].getElementListByName("p", true)) 
            {
                sb.append(t.getText());
            }
        }
        //   System.out.println(sb.toString());
        try {
          c.addArticle("AGA",sb.toString(), "12/12/12");
         
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
